package com.test.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

public class AioServerHandler implements CompletionHandler<AsynchronousSocketChannel, AioServer> {

    private final Integer BUFFER_SIZE = 1024;

    @Override
    public void completed(AsynchronousSocketChannel result, AioServer attachment) {
        //保证多个客户端都可以阻塞
        attachment.asynchronousServerSocketChannel.accept(attachment, this);
        read(result);
    }

    public void read(final AsynchronousSocketChannel asynchronousSocketChannel) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BUFFER_SIZE);
        asynchronousSocketChannel.read(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                //进行读取之后，重置标志位
                attachment.flip();
                //获取读取的数据
                String resultData = new String(attachment.array()).trim();
                System.out.println("Server -> " + "收到客户端的数据信息为：" + resultData);

                //响应客户端
                resultData = "====" + resultData + "====";
                write(asynchronousSocketChannel, resultData);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
            }
        });
    }

    public void write(AsynchronousSocketChannel asynchronousSocketChannel, String response) {
        try {
            //把数据写入到缓冲区
            ByteBuffer buf = ByteBuffer.allocate(BUFFER_SIZE);
            buf.put(response.getBytes());
            buf.flip();
            //在从缓冲区写入到通道中
            asynchronousSocketChannel.write(buf).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Throwable exc, AioServer attachment) {
        exc.printStackTrace();
    }
}
