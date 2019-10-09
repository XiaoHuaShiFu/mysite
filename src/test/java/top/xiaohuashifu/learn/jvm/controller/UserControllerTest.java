package top.xiaohuashifu.learn.jvm.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import top.xiaohuashifu.learn.jvm.service.UserBatchService;
import top.xiaohuashifu.learn.jvm.service.UserService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void get() {
    }

    @Test
    public void post() throws Exception {
        MockHttpServletRequestBuilder mockMvcRequestBuilders = MockMvcRequestBuilders
                .post("/users")
                .param("username", "hhx")
                .param("password", "123457");
        String result = mvc.perform(mockMvcRequestBuilders)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        Assert.assertEquals("{\"id\":null,\"username\":\"hhh\",\"gender\":\"MAN\"}", result);
    }

    @Test
    public void postBatch() throws Exception {
        MockHttpServletRequestBuilder mockMvcRequestBuilders = MockMvcRequestBuilders
                .post("/users/batch")
                .param("count", "10");
        String result = mvc.perform(mockMvcRequestBuilders)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        Assert.assertEquals("{\"count\":10}", result);
    }

    @Test
    public void useModel() throws Exception {
        MockHttpServletRequestBuilder mockMvcRequestBuilders = MockMvcRequestBuilders
                .get("/users/model")
                .param("id", "10");
        String result = mvc.perform(mockMvcRequestBuilders)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        Assert.assertEquals("{id=hahahhaha}", result);
    }
}