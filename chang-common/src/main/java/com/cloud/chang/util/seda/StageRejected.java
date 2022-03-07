package com.cloud.chang.util.seda;

public interface StageRejected {

    void reject(StageTask task, StageExecutor executor, String reason);

}
