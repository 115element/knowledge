package com.example;


import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Twitter_Snowflake<br>
 * SnowFlake的结构如下(每部分用-分开):<br>
 * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 00000 - 000000000000 <br>
 * <p>
 * 1位标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是正数，最高位是0<br>
 * <p>
 * 41位时间截(毫秒级)，注意，41位时间截不是存储当前时间的时间截，而是存储时间截的差值（当前时间截 - 开始时间截)
 * 得到的值），这里的的开始时间截，一般是我们的id生成器开始使用的时间，由我们程序来指定的（如下下面程序IdWorker类的startTime属性）。41位的时间截，可以使用69年，年T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
 * <p>
 * 10位的数据机器位，可以部署在1024个节点，包括5位datacenterId和5位workerId<br>
 * <p>
 * 12位序列，毫秒内的计数，12位的计数顺序号支持每个节点每毫秒(同一机器，同一时间截)产生4096个ID序号<br>
 * <p>
 * 加起来刚好64位，为一个Long型。<br>
 * SnowFlake的优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞(由数据中心ID和机器ID作区分)，并且效率较高，经测试，SnowFlake每秒能够产生26万ID左右。
 */

public class SnowFlake {
    // 例如：开始时间截设置为(2015-01-01)，这个值的意思表示id可以用的时间长度为2015年01月01日开始和往后的69年，就是直到2084年01月01日。
    private final static long twepoch = 1489111610226L;
    // 机器标识位数
    private final static long workerIdBits = 5L;
    // 数据中心标识位数
    private final static long datacenterIdBits = 5L;
    // 毫秒内自增位数
    private final static long sequenceBits = 12L;
    // 机器ID偏左移12位
    private final static long workerIdShift = sequenceBits;
    // 数据中心ID左移17位
    private final static long datacenterIdShift = sequenceBits + workerIdBits;
    // 时间毫秒左移22位
    private final static long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    // sequence掩码，确保sequence不会超出上限
    private final static long sequenceMask = -1L ^ (-1L << sequenceBits);//4095<二进制>111111111111
    // 上次时间戳
    private static long lastTimestamp = -1L;
    // 序列
    private long sequence = 0L;
    // 服务器ID
    private long workerId = 1L;
    private final static long workerMask = -1L ^ (-1L << workerIdBits);//31<二进制>11111
    // 进程编码
    private long processId = 1L;
    private final static long processMask = -1L ^ (-1L << datacenterIdBits);//31<二进制>11111

    private static SnowFlake snowFlake = null;

    static {
        snowFlake = new SnowFlake();
    }

    public static synchronized long nextId() {
        return snowFlake.getNextId();
    }

    private SnowFlake() {
        //获取机器编码
        this.workerId = this.getMachineNum();

        //获取进程编码
        //java.lang.management.RuntimeMXBean是Java 虚拟机的运行时系统的管理接口。使用它可以获取正在运行的 Java 虚拟机等信息，包括获取PID。
        //runtimeMXBean.getName()取得的值包括两个部分：PID和hostname，两者用@连接。
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        this.processId = Long.valueOf(runtimeMXBean.getName().split("@")[0]).longValue();

        //避免编码超出最大值
        this.workerId = workerId & workerMask;
        this.processId = processId & processMask;
        System.out.println(workerId);
        System.out.println(processId);
    }


    public synchronized long getNextId() {
        //获取当前时间戳
        long timestamp = timeGen();
        //如果当前时间戳小于上次时间戳则报错
        if (timestamp < lastTimestamp) {
            try {
                throw new Exception("Clock moved backwards.  Refusing to generate id for " + (lastTimestamp - timestamp) + " milliseconds");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //如果当前时间戳与上次时间戳相同
        if (timestamp == lastTimestamp) {
            // 如果下一次获取ID还在当前毫秒内，则序列号+1，与sequenceMask确保sequence不会超出上限
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                // 4096&4095 == 0
                // 0000 0000 0000 0000 0001 0000 0000 0000 == 4096
                // 0000 0000 0000 0000 0000 1111 1111 1111 == 4095
                // 0000 0000 0000 0000 0000 0000 0000 0000 二者&的结果
                // 当前毫秒内计数满了，则等待下一秒
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            //时间戳改变，毫秒内序列重置
            sequence = 0;
        }
        lastTimestamp = timestamp;
        // ID偏移组合生成最终的ID，并返回ID
        long nextId = ((timestamp - twepoch) << timestampLeftShift) | (processId << datacenterIdShift) | (workerId << workerIdShift) | sequence;
        return nextId;
    }

    /**
     * 再次获取时间戳直到获取的时间戳与现有的不同
     *
     * @param lastTimestamp
     * @return 下一个时间戳
     */
    private long tilNextMillis(final long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }


    private long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * 获取机器码（原理：本机所有网络接口名，字符串拼接后，求出hashcode码）
     *
     * @return
     */
    private long getMachineNum() {
        long machinePiece;
        StringBuilder sb = new StringBuilder();
        Enumeration<NetworkInterface> e = null;
        try {
            //getNetworkInterfaces 方法即可得到当前机器上所有的网络接口
            e = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e1) {
            e1.printStackTrace();
        }
        while (e.hasMoreElements()) {
            NetworkInterface ni = e.nextElement();
            sb.append(ni.toString());
        }
        machinePiece = sb.toString().hashCode();
        return machinePiece;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            long l = nextId();
            toBinaryString(l);
        }
    }

    public static void toBinaryString(long id){
        System.out.println(id);
        String binary = Long.toBinaryString(id);
        while (binary.length() < 64){
            binary = "0" + binary;
        }
        System.out.println(binary);
    }

}
