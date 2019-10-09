package top.xiaohuashifu.learn.jvm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xiaohuashifu.learn.jvm.service.AsyncService;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-27 15:29
 */
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/test")
    public String test() {
        System.out.println(Thread.currentThread().getName());
        asyncService.generateReport();
        return "success";
    }


}
