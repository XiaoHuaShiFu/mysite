package top.xiaohuashifu.learn.jvm.service;

import top.xiaohuashifu.learn.jvm.pojo.vo.UserVO;

import java.util.List;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-21 11:39
 */
public interface JdbcUserService {
    int saveUsers(List<UserVO> userVOList);

    UserVO saveUser(UserVO userVO);

    UserVO getUser(Integer id);

}
