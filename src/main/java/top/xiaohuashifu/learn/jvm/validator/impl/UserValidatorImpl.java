package top.xiaohuashifu.learn.jvm.validator.impl;

import top.xiaohuashifu.learn.jvm.pojo.vo.UserVO;
import top.xiaohuashifu.learn.jvm.validator.UserValidator;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-21 12:07
 */
public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validate(UserVO userVO) {
        System.out.println("Test test");
        return userVO != null;
    }
}
