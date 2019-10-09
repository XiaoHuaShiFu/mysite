package top.xiaohuashifu.learn.jvm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-27 14:47
 */
@RestController
@RequestMapping("/interceptor")
public class InterceptorController {

    @GetMapping("/start")
    public Map<String, Object> start() {
        System.out.println("处理器真正执行");
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "成功");
        return map;
    }

}
