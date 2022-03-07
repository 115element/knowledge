sudo -s
用root的权限执行当前用户的shell，当前目录不改变，当前的shell也不改变(但是是新创建一个shell进程)。


sudo -i
用root的权限执行当前用户的shell，当前目录改变至/root，当前的shell变为root用户的shell。


sudo su
用root的权限执行root的shell，当前目录不改变，当前的shell变为root用户的shell。
```
sudo su    切换root身份，不携带当前用户环境变量。
sudo su -  切换root身份，携带当前用户环境变量。
```


```
以上理论检验方法：[echo $SHELL]查看当前用户的shell。
新建一个用户，修改用户的默认shell，[chsh -s /bin/csh]修改用户默认shell为csh，重新登录既生效。
然后执行以上命令，检验理论是否正确。我已检验过，是正确的的。
```

sudo -i和sudo -s的主要区别在于：
    sudo -i为您提供了根环境，即您的~/.bashrc被忽略。
    sudo -i模拟登录到root帐户：您的工作目录将是/root，并且root的.profile等将在登录时获得
    sudo -s为您提供用户环境，因此您的~/.bashrc得到了尊重。
    sudo -s以root身份启动一个shell，但不会更改您的工作目录。 


使用su不加任何参数，默认是切换到root用户，不变环境变量
使用su – 普通用户切换到root用户，改变环境变量



环境变量：
```
/etc/profile:此文件为系统的每个用户设置环境信息,当用户第一次登录时,该文件被执行。并从/etc/profile.d目录的配置文件中搜集shell的设置。

/etc/bashrc:为每一个运行bash shell的用户执行此文件.当bash shell被打开时,该文件被读取.

~/.bash_profile:每个用户都可使用该文件输入专用于自己使用的shell信息,当用户登录时,该文件仅仅执行一次!默认情况下,他设置一些环境变量,执行用户的.bashrc文件.

~/.bashrc:该文件包含专用于你的bash shell的bash信息,当登录时以及每次打开新的shell时,该文件被读取.

~/.bash_logout:当每次退出系统(退出bash shell)时,执行该文件. 

（另外,/etc/profile中设定的变量(全局)的可以作用于任何用户,而~/.bashrc等中设定的变量(局部)只能继承/etc/profile中的变量,他们是"父子"关系）
```



