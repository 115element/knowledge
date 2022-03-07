alter table `t_domain_info` add column `belong_domain_group` VARCHAR(255)  NULL comment '所属域名组';

alter table `t_domain_info` add column `customer` VARCHAR(255) NULL comment '所属主客户(客户信息合并版本过渡)';

create index index_bdg on `t_domain_info`(`belong_domain_group`);

create index index_customer on `t_domain_info`(`customer`);