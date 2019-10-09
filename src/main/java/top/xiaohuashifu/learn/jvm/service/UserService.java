package top.xiaohuashifu.learn.jvm.service;

import top.xiaohuashifu.learn.jvm.pojo.do0.UserDO;
import top.xiaohuashifu.learn.jvm.pojo.vo.UserVO;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-21 11:39
 */
public interface UserService {
    int saveUsers(List<UserVO> userVOList);

    UserVO saveUser(UserVO userVO);

    UserVO getUser(Integer id);

    UserDO getUserDO(String username);

    List<UserVO> listUsers(String username);

    Map<String, Object> deleteUser(Integer id);


}
