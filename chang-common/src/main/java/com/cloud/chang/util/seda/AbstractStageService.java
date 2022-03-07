package com.cloud.chang.util.seda;

public abstract class AbstractStageService implements StageService {

    public final boolean submit(StageTask task) {
        if (task == null) {
            return false;
        } else {
            return execute(task);
        }
    }

}
