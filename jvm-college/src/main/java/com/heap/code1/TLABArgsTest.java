package com.heap.code1;

/**
 * 测试-XX:UseTLAB参数是否开启的情况:默认情况是开启的
 *
 * D:\DevelopmentSoftWare\workstation\knowledgeWIKI>jps
 *
 * D:\DevelopmentSoftWare\workstation\knowledgeWIKI>jinfo -flag UseTLAB 2344
 * -XX:+UseTLAB
 *
 */
public class TLABArgsTest {
    public static void main(String[] args) {
        System.out.println("我只是来打个酱油~");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
