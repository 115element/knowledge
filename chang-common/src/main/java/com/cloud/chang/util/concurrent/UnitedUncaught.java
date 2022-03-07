package com.cloud.chang.util.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.Thread.UncaughtExceptionHandler;

public class UnitedUncaught implements UncaughtExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(UnitedUncaught.class);
    private static volatile UnitedUncaught Instance;

    private UnitedUncaught() {

    }

    public static UnitedUncaught getInstance() {
        if (null != Instance) {
            return Instance;
        } else {
            synchronized (UnitedUncaught.class) {
                if (null == Instance) {
                    Instance = new UnitedUncaught();
                }
                return Instance;
            }
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (null == t) {
            log.error("thread null");
            return;
        }
        String threadName = Thread.currentThread().getName();
        unitedInterrupt(t);
        if (null == e) {
            log.error("throwable null, threadName=" + threadName);
            return;
        }
        log.error("threadName=" + threadName + ", err=" + e.toString(), e);
    }

    private void unitedInterrupt(Thread t) {
        try {
            t.interrupt();
        } finally {
            alwaysInterrupt(t);
        }
    }

    private void alwaysInterrupt(Thread t) {
        if (!t.isInterrupted()) {
            t.interrupt();
        }
        if (t.isAlive()) {
            t.interrupt();
        }
    }

}
