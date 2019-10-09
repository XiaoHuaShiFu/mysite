package top.xiaohuashifu.learn.jvm.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import top.xiaohuashifu.learn.jvm.pojo.vo.UserVO;
import top.xiaohuashifu.learn.jvm.service.UserService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MVCControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
    }

    @MockBean
    private UserService userService;

    @Test
    public void format() throws Exception {
        UserVO userVO = new UserVO();
        userVO.setId(3);
        userVO.setPassword("test");
        userVO.setUsername("xxxx");
        BDDMockito.given(userService.getUser(3)).willReturn(userVO);

        System.out.println(userService.getUser(3));


//        Map<String, Object> map = new HashMap<>();
//        map.put("date", "2017-08-08");
//        map.put("number", "1,234,567.89");
//        System.out.println(testRestTemplate.getForEntity("/mvc", Object.class, map));


//        MockHttpServletRequestBuilder mockMvcRequestBuilders = MockMvcRequestBuilders
//                .get("/mvc")
//                .param("date", "2017-08-08")
//                .param("number", "1,234,567.89");
//        String result = mvc.perform(mockMvcRequestBuilders)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn().getResponse().getContentAsString();
//        System.out.println(result);
//        Assert.assertEquals("{hhaha}", result);
    }

    @Test
    public void list() throws Exception {
        MockHttpServletRequestBuilder mockMvcRequestBuilders = MockMvcRequestBuilders
                .get("/mvc/list")
                .param("genderList", "1, 1, 0, 1, 2");
        String result = mvc.perform(mockMvcRequestBuilders)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
        Assert.assertEquals("{hhaha}", result);

    }
}