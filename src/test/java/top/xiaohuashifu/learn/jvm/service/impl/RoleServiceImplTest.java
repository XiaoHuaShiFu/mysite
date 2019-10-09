package top.xiaohuashifu.learn.jvm.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.xiaohuashifu.learn.jvm.pojo.vo.UserVO;
import top.xiaohuashifu.learn.jvm.service.JdbcUserService;
import top.xiaohuashifu.learn.jvm.service.RoleService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceImplTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void listRolesByUsername() {
        System.out.println(roleService.listRolesByUsername("wjx"));
    }
}