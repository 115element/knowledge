package com.cloud.chang.util.seda;

import java.util.concurrent.TimeUnit;

public interface StageService extends StageExecutor {

    void shutdown();

    boolean isShutdown();

    boolean isTerminated();

    boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;

    boolean submit(StageTask task);

}
