package com.example.rpccollege.rpc5;

import com.example.rpccollege.common.IUserService;
import com.example.rpccollege.common.User;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static boolean running = true;

    public static void main(String[] args) throws Exception{
        ServerSocket socket = new ServerSocket(8080);
        while(running){
            Socket s = socket.accept();
            process(s);
            s.close();
        }
        socket.close();
    }

    private static void process(Socket s) throws Exception{
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();

        ObjectInputStream ois = new ObjectInputStream(in);
        ObjectOutputStream oos = new ObjectOutputStream(out);

        // 获取方法信息
        String methodName = ois.readUTF();
        Class<?>[] parameterTypes = (Class<?>[])ois.readObject();
        Object[] args = (Object[]) ois.readObject();

        //新建一个对象，用于绑定方法
        IUserService service = new UserServiceImpl();
        // 调用服务
        Method method = service.getClass().getMethod(methodName, parameterTypes);
        User user = (User)method.invoke(service, args);

        // 直接返回一个对象 ，返回值用Object封装，支持任意类型
        oos.writeObject(user);
        oos.flush();
    }
}

