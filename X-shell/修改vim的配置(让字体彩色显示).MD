vimrc文件是vim的环境设置文件。
整体的vim的设置是在 /etc/vimrc 文件中。
不建议修改/etc/vimrc 文件，每个用户可以在用户根目录中设置vim，新建 ~/.vimrc.
vim的配置选项较多，

:set all
可以查看所有的配置项。

[root@sh-tl-5 jiahang]# vi .vimrc


source ~/.vimrc （修改vim配置后如何生效，你得确定你的vimrc的路径）

======================================================================================
