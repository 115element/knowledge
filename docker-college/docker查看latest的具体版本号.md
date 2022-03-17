
# 获取镜像的版本号，在返回信息中查看VERSION字段，即可看到版本号；也可以看到其IP地址信心；
```shell
docker inspect (镜像id)
```



# 获取容器IP的另外一种办法
```shell
1.进入容器
2.执行 apt update 命令
3.执行 apt install net-tools 命令
4.执行 ifconfig 命令
```

#可以看到，该容器的IP地址是：172.17.0.2，该容器的回环地址为127.0.0.1
```shell
root@57d284cb85ab:/# ifconfig
eth0: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet 172.17.0.2  netmask 255.255.0.0  broadcast 172.17.255.255
        ether 02:42:ac:11:00:02  txqueuelen 0  (Ethernet)
        RX packets 22585  bytes 26205332 (26.2 MB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 10466  bytes 1443737 (1.4 MB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

lo: flags=73<UP,LOOPBACK,RUNNING>  mtu 65536
        inet 127.0.0.1  netmask 255.0.0.0
        loop  txqueuelen 1000  (Local Loopback)
        RX packets 1236  bytes 209932 (209.9 KB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 1236  bytes 209932 (209.9 KB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
```