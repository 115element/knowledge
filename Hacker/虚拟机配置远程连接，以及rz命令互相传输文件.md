在ubuntu系统中安装ssh，通常ubuntu中默认是安装的。 
可以通过命令进行查看：dpkg -l | grep ssh
如果ubuntu系统中没有安装ssh程序，也可以使用下列命令进行安装：
```shell
sudo apt-get install openssh-client  #(客户端-用于你连接别人)
sudo apt-get install openssh-server  #(服务端-用于别人连接你)
```

#安装好后ssh服务的启动和停止命令如下：
启动ssh服务：
```shell
sudo /etc/init.d/ssh start
```
停止ssh服务：
```shell
sudo /etc/init.d/ssh stop
```
重启ssh服务：
```shell
sudo /etc/init.d/ssh restart
```

通过虚拟机启动ubuntu系统，打开shell终端，通过ifconfig命令，查看该系统的ip地址，ssh的端口号一般为22.
打开windows系统中的ssh客户端软件，选择快速连接，输入ubuntu系统的ip地址和账户名，
并根据提示输入密码，即可通过ssh登录到ubuntu系统中去，并执行各种命令操作。
还可以通过ssh软件文件传输软件，将windows中的数据传输到ubuntu系统中。
同时也可以将ubuntu系统中的文件下载到当前的windows系统中。方法是：选中文件--右键--上传（下载）。




###安装rz和sz命令 (用于宿主机和虚拟机互相传输文件)

#centos7安装命令
```shell
yum install -y lrzsz.x86_64
```
#ubunto安装命令
```shell
sudo apt-get install lrzsz
```

#sz命令和rz命令解释： r代表receive，s代表send
用途说明：sz命令是利用ZModem协议来从Linux服务器传送文件到本地，
一次可以传送一个或多个文件，相对应的从本地上传文件到Linux服务器，可以使用rz命令。