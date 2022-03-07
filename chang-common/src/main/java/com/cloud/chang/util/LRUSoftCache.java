package com.cloud.chang.util;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现此类的load方法,加载相关数据
 *
 * @param <K>
 * @param <V>
 */
public abstract class LRUSoftCache<K, V> extends LinkedHashMap<K, SoftReference<V>> {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /* 定义缓存的容量 */
  private int capacity;

  /* 带参数的构造器 */
  protected LRUSoftCache(int capacity) {
    /* 调用LinkedHashMap的构造器，传入以下参数 */
    super(16, 0.75f, true);
    /* 传入指定的缓存最大容量 */
    this.capacity = capacity;
  }

  public V getCache(K key) {

    SoftReference<V> reference = (SoftReference<V>) super.get(key);
    if (reference != null) {
      V result = reference.get();
      if (result != null) {
        return result;
      }
    }
    /* 重新加载 */
    V value = load(key);
    if (value != null) {
      cache(key, new SoftReference<V>(value));
    }
    return value;

  }

  private void cache(K key, SoftReference<V> value) {
    super.put(key, value);
  }

  public void updateCache(K key, V value) {
    cache(key, new SoftReference<V>(value));
  }

  /**
   * 下面是示例 
   * private V load(String key) {
   *  V macInfo = macInfoRepository.findByMacHead(key);
   *   if(macInfo != null)
   *    return macInfo; 
   *   return null; }
   */
  public abstract V load(K key);


  /* 实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素 */
  @Override
  public boolean removeEldestEntry(Map.Entry<K, SoftReference<V>> eldest) {
    return size() > capacity;
  }

  @Override
  public SoftReference<V> get(Object key)
      throws UnsupportedOperationException {
    throw new  UnsupportedOperationException();
  }

  @Override
  public SoftReference<V> put(K key, SoftReference<V> value)
      throws UnsupportedOperationException {
    throw new  UnsupportedOperationException();
  }

  @Override
  public void putAll(Map<? extends K, ? extends SoftReference<V>> m)
      throws UnsupportedOperationException {
    throw new  UnsupportedOperationException();
  }


}
