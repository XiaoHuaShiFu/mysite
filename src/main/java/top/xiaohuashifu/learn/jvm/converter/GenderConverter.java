package top.xiaohuashifu.learn.jvm.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import top.xiaohuashifu.learn.jvm.constant.Gender;

/**
 * 描述: 将字符串转换成Gender类型
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-22 17:58
 */
@Component
public class GenderConverter implements Converter<String, Gender> {
    @Override
    public Gender convert(String id) {
        return Gender.getGenderById(Integer.parseInt(id));
    }
}
