# SpringBoot中MongoDB注解概念及使用

# @Id
主键，不可重复，自带索引，可以在定义的列名上标注，需要自己生成并维护不重复的约束。 如果自己不设置@Id主键，mongo会自动生成一个唯一主键，并且插入时效率远高于自己设置主键。 原因可参考上一篇mongo和mysql的性能对比。
在实际业务中不建议自己设置主键，应交给mongo自己生成，自己可以设置一个业务id，如int型字段，用自己设置的业务id来维护相关联的表。


# @Document
标注在实体类上，类似于hibernate的entity注解，标明由mongo来维护该表。
```java
import org.springframework.data.mongodb.core.mapping.Document;

//若未加 @Document，该 bean save 到 mongo 的 user collection
//若添加 @Document，则 save 到 mongo 的 reUser collection
@Document(collection = "reUser")
public class User {

}
```

# @Indexed
声明该字段需要加索引，加索引后以该字段为条件检索将大大提高速度。 唯一索引的话是@Indexed(unique = true)。 也可以对数组进行索引，如果被索引的列是数组时，MongoDB会索引这个数组中的每一个元素。
也可以对整个Document进行索引，排序是预定义的按插入BSON数据的先后升序排列。 也可以对关联的对象的字段进行索引，譬如User对关联的address.city进行索引。


# @CompoundIndex
复合索引，加复合索引后通过复合索引字段查询将大大提高速度。
```java
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@CompoundIndexes({
        @CompoundIndex(name = "age_idx", def = "{'lastName' : 1, 'age' : -1}")
})
public class User {

}
```


# @Field
代表一个字段，可以不加，不加的话默认以参数名为列名。
```java
import org.springframework.data.mongodb.core.mapping.Field;
//给映射存储到 mongodb 的字段起别名
//在java bean 中字段名为firstName,存储到mongo中 key为 fName
public class User {
    @Field("fName")
    private String firstName;
}
```


# @Transient
被该注解标注的，将不会被录入到数据库中。只作为普通的javaBean属性。


#@DBRef
关联另一个document对象。类似于mysql的表关联，但并不一样，mongo不会做级联的操作。
<更多详情请自行搜索学习>