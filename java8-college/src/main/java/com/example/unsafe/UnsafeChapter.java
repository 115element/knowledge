package com.example.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.ProtectionDomain;

/*
《前言》
Unsafe是位于sun.misc包下的一个类，主要提供一些用于执行低级别、不安全操作的方法，如直接访问系统内存资源、
自主管理内存资源等，这些方法在提升Java运行效率、增强Java语言底层资源操作能力方面起到了很大的作用。
但由于Unsafe类使Java语言拥有了类似C语言指针一样操作内存空间的能力，这无疑也增加了程序发生相关指针问题的风险。
在程序中过度、不正确使用Unsafe类会使得程序出错的概率变大，使得Java这种安全的语言变得不再“安全”，因此对Unsafe的使用一定要慎重。
 */

@SuppressWarnings("restrication")
public class UnsafeChapter {

    public static void main(String[] args) {
        Unsafe unsafe = Unsafe.getUnsafe();
    }

    ///////////////////////以下方法是Unsafe中的方法，我这里只是放下面展示/////////////////////////////////////////////
    //分配内存, 相当于C++的malloc函数
    public native long allocateMemory(long bytes);
    //扩充内存
    public native long reallocateMemory(long address, long bytes);
    //释放内存
    public native void freeMemory(long address);
    //在给定的内存块中设置值
    public native void setMemory(Object o, long offset, long bytes, byte value);
    //内存拷贝
    public native void copyMemory(Object srcBase, long srcOffset, Object destBase, long destOffset, long bytes);
    //获取给定地址值，忽略修饰限定符的访问限制。与此类似操作还有: getInt，getDouble，getLong，getChar等
    public native Object getObject(Object o, long offset);
    //为给定地址设置值，忽略修饰限定符的访问限制，与此类似操作还有: putInt,putDouble，putLong，putChar等
    public native void putObject(Object o, long offset, Object x);
    //获取给定地址的byte类型的值（当且仅当该内存地址为allocateMemory分配时，此方法结果为确定的）
    public native byte getByte(long address);
    //为给定地址设置byte类型的值（当且仅当该内存地址为allocateMemory分配时，此方法结果才是确定的）
    public native void putByte(long address, byte x);

    /**
     *  CAS
     * @param o         包含要修改field的对象
     * @param offset    对象中某field的偏移量
     * @param expected  期望值
     * @param update    更新值
     * @return          true | false
     */
    public final native boolean compareAndSwapObject(Object o, long offset,  Object expected, Object update);

    public final native boolean compareAndSwapInt(Object o, long offset, int expected,int update);

    public final native boolean compareAndSwapLong(Object o, long offset, long expected, long update);
    //什么是CAS? 即比较并替换，实现并发算法时常用到的一种技术。CAS操作包含三个操作数——内存位置、预期原值及新值。执行CAS操作的时候，
    //将内存位置的值与预期原值比较，如果相匹配，那么处理器会自动将该位置值更新为新值，否则，处理器不做任何操作。我们都知道，
    //CAS是一条CPU的原子指令（cmpxchg指令），不会造成所谓的数据不一致问题，Unsafe提供的CAS方法（如compareAndSwapXXX）底层实现即为CPU指令cmpxchg。


    //线程调度
    //这部分，包括线程挂起、恢复、锁机制等方法。
    //取消阻塞线程
    public native void unpark(Object thread);
    //阻塞线程
    public native void park(boolean isAbsolute, long time);
    //获得对象锁（可重入锁）
    @Deprecated
    public native void monitorEnter(Object o);
    //释放对象锁
    @Deprecated
    public native void monitorExit(Object o);
    //尝试获取对象锁
    @Deprecated
    public native boolean tryMonitorEnter(Object o);


    //获取给定静态字段的内存地址偏移量，这个值对于给定的字段是唯一且固定不变的
    public native long staticFieldOffset(Field f);
    //获取一个静态类中给定字段的对象指针
    public native Object staticFieldBase(Field f);
    //判断是否需要初始化一个类，通常在获取一个类的静态属性的时候（因为一个类如果没初始化，它的静态属性也不会初始化）使用。 当且仅当ensureClassInitialized方法不生效时返回false。
    public native boolean shouldBeInitialized(Class<?> c);
    //检测给定的类是否已经初始化。通常在获取一个类的静态属性的时候（因为一个类如果没初始化，它的静态属性也不会初始化）使用。
    public native void ensureClassInitialized(Class<?> c);
    //定义一个类，此方法会跳过JVM的所有安全检查，默认情况下，ClassLoader（类加载器）和ProtectionDomain（保护域）实例来源于调用者
    public native Class<?> defineClass(String name, byte[] b, int off, int len, ClassLoader loader, ProtectionDomain protectionDomain);
    //定义一个匿名类
    public native Class<?> defineAnonymousClass(Class<?> hostClass, byte[] data, Object[] cpPatches);


    //系统相关
    //这部分包含两个获取系统相关信息的方法。
    //返回系统指针的大小。返回值为4（32位系统）或 8（64位系统）。
    public native int addressSize();
    //内存页的大小，此值为2的幂次方。
    public native int pageSize();


    ///
    //省略很多方法...
}
