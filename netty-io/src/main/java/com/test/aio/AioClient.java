package com.test.aio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * Aio客户端
 */
public class AioClient implements Runnable {

    private static final Integer PORT = 8888;
    private static final String IP_ADDRESS = "127.0.0.1";
    private final AsynchronousSocketChannel asynchronousSocketChannel;

    public AioClient() throws IOException {
        asynchronousSocketChannel = AsynchronousSocketChannel.open(); //打开通道
    }

    public void connect() {
        asynchronousSocketChannel.connect(new InetSocketAddress(IP_ADDRESS, PORT)); //创建连接 和NIO一样
    }

    public void write(String request) {
        try {
             //发送请求数据到服务端    Client ---> Server
            asynchronousSocketChannel.write(ByteBuffer.wrap(request.getBytes())).get();

            //读取服务端返回的响应数据  Server ---> Client
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            asynchronousSocketChannel.read(byteBuffer).get();
            byteBuffer.flip();
            byte[] respByte = new byte[byteBuffer.remaining()];
            byteBuffer.get(respByte); //将缓冲区的数据放入到Byte数组中
            System.out.println("服务端响应数据："+new String(respByte, StandardCharsets.UTF_8).trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (Exception ignored) {
            }
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            AioClient aioClient = new AioClient();
            aioClient.connect();
            new Thread(aioClient, "aioClient").start();
            String[] operations = {"+", "-", "*", "/"};
            Random random = new Random(System.currentTimeMillis());
            String expression = random.nextInt(10) + operations[random.nextInt(4)] + (random.nextInt(10) + 1);
            aioClient.write(expression);
        }
    }
}
