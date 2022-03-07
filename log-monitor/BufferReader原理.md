BufferReader和FileReader差不多，也是用来读取文件的一种字符输入流，
区别就在于BufferReader肚子里也有一个8192长度的char[]字符数组，当做缓冲区使用，
当读取数据的时候，一次性从磁盘当中读取最多8192个字符，放在字符缓冲区当中。
在调用read方法的时候，只是从缓冲区当中拿出来字符进行使用。
如果缓冲区当中的字符被“取空”，那么将会自动再次读取最多8192个再次放在缓冲区当中。

```
//将流包装成为缓冲的BufferReader
BufferReader br = new BufferReader(xx);
//读取单个字符（其实就是从8192的缓冲区当中取出单个字符）
int ch; //代表单个字符
while((ch = br.read()) != -1) {
    System.out.println((char) ch);
}
br.close();

//输出：
//h
//e
//l
//l
//o
```


```
//将流包装成为缓冲的BufferReader
BufferReader br = new BufferReader(xx);
//读取字符数组（其实就是从8192的缓冲区当中取出多个字符使用）
char[] buf = new char[2]; //一次取出两个
int len; //代表有效个数
while((len = br.read(buf)) != -1) {
    String str = new String(buf,0,len)
    System.out.println(str);
}
bt.close(); //关闭

//输出：
//he
//ll
//o
```




说到java reader缓存, 其实有两层缓存:
1. OS缓存, 把磁盘数据 读入内存, 通过read ahead, io scheduler等减少磁盘读取次数.
2. App缓存, 做缓存/预读, 即BufferReader的角色.

BufferReader的作用, 我的理解:
一) 减少System Call次数; 
二) 减少磁盘读取次数.