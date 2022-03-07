package com.cloud.chang.util.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PeekBlockingQueue<V> {

	private BlockingQueue<V> queue;
	private final ReentrantLock takeLock = new ReentrantLock();
	private final Condition notEmpty = takeLock.newCondition();

	public void initQueue() {
		this.queue = new LinkedBlockingQueue<V>();
	}

	public BlockingQueue<V> getQueue() {
		return queue;
	}

	public boolean offer(V obj) {
		boolean result = queue.offer(obj);
		if (result) {
			signalNotEmpty();
		}
		return result;
	}

	public int size() {
		return queue.size();
	}

	public Object take() {
		Object object = null;
		try {
			object = queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return object;
	}

	public Object peek(long timeout) throws InterruptedException {

		Object message = null;
		TimeUnit unit = TimeUnit.MILLISECONDS;
		long nanos = unit.toNanos(timeout);

		final ReentrantLock takeLock = this.takeLock;
		takeLock.lockInterruptibly();
		for (;;) {
			try {
				try {
					if (nanos <= 0) {
						return null;
					}
					nanos = notEmpty.awaitNanos(nanos);

					while (queue.size() == 0) {
						notEmpty.await();
					}

				} catch (InterruptedException ie) {
					notEmpty.signal();
					throw ie;
				}
				message = queue.peek();
				notEmpty.signal();
				break;

			} finally {
				takeLock.unlock();
			}
		}
		return message;
	}

	private void signalNotEmpty() {
		final ReentrantLock takeLock = this.takeLock;
		takeLock.lock();
		try {
			notEmpty.signalAll();
		} finally {
			takeLock.unlock();
		}
	}

}
