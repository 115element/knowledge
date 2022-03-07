-- 新建数据库2：db_apple
-- 然后创建如下表

CREATE TABLE `t_apple`
(
    `id`     bigint(20) NOT NULL AUTO_INCREMENT,
    `amount` int(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

insert into `t_apple`(`amount`) values(100);