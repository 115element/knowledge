package com.example;

import java.security.SecureRandom;

public class SnowflakeManager {
    // 例如：开始时间截设置为(2015-01-01)，EPOCH_STAMP这个值的意思表示id可以用的时间长度为2015年01月01日开始和往后的69年，就是直到2084年01月01日。
    private static final long EPOCH_STAMP = 1262275200000L;
    private static final long SEQUENCE_BIT = 12L;
    private static final long MACHINE_BIT = 5L;
    private static final long DATA_CENTER_BIT = 5L;
    private static final long MAX_SEQUENCE_NUM = -1L ^ (-1L << SEQUENCE_BIT);//4095<二进制>111111111111
    private static final long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT); //31<二进制>11111
    private static final long MAX_DATA_CENTER_NUM = -1L ^ (-1L << DATA_CENTER_BIT);//31<二进制>11111
    private static final long MACHINE_LEFT = SEQUENCE_BIT;//12
    private static final long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT; //17
    private static final long TIMESTAMP_LEFT = SEQUENCE_BIT + MACHINE_BIT + DATA_CENTER_BIT;//22
    private final long machineId;
    private final long dataCenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public SnowflakeManager(long machineId, long dataCenterId) {
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException(String.format("machine id can't be greater than %d or less than 0", MAX_MACHINE_NUM));
        }
        if (dataCenterId > MAX_DATA_CENTER_NUM || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format("data center id can't be greater than %d or less than 0", MAX_DATA_CENTER_NUM));
        }
        this.machineId = machineId;
        this.dataCenterId = dataCenterId;
    }

    public synchronized long nextValue() throws Exception {
        String os = System.getProperty("os.name");
        SecureRandom secureRandom;
        if (os.toLowerCase().startsWith("win")) {
            // windows机器用
            secureRandom = SecureRandom.getInstanceStrong();
        } else {
            // linux机器用
            secureRandom = SecureRandom.getInstance("NativePRNGNonBlocking");
        }
        //SecureRandom secureRandom = SecureRandom.getInstanceStrong();
        long currentTimeMillis = this.currentTimeMillis();
        if (currentTimeMillis < this.lastTimestamp) {
            throw new Exception(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", (this.lastTimestamp - currentTimeMillis)));
        }

        if (this.lastTimestamp == currentTimeMillis) {
            this.sequence = (this.sequence + 1) & MAX_SEQUENCE_NUM;
            if (this.sequence == 0) {
                // 4096&4095 == 0
                // 0000 0000 0000 0000 0001 0000 0000 0000 == 4096
                // 0000 0000 0000 0000 0000 1111 1111 1111 == 4095
                // 0000 0000 0000 0000 0000 0000 0000 0000 二者&的结果
                this.sequence = secureRandom.nextInt(Long.valueOf(SEQUENCE_BIT).intValue());
                currentTimeMillis = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = secureRandom.nextInt(Long.valueOf(SEQUENCE_BIT).intValue());
        }
        this.lastTimestamp = currentTimeMillis;

        // 64 Bit ID (42(Millis)+5(Data Center ID)+5(Machine ID)+12(Repeat Sequence Summation))
        long nextId = ((currentTimeMillis - EPOCH_STAMP) << TIMESTAMP_LEFT)
                | (this.dataCenterId << DATA_CENTER_LEFT)
                | (this.machineId << MACHINE_LEFT)
                | this.sequence;

        return nextId;
    }

    private long tilNextMillis(long lastTimestamp) {
        long currentTimeMillis = this.currentTimeMillis();
        while (currentTimeMillis <= lastTimestamp) {
            currentTimeMillis = this.currentTimeMillis();
        }
        return currentTimeMillis;
    }

    private long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) throws Exception {
        /**
         * machineID和dataCenterId可以放在配置文件中，每个项目配置不同的。
         * machineID占5位，dataCenterId占5位，二者合起来共站10位bit。
         * 所以machineId范围为0-31，dataCenterId的范围时0-31。
         */
        SnowflakeManager snowflakeManager = new SnowflakeManager(0L, 0L);
        long l = snowflakeManager.nextValue();
        System.out.println(l);
    }
}
