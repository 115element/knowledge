drop table if exists `t_book`;
create table `t_book`(
    `id` int auto_increment,
    `name` varchar(255),
    `author` varchar(255),
    `to_upper_case` varchar(255),
    primary key(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into `t_book` values(null,'1','2','3');
insert into `t_book` values(null,'4','5','6');