package top.xiaohuashifu.learn.jvm.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.xiaohuashifu.learn.jvm.pojo.vo.UserVO;
import top.xiaohuashifu.learn.jvm.service.ActiveMqService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMqServiceImplTest {

    @Autowired
    private ActiveMqService activeMqService;

    @Test
    public void sendMessage() {
        activeMqService.sendMessage("ddddddddzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzd");
    }

    @Test
    public void receiveMessage() {
    }

    @Test
    public void sendUser() {
        UserVO userVO = new UserVO();
        userVO.setId(33);
        userVO.setUsername("xhsf");
        userVO.setPassword("123456");
        activeMqService.sendUser(userVO);
    }

    @Test
    public void receiveUser() {
    }
}