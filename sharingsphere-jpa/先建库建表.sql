CREATE DATABASE ds0;
USE ds0;
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`(
                       id bigint(64) not null auto_increment,
                       city varchar(20) not null,
                       name varchar(20) not null,
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE DATABASE ds1;
USE ds1;
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`(
                       id bigint(64) not null auto_increment,
                       city varchar(20) not null,
                       name varchar(20) not null,
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `ds1`.`t_user`(`id`, `city`, `name`) VALUES (001, '青岛', '测试库1');

CREATE DATABASE ds2;
USE ds2;
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`(
                       id bigint(64) not null auto_increment,
                       city varchar(20) not null,
                       name varchar(20) not null,
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `ds2`.`t_user`(`id`, `city`, `name`) VALUES (002, '胶州', '测试库2');