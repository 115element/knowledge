package com.dns;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.InMemoryDnsResolver;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {


    /**
     * --resolve HOST:PORT:ADDRESS 将 HOST:PORT 强制解析到 ADDRESS。
     * <p>
     * curl -svo /dev/null http://container-yantest-bd-test.asia-cdn.com/1.txt --resolve container-yantest-bd-test.asia-cdn.com:80:5.188.121.254
     * 指定域名使用指定的IP访问，也就是域名IP绑定
     */
    public static void main(String[] args) throws Exception {

        DnsResolver dnsResolver = new SystemDefaultDnsResolver() {
            @Override
            public InetAddress[] resolve(final String host) throws UnknownHostException {
                if (host.equalsIgnoreCase("www.baidu.com")) {
                    return new InetAddress[]{InetAddress.getByName("112.80.248.75")};
                } else {
                    return super.resolve(host);
                }
            }
        };

        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();


        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry, dnsResolver);
        CloseableHttpClient client = HttpClients.custom().setConnectionManager(connManager).build();

        HttpGet httpget = new HttpGet("https://www.baidu.com");
        System.out.println(httpget.getRequestLine());

        //  发送请求并返回结果
        HttpResponse response = client.execute(httpget);
        System.out.println(response.getEntity().getContentType());
        System.out.println(response.getStatusLine());
    }


    /**
     * 代码运行时就会根据自定义的这个DnsResolver来解析，比如http请求中目的机器是www.baidu.com，那么目的机器就会被解析成112.80.248.75
     */
    public static DnsResolver getDnsResolver1() throws UnknownHostException {
        /* Custom DNS resolver */
        InMemoryDnsResolver dnsResolver = new InMemoryDnsResolver();
        dnsResolver.add("www.baidu.com", new InetAddress[]{InetAddress.getByName("112.80.248.75")});
        return dnsResolver;
    }


    /**
     * 这种方式，当代码运行时，
     * 先比对主机是否是www.baidu.com如果是，那么解析ip为112.80.248.75，
     * 否则会用代码所在的机器上的host文件一些其他的方式去解析目的机器（域名）
     */
    public static DnsResolver getDnsResolver2() {
        DnsResolver dnsResolver = new SystemDefaultDnsResolver() {
            @Override
            public InetAddress[] resolve(final String host) throws UnknownHostException {
                if (host.equalsIgnoreCase("www.baidu.com")) {
                    return new InetAddress[]{InetAddress.getByName("112.80.248.75")};
                } else {
                    return super.resolve(host);
                }
            }
        };
        return dnsResolver;
    }

}
