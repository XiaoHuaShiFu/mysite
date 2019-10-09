package top.xiaohuashifu.learn.jvm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xiaohuashifu.learn.jvm.pojo.vo.UserVO;
import top.xiaohuashifu.learn.jvm.service.ActiveMqService;
import top.xiaohuashifu.learn.jvm.service.AsyncService;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-27 15:29
 */
@RestController
@RequestMapping("/active")
public class ActiveMqController {

    @Autowired
    private ActiveMqService activeMqService;

    @GetMapping("/send/message")
    public String test(String message) {
        activeMqService.sendMessage(message);
        return "success";
    }

    @GetMapping("/send/user")
    public String sendUser(UserVO userVO) {
        activeMqService.sendUser(userVO);
        return "success";
    }

    
}
