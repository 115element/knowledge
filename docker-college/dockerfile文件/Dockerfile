#指定基础镜像，在其上进行定制。
FROM java:8

#说明镜像维护者信息
MAINTAINER alex <jiahangSocket@163.com>

#这里的 /tmp 目录就会在容器运行时自动挂载为匿名卷，任何向 /tmp 中写入的信息都不会记录进容器存储层
#VOLUME /tmp

#COPY指令和ADD指令的唯一区别在于是否支持从远程URL获取资源。COPY指令只能从执行docker build所在的主机上读取资源并复制到镜像中。
#而ADD指令还支持通过URL从远程服务器读取资源并复制到镜像中。
#满足同等功能的情况下，推荐使用COPY指令。ADD指令更擅长读取本地tar文件并解压缩。
ADD ./target/AsiaCloudFlatService-0.1.3.jar /home/springboot/AsiaCloudFlatService-0.1.3.jar

#解決容器內時間和宿主機不一致問題（容器內默认是UTC的0时区，如果不指定容器内时间会和宿主机相差8个小时）
RUN echo "Asia/Shanghai" > /etc/timezone;

#bash方式执行，使AsiaCloudFlatService-0.1.3.jar可访问
#RUN新建立一层，在其上执行这些命令，执行结束后，commit这一层的修改，构成新的镜像。
RUN bash -c "touch /AsiaCloudFlatService-0.1.3.jar"

#声明运行时容器提供服务端口，这只是一个声明，在运行时并不会因为这个声明应用就会开启这个端口的服务。
EXPOSE 9080

#指定容器启动程序及参数
ENTRYPOINT ["java","-jar","/home/springboot/springboot-dockerfile.jar"]




#在当前目录运行build指令构建镜像
# -f 指定Dockerfile位置
# --tag, -t: 镜像的名字及标签，通常 name:tag 或者 name 格式；可以在一次构建中为一个镜像设置多个标签。
# 命令最后的点表示当前目录执行
# docker build -f ./Dockerfile -t asiacloud:v1 .


#运行该镜像
#docker的网络模式：
#   bridge模式： Docker的默认设置
#   host模式
#   none模式
#   container模式： 使用时要指定容器名
#   overlay模式
#   --net=host 注意一定要使用host网络连接方式，否则项目会连接不上mysql，导致项目起不来。
# docker run -dp 9080:9080 --name asiacloud -v /h/volumes/springboot/logs:/log asiacloud:v1
