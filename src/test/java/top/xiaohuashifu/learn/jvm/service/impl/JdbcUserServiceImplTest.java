package top.xiaohuashifu.learn.jvm.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.xiaohuashifu.learn.jvm.constant.Gender;
import top.xiaohuashifu.learn.jvm.pojo.vo.UserVO;
import top.xiaohuashifu.learn.jvm.service.JdbcUserService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcUserServiceImplTest {

    @Autowired
    private JdbcUserService jdbcUserService;

    private UserVO userVO;

    @Before
    public void before() throws Exception{
        userVO = new UserVO();
        userVO.setUsername("hhhh");
    }

    @Test
    public void saveUsers() {
    }

    @Test
    public void saveUser() {
        UserVO userVO = jdbcUserService.saveUser(this.userVO);
        Assert.assertEquals(userVO.getUsername(), "hhhh");
    }

    @Test
    public void getUser() {
    }
}