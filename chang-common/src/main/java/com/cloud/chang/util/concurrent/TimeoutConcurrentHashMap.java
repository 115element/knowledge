package com.cloud.chang.util.concurrent;

import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TimeoutConcurrentHashMap<K, V> {

  private ConcurrentHashMap<K, V> map = new ConcurrentHashMap<K, V>();
  private Set<K> keySet = Collections.synchronizedSet(new HashSet<K>());

  private final ReentrantLock takeLock = new ReentrantLock();
  private final Condition notEmpty = takeLock.newCondition();

  public void clear() {
    this.map.clear();
  }

  public boolean contains(Object value) {
    return this.map.contains(value);
  }

  public boolean containsKey(Object key) {
    boolean isContains = this.map.containsKey(key);
    return isContains;
  }

  public boolean containsValue(Object value) {
    return this.map.containsValue(value);
  }

  public Enumeration<V> elements() {
    return this.map.elements();
  }

  public Set<Map.Entry<K, V>> entrySet() {
    return this.map.entrySet();
  }

  public V get(Object key, long timeout) throws InterruptedException {
    V value = null;
    TimeUnit unit = TimeUnit.MILLISECONDS;
    long nanos = unit.toNanos(timeout);
    takeLock.lockInterruptibly();
    try {
      for (;;) {
        if (containsKey(key)) {
          value = map.get(key);
          break;
        }
        if (nanos <= 0)
          return null;
        try {
          nanos = notEmpty.awaitNanos(nanos);
        } catch (InterruptedException ie) {
          notEmpty.signal();
          throw ie;
        }
      }
    } finally {
      takeLock.unlock();
    }
    return value;
  }

  public boolean isEmpty() {
    return this.isEmpty();
  }

  public Enumeration<K> keys() {
    return this.keys();
  }

  public Set<K> keySet() {
    return this.map.keySet();
  }

  public V put(K key, V value) {
    V oldValue = null;
    // 当key已经被移除了，或者已经超时了，超时外到的数据，将不能进入到map中，不然就是脏数据
    if (keySet.remove(key)) {
      oldValue = map.put(key, value);
    }
    signalNotEmpty();
    return oldValue;
  }

  public void putAll(Map<? extends K, ? extends V> t) {
    this.map.putAll(t);
  }

  public V remove(Object key) {
    return this.map.remove(key);
  }

  public boolean remove(Object key, Object value) {
    return this.remove(key, value);
  }

  public V replace(K key, V value) {
    return this.map.replace(key, value);
  }

  public boolean replace(K key, V oldValue, V newValue) {
    return this.map.replace(key, oldValue, newValue);
  }

  public int size() {
    return this.map.size();
  }

  public Collection<V> values() {
    return this.map.values();
  }

  // 消息发送前要设置，不然响应太快就丢失了
  public void AddKey2Set(K key) {
    keySet.add(key);
  }

  public boolean containsInSet(K key) {
    return keySet.contains(key);
  }

  public V getAndRemove(K key, long timeout) {
    V message = null;
    try {
      message = this.get(key, timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    map.remove(key);
    // 如果超时后， 也要删除超时key
    if (message == null) {
      keySet.remove(key);
    }
    return message;
  }

  // ----------------------------------------------
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
