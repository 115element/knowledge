package com.cloud.chang.util;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/**
 * 实现此类的load方法,加载相关数据
 *
 * @param <E>
 * @param <T>
 */
public abstract class SoftCache<E, T> {

  private LinkedHashMap<E, SoftReference<T>> cache = new LinkedHashMap<E, SoftReference<T>>();


  public T get(E key) {

    SoftReference<T> reference = (SoftReference<T>) cache.get(key);
    if (reference != null) {
      T result = reference.get();
      if (result != null) {
        return result;
      }
    } else {
      cache.remove(key);
    }
    /* 重新加载 */
    T value = load(key);
    if (value != null) {
      cache(key, value);
    }
    return value;

  }

  private void cache(E key, T value) {
    cache.put(key, new SoftReference<T>(value));
  }

  public void updateCache(E key, T value) {
    cache(key, value);
  }

  /**下面是示例
   * private T load(String key) { 
   *    T macInfo = macInfoRepository.findByMacHead(key); 
   *    if (macInfo != null)
   *       return macInfo; 
   *    return null; 
   * }
   */
  public abstract T load(E key);

  
}
