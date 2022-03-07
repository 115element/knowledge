package com.example.utils.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 客户端连接.
 *
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.setTcpNoDelay(true);
        socket.connect(new InetSocketAddress("www.baidu.com", 80));
        InputStream is = socket.getInputStream();
        byte[] data = new byte[8];
        is.read(data, 0, 8);
        System.out.println(new String(data));
    }

}