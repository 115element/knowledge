Hystrix的设计原则包括:资源隔离、熔断器、命令模式。
   
#1.资源隔离：
货船为了进行防止漏水和火灾的扩散,会将货仓分隔为多个，这种资源隔离减少风险的方式被称为：Bulkheads(舱壁隔离模式)。
Hystrix将同样的模式运用到了服务调用者上，在一个高度服务化的系统中，一个业务逻辑通常会依赖多个服务，
比如：商品详情展示服务会依赖商品服务，价格服务，商品评论服务。调用三个依赖服务会共享商品详情服务的线程池。
如果其中的商品评论服务不可用，就会出现线程池里所有线程都因等待响应而被阻塞，从而造成服务雪崩。
Hystrix通过将每个依赖服务分配独立的线程池进行资源隔离，从而避免服务雪崩。

#2.熔断器模式
熔断器模式定义了熔断器开关相互转换的逻辑。
服务的健康状况 = 请求失败数 / 请求总数。熔断器开关由关闭到打开的状态转换是通过当前服务健康状况和设定阈值比较决定的。
当熔断器开关关闭时，请求被允许通过熔断器。 如果当前健康状况高于设定阈值，开关继续保持关闭。
如果当前健康状况低于设定阈值，开关则切换为打开状态。当熔断器开关打开时，请求被禁止通过。当熔断器开关处于打开状态，
经过一段时间后，熔断器会自动进入半开状态，这时熔断器只允许一个请求通过。当该请求调用成功时，熔断器恢复到关闭状态。
若该请求失败，熔断器继续保持打开状态，接下来的请求被禁止通过。
熔断器的开关能保证服务调用者在调用异常服务时，快速返回结果，避免大量的同步等待，
并且熔断器能在一段时间后继续侦测请求执行结果，提供恢复服务调用的可能。

#3.命令模式
Hystrix使用命令模式（继承HystrixCommand类）来包裹具体的服务调用逻辑（run方法），
并在命令模式中添加了服务调用失败后的降级逻辑（getFallback）。
同时在Command的构造方法中可以定义当前服务线程池和熔断器的相关参数。因此在使用了Command模式构建了服务对象之后，
服务便拥有了熔断器和线程池的功能。