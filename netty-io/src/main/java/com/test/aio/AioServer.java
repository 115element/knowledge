package com.test.aio;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Aio服务端
 */
public class AioServer {

    private ExecutorService executorService; //线程池
    private AsynchronousChannelGroup threadGroup; //通道组
    public AsynchronousServerSocketChannel asynchronousServerSocketChannel; //服务器通道

    public void start(Integer port){
        try {
            //1.创建一个缓存池
            executorService = Executors.newCachedThreadPool();
            //2.创建通道组
            threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService,1);
            //3.创建服务器通道
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open(threadGroup);
            //4.进行绑定
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("server start , port: "+port);
            //5.等待客户端请求
            asynchronousServerSocketChannel.accept(this,new AioServerHandler());

            // 一直阻塞，不让服务器停止，真实环境是在Tomcat下运行，所以不需要这行代码。
            // 用CompletionHandler实现 的AsynchronousServerSocketChannel服务器端程序代码，
            // 有一个问题在于需要额外的通过Thread.sleep(Integer.MAX_VALUE)让当前进程无限休眠，因为担心程序退出，程序不退出的前提下，才能够让
            // serverSocketChannel.accept(null, completionHandler);
            // 继续可以回调接受来自客户端的连接，当客户端的连接请求在CompletionHandler完成后，继续在CompletionHandler的completed()里面调用accept()函数等待客户端连接请求。
            // 这种方案必须保证程序不能退出，一旦退出就会导致应用进程被杀掉，那么serverSocketChannel.accept(null, completionHandler) 就完全失效。
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        AioServer aioServer = new AioServer();
        aioServer.start(8888);
    }
}
