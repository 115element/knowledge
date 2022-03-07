package com.example.sharingspherejpa;

import com.example.sharingspherejpa.bean.User;
import com.example.sharingspherejpa.dao.UserRepository;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.assertj.core.api.ObjectEnumerableAssert;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SharingspherejpaApplicationTests {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SnowflakeShardingKeyGenerator snow;

    @Test
    void contextLoads() {

        for (int i = 0; i < 10; i++) {
            Comparable<?> comparable = snow.generateKey();

            System.out.println(comparable);
            User user = new User();
            user.setId((Long) comparable);
            user.setName("alex");
            user.setCity("dalian");
            userRepository.save(user);
        }
    }

    @Test
    void findAll() {
        List<User> all = userRepository.findAll();
        System.out.println(all.size());

        //: Rule Type: sharding
        //: Logic SQL: select user0_.id as id1_0_, user0_.city as city2_0_, user0_.name as name3_0_ from t_user user0_
        //: SQLStatement: SelectStatement(super=DQLStatement(super=AbstractSQLStatement(type=DQL, tables=Tables(tables=[Table(name=t_user, alias=Optional.of(user0_))]), routeConditions=Conditions(orCondition=OrCondition(andConditions=[])), encryptConditions=Conditions(orCondition=OrCondition(andConditions=[])), sqlTokens=[TableToken(tableName=t_user, quoteCharacter=NONE, schemaNameLength=0)], parametersIndex=0, logicSQL=select user0_.id as id1_0_, user0_.city as city2_0_, user0_.name as name3_0_ from t_user user0_)), containStar=false, firstSelectItemStartIndex=7, selectListStopIndex=75, groupByLastIndex=0, items=[CommonSelectItem(expression=user0_.id, alias=Optional.of(id1_0_)), CommonSelectItem(expression=user0_.city, alias=Optional.of(city2_0_)), CommonSelectItem(expression=user0_.name, alias=Optional.of(name3_0_))], groupByItems=[], orderByItems=[], limit=null, subqueryStatement=null, subqueryStatements=[], subqueryConditions=[])
        //: Actual SQL: ds0 ::: select user0_.id as id1_0_, user0_.city as city2_0_, user0_.name as name3_0_ from t_user user0_
        //: Actual SQL: ds1 ::: select user0_.id as id1_0_, user0_.city as city2_0_, user0_.name as name3_0_ from t_user user0_
        //: Actual SQL: ds2 ::: select user0_.id as id1_0_, user0_.city as city2_0_, user0_.name as name3_0_ from t_user user0_
    }


    @Test
    public void sharp(){
        Comparable<Integer> integerComparable = get();
        System.out.println(integerComparable);
    }


    //这种写法相当于多肽，尖括号中的类型必须实现了Comparable接口
    public Comparable<Integer> get() {
        return 1;
    }

}
