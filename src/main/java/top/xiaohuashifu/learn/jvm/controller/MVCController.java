package top.xiaohuashifu.learn.jvm.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import top.xiaohuashifu.learn.jvm.constant.Gender;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-05 15:48
 */
@RestController
@RequestMapping("/mvc")
public class MVCController {

    @GetMapping
    public Map<String, Object> format(
            Date date,
            @NumberFormat(pattern = "#,###.##") Double number) {
        Map<String, Object> map = new HashMap<>();
        map.put("date", date);
        map.put("number", number);
        return map;
    }

    @GetMapping("/list")
    public List<Gender> list(
            List<Gender> genderList) {
        return genderList;
    }

}
