package top.xiaohuashifu.learn.jvm.dao;

import org.apache.ibatis.annotations.Mapper;
import top.xiaohuashifu.learn.jvm.pojo.do0.UserDO;

import java.util.List;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-21 15:46
 */
@Mapper
public interface UserMapper {
    UserDO getUser(Integer id);

    UserDO getUserByUsername(String username);

    int saveUser(UserDO userDO);

    int delete(Integer id);

    List<UserDO> listUsers(String username);


}
