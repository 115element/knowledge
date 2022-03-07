package com.example.spring_circular_dependency.jar_loading;

import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

//TODO 可以将此程序嵌入系统中，查看jar的加载顺序，那么就可以知道为什么Spring偶尔会出现循环依赖问题（加载顺序每次是不一致）

public class JarLoadingSequence {

/**
 JarURLConnection类通过JAR协议建立了一个访问 jar包URL的连接，可以访问这个jar包或者这个包里的某个文件。

 jar URL的形式如下：jar:{archive-url}!/{entry}，其中!/是一个分隔符。

 示例：

 访问http服务器上的Jar包文件：   jar:http://www.jcg.com/bar/baz.jar!/

 访问http服务器上Jar包内的文件： jar:http://www.jcg.com/bar/baz.jar!/com/foo/Quux.class

 访问http服务器上Jar包内的目录： jar:http://www.jcg.com/bar/baz.jar!/com/foo/

 访问本地文件系统上Jar包文件:    jar:file:/c:/baz.jar!/

 访问本地文件系统上Jar包内的文件： jar:file:/c:/baz.jar!/com/foo/xxx.class

 访问本地文件系统上Jar包内的目录： jar:file:/c:/baz.jar!/com/foo/
*/

    public static void main(String[] args) throws Exception {
        print();
    }


    public static void print() throws Exception {
        URL rootDirUrl = new URL("jar:file:/C:\\Users\\sxh\\Desktop\\AsiaCloudFlatService-0.1.5.jar!/");
        URLConnection urlConnection = rootDirUrl.openConnection();
        JarURLConnection jarCon = (JarURLConnection) urlConnection;
        JarFile jarFile = jarCon.getJarFile();


        System.out.println("=================Jar主清单文件内容====================================");
        Manifest manifest = jarFile.getManifest();
        Set<Map.Entry<Object, Object>> manifestEnt = manifest.getMainAttributes().entrySet();
        for (Map.Entry<Object, Object> objectObjectEntry : manifestEnt) {
            System.out.println(objectObjectEntry.getKey()+"==="+objectObjectEntry.getValue());
        }

        System.out.println("=====================================================");

        Enumeration<JarEntry> entries = jarFile.entries();

        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String entryPath = entry.getName();
            System.out.println(entryPath);
        }
    }

}
