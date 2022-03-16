#1.搜索es镜像
```shell
docker search elasticsearch:7.12.1
```

#2.拉取镜像
```shell
docker pull elasticsearch:7.12.1
```
拉取镜像的时候，可以指定版本，如果不指定，默认使用latest


#3.查看镜像
```shell
docker images
```

#4.运行容器(指定单节点启动)
```shell
docker run \
  -d \
  --name myes \
  -p 9200:9200 \
  -p 9300:9300 \
  -e "discovery.type=single-node"
  -e ES_JAVA_OPTS="-Xms512m -Xmx512m"
  -e TZ='Asia/Shanghai'
  -v /d/volumes/elasticsearch/config:/usr/share/elasticsearch/config/config:rw \
  -v /d/volumes/elasticsearch/data:/usr/share/elasticsearch/config/data:rw \
  -v /d/volumes/elasticsearch/logs:/usr/share/elasticsearch/config/logs:rw \
  --restart=always \
  --privileged=true \
  elasticsearch:7.12.1
```

```text
大约在0.6版，privileged被引入docker。
使用该参数，container内的root拥有真正的root权限。
否则，container内的root只是外部的一个普通用户权限。
privileged启动的容器，可以看到很多host上的设备，并且可以执行mount。
甚至允许你在docker容器中启动docker容器。
```

#复制容器的文件夹，到宿主机D盘下。
```shell
#拷贝文件
C:\Users\Alex> docker cp e3b09c55e343:/usr/share/elasticsearch/config/elasticsearch.yml D:\
#拷贝文件夹
C:\Users\Alex> docker cp e3b09c55e343:/usr/share/elasticsearch/config D:\
C:\Users\Alex> docker cp e3b09c55e343:/usr/share/elasticsearch/data D:\
C:\Users\Alex> docker cp e3b09c55e343:/usr/share/elasticsearch/logs D:\
```


