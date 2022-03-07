package com.cloud.chang.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现此类的load方法,加载相关数据
 *
 * @param <E>
 * @param <T>
 */
public abstract class HardCache<E, T> {



  private Map<E, T> cache = new HashMap<E, T>();


  public T get(E key) {

    return cache.get(key);

  }
  
  public HardCache() {
    Map<E, T> temp = load();
    if(temp != null){
      cache = temp;
    }
  }

  public abstract Map<E, T> load();

  /*
   * private T load(String key) { 
   * T macInfo = macInfoRepository.findByMacHead(key); 
   * if (macInfo != null)
   * return macInfo; return null; }
   */
}
