package com.cloud.chang.util.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/**
 * 此类是为了解决相同请求短时间（毫秒内）大量重复请求给服务器造成的额压力，通过调用此类，可以将相同请求归并，返回统一结果，但具体的业务方法只执行一次
 * 
 * @author bingyunxl
 *
 */

public class SameKeyThreadManager<T, V> {

	private static Logger log = LoggerFactory.getLogger(SameKeyThreadManager.class);

	private final ReentrantLock takeLock = new ReentrantLock();

	private ConcurrentHashMap<String, Condition> conditionMap;

	private LoadingCache<String, V> resultLocalCache;

	private int expireTimeout = 10;

	private int processTimeout = 30;

	private int maximumSize = 10000;

	public void init() {
		log.debug("expireTimeout=" + expireTimeout + ",processTimeout=" + processTimeout + ", maximumSize="
				+ maximumSize);
		conditionMap = new ConcurrentHashMap<>();
		resultLocalCache = CacheBuilder.newBuilder().maximumSize(maximumSize)
				.expireAfterWrite(expireTimeout, TimeUnit.SECONDS).removalListener(new RemovalListener<String, V>() {
					@Override
					public void onRemoval(RemovalNotification<String, V> notification) {
						String key = notification.getKey();
						log.debug("key=" + key + " expired");
						// if (!StringUtils.isBlank(key)) {
						// conditionMap.remove(key);
						// }
					}
				}).build(new CacheLoader<String, V>() {
					public V load(String key) throws Exception {
						return null;
					}
				});

	}

	public V ctrlSameKeyThread(String key, T req, IBizProcessor<T, V> process) {
		V result = getResult(key);
		if (result != null) {
			return result;
		}
		if (!createNewCondition(key)) {
			return getResult(key, processTimeout);
		} else {

			result = getResult(key);
			log.debug("result=" + result);
			if (result != null) {
				return result;
			}

			result = process.process(req);
			log.debug("result=" + result);
			if (result != null) {
				addResult(key, result);
			} else {
				conditionMap.remove(key);
			}
			return result;
		}
	}

	public interface IBizProcessor<T, V> {
		public V process(T req);
	}

	/**
	 * 
	 * @param key
	 * @param timeout
	 *            TimeUnit:second
	 * @return
	 */
	private V getResult(String key, int timeout) {
		Condition condition = conditionMap.get(key);
		TimeUnit unit = TimeUnit.SECONDS;
		long nanos = unit.toNanos(timeout);
		V result = null;

		try {
			takeLock.lockInterruptibly();
			for (;;) {
				result = resultLocalCache.getIfPresent(key);
				if (result != null) {
					break;
				}
				if (nanos <= 0) {
					// 超时没有数据，则删除掉condition
					conditionMap.remove(key);
					break;
				}
				try {
					nanos = condition.awaitNanos(nanos);
				} catch (InterruptedException ie) {
					condition.signal();
					throw ie;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			takeLock.unlock();
		}
		if (result != null) {
			return result;
		}
		return null;
	}

	private void addResult(String key, V value) {
		log.debug("key=" + key + ", value=" + value);
		resultLocalCache.put(key, value);
		Condition condition = conditionMap.get(key);
		if (condition != null) {
			takeLock.lock();
			try {
				condition.signalAll();
			} finally {
				takeLock.unlock();
			}
			conditionMap.remove(key);
		} else {
			log.error("condition4key=" + key + " is null");
		}
	}

	private V getResult(String key) {
		try {
			return resultLocalCache.getIfPresent(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean createNewCondition(String key) {
		synchronized ("locked") {
			boolean contains = conditionMap.containsKey(key);
			if (contains) {
				return false;
			}
			Condition condition = takeLock.newCondition();
			conditionMap.put(key, condition);
			return true;
		}
	}

	public void setExpireTimeout(int expireTimeout) {
		this.expireTimeout = expireTimeout;
	}

	public void setMaximumSize(int maximumSize) {
		this.maximumSize = maximumSize;
	}

	public void setProcessTimeout(int processTimeout) {
		this.processTimeout = processTimeout;
	}

}
