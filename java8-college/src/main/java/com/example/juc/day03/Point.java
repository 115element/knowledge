package com.example.juc.day03;

import java.util.concurrent.locks.StampedLock;

// Java 8 新增的乐观锁

/*
在Java 8中引入了一种锁的新机制——StampedLock，它可以看成是读写锁的一个改进版本。
 StampedLock提供了一种乐观读锁的实现，这种乐观读锁类似于无锁的操作，
 完全不会阻塞写线程获取写锁，从而缓解[读多写少]时写线程“饥饿”现象。
 由于StampedLock提供的乐观读锁不阻塞写线程获取读锁，当线程共享变量从主内存load到线程工作内存时，
 会存在数据不一致问题，所以当使用StampedLock的乐观读锁时，需要遵从如下图用例中使用的模式来确保数据的一致性。
*/
public class Point {

    private double x, y;

    private final StampedLock sl = new StampedLock();

    void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock(); //使用写锁-独占操作
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp); //释放写锁
        }
    }

    double distanceFromOrigin() {
        long stamp = sl.tryOptimisticRead(); //①
        double currentX = x, currentY = y;   //②
        if (!sl.validate(stamp)) {           //③
            stamp = sl.readLock();           //④
            try {
                currentX = x;                //⑤
                currentY = y;
            } finally {
                sl.unlockRead(stamp);        //⑥
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY); //⑦
    }
/*
    如上图用例所示计算坐标点Point对象，包含点移动方法move及计算此点到原点的距离的方法distanceFromOrigin。
    在方法distanceFromOrigin中，首先，通过tryOptimisticRead方法获取乐观读标记；然后从主内存中加载点的坐标值 (x,y)；
    而后通过StampedLock的validate方法校验锁状态，判断坐标点(x,y)从主内存加载到线程工作内存过程中，
    主内存的值是否已被其他线程通过move方法修改，
    如果validate返回值为true，证明(x, y)的值未被修改，可参与后续计算；
    否则，需加悲观读锁，再次从主内存加载(x,y)的最新值，然后再进行距离计算。其中，校验锁状态这步操作至关重要，
    需要判断锁状态是否发生改变，从而判断之前copy到线程工作内存中的值是否与主内存的值存在不一致。

    下图为StampedLock.validate方法的源码实现，通过锁标记与相关常量进行位运算、比较来校验锁状态，
    在校验逻辑之前，会通过Unsafe的loadFence方法加入一个load内存屏障，
    目的是避免上图用例中步骤②和StampedLock.validate中锁状态校验运算发生重排序导致锁状态校验不准确的问题。
*/
}
