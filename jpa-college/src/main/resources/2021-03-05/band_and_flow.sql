CREATE TABLE `t_band_and_flow`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `record_time` datetime                                        NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '日志时间',
    `band_width`  decimal(19, 2)                                           DEFAULT NULL,
    `flow`        decimal(19, 0)                                           DEFAULT '0' COMMENT '流量',
    `domain`      varchar(64)                                     NOT NULL COMMENT '域名',
    `provider`    varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `time_domain` (`record_time`,`domain`,`provider`) USING BTREE,
    KEY           `time_flow` (`record_time`,`flow`,`band_width`,`domain`,`provider`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=215470828 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;