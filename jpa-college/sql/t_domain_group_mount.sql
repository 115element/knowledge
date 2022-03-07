create table `t_domain_group_mount`
(
    `id`                 bigint       NOT NULL AUTO_INCREMENT,
    `account`            varchar(255) NOT NULL COMMENT '域名组标识,也是账户标识',
    `monitor`            tinyint(1) NOT NULL DEFAULT 0 COMMENT '监控是否开启0or1，默认0不开启',
    `request_rates`      int          NOT NULL DEFAULT 1 COMMENT '请求频率,默认单位为分钟，默认值1',
    `account_number_max` int          NOT NULL DEFAULT 1000 COMMENT '账户请求频率的最大次数，默认值1000',
    PRIMARY KEY (`id`),
    UNIQUE KEY `index_account`(`account`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='域名组挂载信息表';