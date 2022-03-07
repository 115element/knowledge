package com.example.jpacollege.jpa_advanced.service;


import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Service
public class UserNativeSqlQueryService {

    @PersistenceContext
    private EntityManager entityManager;

    // 在JPA 2.0 中我们可以使用entityManager.createNativeQuery()来执行原生的SQL语句。
    // 但当我们查询结果没有对应实体类时，query.getResultList()返回的是一个List<Object[]>。
    // 也就是说每行的数据被作为一个对象数组返回。
    // 这样用会使代码非常不容易让人理解， 究竟下标为0的元素到底是什么，
    // 不去数查询语句是不知道的，而且一旦查询语句被调整，Java代码也要一起调整。
    // 这时候我们想如果返回的是Map的话，用起来会清晰的多。
    public void testNativeQuery() {
        String sql = "select id, name, age from t_user";
        Query nativeQuery = entityManager.createNativeQuery(sql);
        List rows = nativeQuery.getResultList();
        for (Object row : rows) {
            Object[] cells = (Object[]) row;
            System.out.println("id=" + cells[0]);
            System.out.println("name=" + cells[1]);
            System.out.println("age=" + cells[2]);
        }
    }


    // 可惜的是JPA的API中并没有提供这样的设置。其实很多JPA的底层实现都是支持返回Map对象的。例如：
    // EclipseLink的query.setHint(QueryHints.RESULT_TYPE, ResultType.Map);
    // Hibernate的.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    // 所以，如果我们想要返回Map并且确定底层用的是某一种JPA的实现时我们可以退而求其次，
    // 牺牲跨实现的特性来满足我们的需求：
    public void testNativeQueryMap() {
        Query query = entityManager.createNativeQuery("select id, name, age from t_user");
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List rows = query.getResultList();
        for (Object obj : rows) {
            Map row = (Map) obj;
            System.out.println("id = " + row.get("id"));
            System.out.println("name = " + row.get("name"));
            System.out.println("age = " + row.get("age"));
        }
        //这里需要注意的是， 用Map肯定要比用Object数组来的效率低。所以你要看性能下降是否在可接受范围内。
        //当然你可以通过自定义ResultTransformer的形式对字段名进行一定的处理， 甚至是可以返回自己需要的POJO。
        //SQLQuery sqlQuery = entityManager.createNativeQuery(sql).unwrap(SQLQuery.class);
        //Query query = sqlQuery.setResultTransformer(Transformers.aliasToBean(自定义的.class));
    }


    //TODO  演示JPA连表查询
    //TODO # group by 必须放在 order by 和 limit之前，不然会报错
    //TODO # 你可以在 SELECT, UPDATE 和 DELETE 语句中使用 Mysql 的 JOIN 来联合多表查询。
    //TODO # JOIN 常用分为如下三类(但不仅仅只有这三类)：
    //TODO # INNER JOIN（内连接,或等值连接）：获取两个表中字段匹配关系的记录；使用MySQL的INNER JOIN(也可以省略 INNER 使用 JOIN，效果一样)
    //TODO # LEFT JOIN（左连接）：获取左表所有记录，即使右表没有对应匹配的记录。
    //TODO # RIGHT JOIN（右连接）： 与 LEFT JOIN 相反，用于获取右表所有记录，即使左表没有对应匹配的记录。
    public void unionQuery() {
        String sql = "select id, name, age from t_user union select id, name, age from t_user_link_table";
        Query unionQuery = entityManager.createNativeQuery(sql);
        List rows = unionQuery.getResultList();
        for (Object row : rows) {
            Object[] cells = (Object[]) row;
            System.out.println("id=" + cells[0]);
            System.out.println("name=" + cells[1]);
            System.out.println("age=" + cells[2]);
        }
    }

    //TODO  演示JPA连表查询(注意：mysql不支持full join,可以通过join+union实现)
    //TODO  演示JPA连表查询
    //TODO # group by 必须放在 order by 和 limit之前，不然会报错
    //TODO # 你可以在 SELECT, UPDATE 和 DELETE 语句中使用 Mysql 的 JOIN 来联合多表查询。
    //TODO # JOIN 常用分为如下三类(但不仅仅只有这三类)：
    //TODO # INNER JOIN（内连接,或等值连接）： 获取两个表中字段匹配关系的记录；使用MySQL的INNER JOIN(也可以省略 INNER 使用 JOIN，效果一样)
    //TODO # LEFT JOIN（左连接）： 获取左表所有记录，即使右表没有对应匹配的记录。
    //TODO # RIGHT JOIN（右连接）： 与 LEFT JOIN 相反，用于获取右表所有记录，即使左表没有对应匹配的记录。
    public void joinQuery() {
        String sql = "select t1.id as id1,t2.name as name2  from t_user t1 join t_user_link_table t2";
        Query nativeSqlLinkTableQuery = entityManager.createNativeQuery(sql);
        List rows = nativeSqlLinkTableQuery.getResultList();
        for (Object row : rows) {
            Object[] cells = (Object[]) row;
            System.out.println("id1=" + cells[0]);
            System.out.println("id2=" + cells[1]);
        }
    }




    ////////////////////////////////////////////////连表查询SQL语句////////////////////////////////////////////////

    //1.会去重复(排重的过程需要遍历、排序和比较，它更耗时，更消耗 cpu 资源。)
    //(select * from user where id=1)
    // union
    //(select * from user where id=2);

    //2.不会去重复
    //(select * from user where id=1)
    // union all
    //(select * from user where id=2);


    //3.小表驱动大表，也就是说用小表的数据集驱动大表的数据集。
    //假如有 order 和 user 两张表，其中 order 表有 10000 条数据，而 user 表有 100 条数据。
    //这时如果想查一下，所有有效的用户下过的订单列表。
    //可以使用in关键字实现：
    //select * from order
    //where user_id in (select id from user where status=1)

    //也可以使用exists关键字实现：
    //select * from order
    //where exists (select 1 from user where order.user_id = user.id and status=1)
    /**
     * EXISTS 用于检查子查询是否至少会返回一行数据，该子查询实际上并不返回任何数据，而是返回值True或False
     * EXISTS 指定一个子查询，检测 [行] 的存在。
     *
     * NOT EXISTS 的作用与 EXISTS 正好相反。如果子查询没有返回行，则满足了 NOT EXISTS 中的 WHERE 子句。
     *
     * 结论：
     * EXISTS(包括 NOT EXISTS )子句的返回值是一个BOOL值。 EXISTS内部有一个子查询语句(SELECT ... FROM...)，
     * 我将其称为EXIST的内查询语句。其内查询语句返回一个结果集。 EXISTS子句根据其内查询语句的结果集空或者非空，返回一个布尔值。
     *
     * 一种通俗的可以理解为：
     * 将外查询表的每一行，代入内查询作为检验，如果内查询返回的结果取非空值，则EXISTS子句返回TRUE，这一行可作为外查询的结果行，否则不能作为结果。
     */

///    select 1 from table的作用及延展
///    ① select 1 from table
///    得到一个行数和table一样的表，每行的列值为1
///
///    ② select count(1)
///    得出一个数，该数是table表的行数
///
///    ③ select sum(1)
///    得出一个数，该数是table表的行数
///
///    第一种的写法是增加临时列，每行的列值是写在select后的数；
///    第二种是不管count(a)的a值如何变化，得出的值总是table表的行数；
///    第三种是计算临时列的值乘以表的行数。


}
