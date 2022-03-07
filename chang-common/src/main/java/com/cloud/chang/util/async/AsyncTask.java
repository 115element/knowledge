package com.cloud.chang.util.async;

public interface AsyncTask {

  public Object run();
  
  public int getThreadNum();
  
  public void callback(Object result, Throwable... e);

}
