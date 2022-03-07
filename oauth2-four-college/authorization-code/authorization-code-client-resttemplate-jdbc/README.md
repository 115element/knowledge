# 接入授权码模式客户端使用RestTemplate实现

## 说明
这里使用RestTemplate作为客户端，对接我们的授权码模式的授权服务器和资源服务器，客户端token存储使用数据库实现（仅用作demo）

## 操作流程
1. 启动授权码授权服务器
2. 启动授权码资源服务器
3. 数据库修改并执行`resource/create_table.sql`，启动此项目
4. 访问`http://localhost:9001`点击`点此进入用户详情页`
5. 使用`hellxz`:`abc`登录，这里登录的是客户端服务器
6. 使用`hellxz`:`xyz`登录，这里登录的是授权服务器
7. 进行授权操作
8. 自动重定向到访问的资源页面

## 内部流程说明
- 访问授权详情页时，由于资源被拦截，会弹出登录窗口，登录客户端用户
- 进行用户详情页对应的controller，查数据库看`oauth2_client_db.client_user`表中是否有用户token
- 如果有，使用此token尝试调用资源服务器，没有则去调用授权服务器，获取授权码
- 授权服务器返回授权码到客户端的回调接口`/callback`
- 回调接口中，使用授权码换取token，获取token后保存到数据库与当前security上下文
- 重定向原来的页面，再走一次访问资源服务器调用，如果报错`HttpClientErrorException`，则捕获异常并重走授权（token已过期）
- 最后一切正常，放置资源服务器得到的数据并跳转到页面，进行展示


# 增加用户
```java
package com.github.hellxz.oauth2;

import com.github.hellxz.oauth2.dao.ClientUserRepositories;
import com.github.hellxz.oauth2.domain.ClientUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthorizationCodeClientApp.class)
public class ClientUserTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private MockMvc mockMvc;
    @Autowired
    private ClientUserRepositories clientUserRepositories;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Transactional
    public void insertClientUserTest() {
        ClientUser user = new ClientUser();
        user.setUsername("刺客五六七");
        user.setPassword("567");
        user.setAccessToken("test");
        user.setRefreshToken("test");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis() + 100000000L));
        user.setValidateTokenExpire(calendar);
        ClientUser save = clientUserRepositories.save(user);
        Assert.assertNotNull(save);
        Assert.assertEquals(user.getUsername(), save.getUsername());
        Assert.assertEquals(user.getPassword(), save.getPassword());
    }

    @Test
    public void insertClientUserTest2() {
        ClientUser user = new ClientUser();
        user.setUsername("hellxz");
        user.setPassword(passwordEncoder.encode("abc"));
        ClientUser save = clientUserRepositories.save(user);
        Assert.assertNotNull(save);
        Assert.assertEquals(user.getUsername(), save.getUsername());
        Assert.assertEquals(user.getPassword(), save.getPassword());
    }


    @Test
    public void studyPasswordEncoder() {
        //将明文密码，进行散列算法处理。可以避免密码暴露。
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //密码加密
        String encode = encoder.encode("123");
        System.out.println(encode);

        //此方法用于比较加密后的数据与原有加密的数据是否匹配，返回值为布尔类型。
        boolean matches = encoder.matches("123", encode);
        System.out.println(matches);
    }
}
```