package top.xiaohuashifu.learn.jvm.validator;

import top.xiaohuashifu.learn.jvm.pojo.vo.UserVO;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-21 12:06
 */
public interface UserValidator {

    boolean validate(UserVO userVO);

}
