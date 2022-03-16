#1.搜索es镜像
```shell
docker search kibana
```


#2.拉取镜像
```shell
docker pull kibana:7.12.1
```
拉取镜像的时候，可以指定版本，如果不指定，默认使用latest


#3.查看镜像
```shell
docker images
```


#注意知识点点
```
-e TZ='Asia/Shanghai'
设置时区，否则查询时间需要加+8h
-e LANG="en_US.UTF-8"
设置支持中文的编码方式
```


#4.运行容器（注意Es的IP获取，需要使用docker inspect Es容器id，获取其IP地址）
```shell
docker run \
-d \
--name kibana \
-e ELASTICSEARCH_HOSTS=http://172.17.0.3:9200 \ 
-e TZ='Asia/Shanghai' \
-e LANG="en_US.UTF-8" \
-p 5601:5601 \
--restart=always \ 
--privileged=true \
kibana:7.12.1
```


#Docker修改容器为自启:
```shell
docker update kibana --restart=always
```


#访问kibana
```text
http://localhost:5601/
```

