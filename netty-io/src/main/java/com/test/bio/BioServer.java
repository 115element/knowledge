package com.test.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class BioServer {


    public void server(int port) throws Exception {
        final ServerSocket socket = new ServerSocket(port);
        try {
            for (; ; ) {
                final Socket clientSocket = socket.accept();
                System.out.println("Accepted connection from "+clientSocket);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream out;
                        try {
                            out = clientSocket.getOutputStream();
                            out.write("Hi!\r\n".getBytes(StandardCharsets.UTF_8));
                            out.flush();
                            clientSocket.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                            try {
                                clientSocket.close();
                            } catch (IOException exception) {
                                exception.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ////客户端(可以使用telnet命令模拟)////
    //telnet 127.0.0.1 8080//
    //////////////////////////////
}
