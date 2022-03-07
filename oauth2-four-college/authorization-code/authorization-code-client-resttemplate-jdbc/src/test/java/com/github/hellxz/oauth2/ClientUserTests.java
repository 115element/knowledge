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
