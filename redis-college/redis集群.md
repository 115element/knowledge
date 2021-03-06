
#为什么redis cluster至少需要三个主节点？ 
1master-1slave，redis集群需要6个节点
1master-2slave，redis集群需要9个节点，以此类推。
---------------------



为啥必须要三个实例呢？我们先看看两个哨兵会咋样。
```
---------           -----------
|   M1  | --------  |   M2    |
|   S1  |           |   S2    |
---------           ----------- 
```

master宕机了 s1和s2两个哨兵只要有一个认为你宕机了就切换了，并且会选举出一个哨兵去执行故障，
但是这个时候也需要大多数哨兵都是运行的。那这样有啥问题呢？M1宕机了，S1没挂那其实是OK的，但是整个机器都挂了呢？
哨兵就只剩下S2个裸屌了，没有哨兵去允许故障转移了，虽然另外一个机器上还有R1，但是故障转移就是不执行。

经典的哨兵集群是这样的：   
```
         ---------
         |   M1  |
         |   S1  |
         ---------
             |
             |   
---------    |      -----------
|   M2  | --------  |   M3    |
|   S2  |           |   S3    |
---------           ----------- 
```

M1所在的机器挂了，哨兵还有两个，两个人一看他不是挂了嘛，那我们就选举一个出来执行故障转移不就好了。

#哨兵组件的主要功能：
集群监控：负责监控 Redis master 和 slave 进程是否正常工作。
消息通知：如果某个 Redis 实例有故障，那么哨兵负责发送消息作为报警通知给管理员。
故障转移：如果 master node 挂掉了，会自动转移到 slave node 上。
配置中心：如果故障转移发生了，通知 client 客户端新的 master 地址。
