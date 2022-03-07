在SpringBoot启动日志中发现JPA的警告日志，具体如下

spring.jpa.open-in-view is enabled by default.
Therefore, database queries may be performed during view rendering.
Explicitly configure spring.jpa.open-in-view to disable this warning


猜想可能是由于这个配置问题，于是开始找Spring Data JPA相关文档。
发现这个配置会导致MVC的Controller执行完对数据库操作后，仍然持有数据库连接。一直到Controller方法完全结束，才会释放数据库连接。
因为对于JPA（默认是Hibernate实现）来说，ToMany关系默认是懒加载，ToOne关系默认是立即加载。
当我们通过JPA查询到一个对象之后，可能会去调用ToMany关系对应实体的get方法，获取对应实体集合，
如果此时没有Hibernate Session会报LazyInitializationException异常，所以默认情况下MVC的Controller方法执行完成之后才会释放数据库连接。


查看spring.jpa.open-in-view对应的拦截器源码
```java
public class OpenEntityManagerInViewInterceptor extends EntityManagerFactoryAccessor implements AsyncWebRequestInterceptor {

	@Override
	public void preHandle(WebRequest request) throws DataAccessException {

		EntityManagerFactory emf = obtainEntityManagerFactory();
		if (TransactionSynchronizationManager.hasResource(emf)) {
            // ...
		}
		else {
			logger.debug("Opening JPA EntityManager in OpenEntityManagerInViewInterceptor");
			try {
                // 创建EntityManager并绑定到当前线程
				EntityManager em = createEntityManager();
				EntityManagerHolder emHolder = new EntityManagerHolder(em);
				TransactionSynchronizationManager.bindResource(emf, emHolder);

				AsyncRequestInterceptor interceptor = new AsyncRequestInterceptor(emf, emHolder);
				asyncManager.registerCallableInterceptor(key, interceptor);
				asyncManager.registerDeferredResultInterceptor(key, interceptor);
			}
			catch (PersistenceException ex) {
				throw new DataAccessResourceFailureException("Could not create JPA EntityManager", ex);
			}
		}
	}

	@Override
	public void afterCompletion(WebRequest request, @Nullable Exception ex) throws DataAccessException {
        // 关闭EntityManager
		if (!decrementParticipateCount(request)) {
			EntityManagerHolder emHolder = (EntityManagerHolder)
					TransactionSynchronizationManager.unbindResource(obtainEntityManagerFactory());
			logger.debug("Closing JPA EntityManager in OpenEntityManagerInViewInterceptor");
			EntityManagerFactoryUtils.closeEntityManager(emHolder.getEntityManager());
		}
	}

	@Override
	public void afterConcurrentHandlingStarted(WebRequest request) {
        // 解除绑定
		if (!decrementParticipateCount(request)) {
			TransactionSynchronizationManager.unbindResource(obtainEntityManagerFactory());
		}
	}

}
```


结论:
由于没有配置spring.jpa.open-in-view（默认为true），JPA方法执行完成之后，并没有释放数据库连接（需要等到Controller方法执行完成才会释放），
而恰好由于异常导致ReentrantLock锁没有正确释放，进而导致其他已经获取到数据库连接的线程无法获取ReentrantLock锁，
其他线程也无法获取到数据库连接（其中就包含持有ReentrantLock锁的线程），最终导致死锁。修复的方法非常简单，finally代码块中释放锁，
并且关闭spring.jpa.open-in-view配置（可选）。

对于spring.jpa.open-in-view这个配置大致存在两种观点，一种认为需要这个配置，它有利于提升开发效率，
另一个部分人认为这个配置会影响到性能（Controller方法执行完成之后才释放连接），造成资源的浪费。
但是如果执行完数据库操作就释放连接的话，就无法通过get方法获取ToMany关系对应的实体集合（或者获取手动获取，但显然不合适）。

其实这两种观点没有对错，只不过需要根据业务实际情况作出选择。我猜想可能出于这种考虑，
官方才在用户没有主动配置spring.jpa.open-in-view的时候，在启动的过程中打印出一条警告日志，通知用户关注此项配置，然后作出选择。