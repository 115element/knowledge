
### RPC通信是长链接还是短连接?
现有的RPC框架按底层协议区分机制一般分为两种：长连接和短连接。
长连接:一般基于Socket，而短链接一般都是基于HTTP的,会遵循三次握手原则。
```text
Socket与TCP/IP的关系:
创建Socket连接时，可以指定使用的传输层协议，Socket可以支持不同的传输层协议（TCP或UDP），当使用TCP协议进行连接时，该Socket连接就是一个TCP连接。
Socket则是对TCP/IP协议的封装和应用（程序员层面上）。也可以说，TPC/IP协议是传输层协议，主要解决数据，如何在网络中传输，而HTTP是应用层协议，主要解决如何包装数据。

我们平时说的最多的Socket是什么呢，Socket本身并不是协议，而是一个调用接口（API），通过Socket，我们才能使用TCP/IP协议。 
实际上，Socket跟TCP/IP协议没有必然的联系。Socket编程接口在设计的时候，就希望也能适应其他的网络协议。
所以说，Socket的出现,只是使得程序员更方便地使用TCP/IP协议栈而已，是对TCP/IP协议的抽象，
从而形成了我们知道的一些最基本的函数接口，比如create、 listen、connect、accept、send、read和write等等。
网络有一段关于socket和TCP/IP协议关系的说法比较容易理解：
“TCP/IP只是一个协议栈，就像操作系统的运行机制一样，必须要具体实现，同时还要提供对外的操作接口。
这个就像操作系统会提供标准的编程接口，比如win32编程接口一样，TCP/IP也要提供可供程序员做网络开发所用的接口，这就是Socket编程接口。”
实际上，传输层的TCP是基于网络层的IP协议的，而应用层的HTTP协议又是基于传输层的TCP协议的，
而Socket本身不算是协议，就像上面所说，它只是提供了一个针对TCP或者UDP编程的接口。Socket是对端口通信开发的工具,它要更底层一些.
```


### RPC（Remote Procedure Call）

Restful调用效率太低，远程过程调用可以使用更加短小而精悍的传输模式提高通信效率。RPC本身是一种远程通信的方式，具体实现有很多种方式.

#### 从单机到分布式

单机架构到微服务分布式，最底层还是机器之间二进制信号的传输。

原始的方式是TCP/TP进行机器之间的通信。

#### RPC序列化框架

对象->二进制

1. java.io.Serializable
2. Hessian
3. Google Protobuf
4. FaceBook Thrift
5. kyro
6. fst
7. json序列化框架 Jackson/Google Gson/Ali FastJson
8. xmlrpc(xstream)

### RPC网络分布式通信协议

- TCP/UDP/HTTP/自定义协议
- CORBA
- Web Service(SOA/SOAP/RDDI/WSDL) 基于http+xml标准化的Web API
- RestFul http+json (representation state transfer)
- RMI (Remote Method Invocation) java内部的分布式通信协议
- JMS
- RPC（统称）

### RPC其他功能

服务注册、服务发现、服务治理、负载均衡等等

