指定多个请求头,-v展示详细请求过程:
curl 52.11.255.147/test.txt -H "Host:betadressapp.reworld.io" -H "User-Agent: Mozilla/5.0" -I -v


所以，我们可以用 -X PUT 和 -X DELETE 来指定另外的请求方法。
curl http://***.***.**.**/api/api -X POST -d "parameterName1=parameterValue1&parameterName2=parameterValue2"
上面就是一个普通的 post带两个参数请求


发起 application/x-www-form-urlencoded 类型的 POST 请求类似，-d 参数值是 JSON 字符串，并且多了一个 Content-Type: application/json 指定发送内容的格式:
curl localhost:3000/api/json -X POST -d '{"hello": "world"}' --header "Content-Type: application/json"


告诉爱E族,我是从百度来:
curl -e http://baidu.com http://aiezu.com


(测试文件上传，curl提供一个-F参数选项用来做文件上传，但是-F参数的格式尤其需要注意，比如-F "file=@c:\Users\Administrator\Desktop\body.txt"，其中参数中的“@”字符很关键，如果没有字符“@”我们的文件依旧无法上传。)
curl -F "pic=@logo.png" -F "site=aiezu"  http://aiezu.com/


告诉爱E族,我是GOOGLE爬虫蜘蛛,其实我是curl命令:
curl -A " Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)" http://aiezu.com


告诉爱E族,我用的是微信内置浏览器:
curl -A "Mozilla/5.0 AppleWebKit/600 Mobile MicroMessenger/6.0" http://aiezu.com


发送cookie:
curl -b "domain=aiezu.com"  http://aiezu.com


看看本站的http头是怎么样的:
curl -I  http://aiezu.com


下载页面:
curl -o index.html http://aiezu.com

下载文件并显示简单进度条:
curl -# -o centos6.8.iso http://mirrors.aliyun.com/centos/6.8/isos/x86_64/CentOS-6.8-x86_64-minimal.iso


继续完成上次终止的未完成的下载:
curl -# -o centos6.8.iso -C - http://mirrors.aliyun.com/centos/6.8/isos/x86_64/CentOS-6.8-x86_64-minimal.iso