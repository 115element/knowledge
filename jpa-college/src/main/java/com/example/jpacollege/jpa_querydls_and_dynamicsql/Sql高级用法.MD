### SQL的IF语句
MySQL的IF既可以作为表达式用，也可在存储过程中作为流程控制语句使用，如下是做为表达式使用：
语法： IF(expr1,expr2,expr3)
如果 expr1 是TRUE (expr1 <> 0 and expr1 <> NULL)，则 IF()的返回值为expr2; 否则返回值则为 expr3。
    IF() 的返回值为数字值或字符串值，具体情况视其所在语境而定。
[select * from t_refresh_error e where if(?2!=2,e.process_state=?2,1=1) and if(?1!=0,action_id=?1,1=1)]

### SQL的COALESCE()
用法：Select  COALESCE(null,null,'1','2') 返回 1
作用：返回其参数中第一个非空表达式。
语法：COALESCE(Expression1,Expression2,Expression3,......)：接受一系列的表达式或列，返回第一个非空的值。
["select * from t_refresh_task where if(coalesce(?1) is not null, id in (?1), 1=1) " +
"and if(?2 is not null,custom=?2,1=1) " +
"and if(?3 is not null,action_type=?3,1=1) " +
"and if(?4 is not null,start_time between ?4 and ?5,1=1) " +
"order by start_time desc ""]
// COALESCE是一个函数， (expression_1, expression_2, ...,expression_n)依次参考各参数表达式，
// 遇到非null值即停止并返回该值。如果所有的表达式都是空值，最终将返回一个空值


### SQL的ISNULL()
语法：ISNULL(check_expression , replacement_value)
用法 Select  ISNULL(null,0) 返回 0
作用：遇到null,返回指定值。
【如果check_expression是null，那么替换为replacement_value的值】


### SQL的NULLIF()
用法 Select  NULLIF('aa','aa')  返回 null,  NULLIF(1,2)  返回 1
作用：两个值相等则返回null。
【NULLIF(Expression1,Expression2):给定两个参数Expression1和Expression2，如果两个参数相等，则返回NULL；否则就返回第一个参数。】


### SQL的CASE WHEN
```text
一张表数据如下
1900-1-1  胜
1900-1-1  胜
1900-1-1  负
1900-1-2  胜
1900-1-2  胜

写出一条SQL语句，使检索结果如下:
胜           负
1900-1-1 2   1
1900-1-2 2   0

我随手建了这样一个表：
create table test(Date varchar(50) null, Result varchar(50) null)
并将上面的数据都插入到表中。

经过一番尝试和修改，终于得到了答案：
select distinct Date,
sum(case Result when '胜' then 1 else 0 end) as '胜',
sum(case Result when '负' then 1 else 0 end) as '负'
from test
group by date
```



####JPA
```text
演示@Query()参数设置。
?x   和   :XX不能混用。
在JPA查询中转义冒号':'用法。

#stu.age        表示取stu的age属性。
#{#stu.age}     表示取stu的age属性的值。

@Modifying
@Query(value = "update Student s set s.name = :#{#stu.name}, s.age = :#{#stu.age}, " +
"s.alias = :#{#stu.alias} where s.id = :#{#stu.id}")
int updatePayState2(@Param("stu") Student stu);
```

#Hibernate 中 HQL问号与冒号的区别：
在网上搜资料，得到的答案是基本相同，既然是基本相同并不是完全相同，所以肯定有区别。
目前发现的区别就是用了[?No]，则用变量的序号来赋值，从0开始。
如果用了[:变量名]，则用变量名来赋值。
