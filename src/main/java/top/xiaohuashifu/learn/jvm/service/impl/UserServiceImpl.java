package top.xiaohuashifu.learn.jvm.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.xiaohuashifu.learn.jvm.dao.UserMapper;
import top.xiaohuashifu.learn.jvm.pojo.do0.UserDO;
import top.xiaohuashifu.learn.jvm.pojo.vo.UserVO;
import top.xiaohuashifu.learn.jvm.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 描述:用户服务层
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @update 2019-09-22 11:41
 * @create 2019-09-22 11:41
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * UserMapper
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUsers(List<UserVO> userVOList) {
        int count = 0;
        for (UserVO userVO : userVOList) {
            saveUser(userVO);
            count ++;
        }
        return count;
    }

    @Override
    @CachePut(value = "redisCache", key = "'redis_user_'+#result.id")
    public UserVO saveUser(UserVO userVO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userVO, userDO);
        userMapper.saveUser(userDO);
        userVO.setId(userDO.getId());
        return userVO;
    }

    @Override
    @CacheEvict(value = "redisCache", key = "'redis_user_'+#id")
    public Map<String, Object> deleteUser(Integer id) {
        int delete = userMapper.delete(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", delete >= 1 ? "删除成功" : "删除失败");
        return map;
    }

    @Override
    @Cacheable(value = "redisCache", key = "'redis_user_'+#id")
    public UserVO getUser(Integer id) {
        UserDO userDO = userMapper.getUser(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userDO, userVO);
        return userVO;
    }

    @Override
    @Cacheable(value = "redisCache", key = "'redis:userDO:'+#id")
    public UserDO getUserDO(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public List<UserVO> listUsers(String username) {
        List<UserDO> userDOList = userMapper.listUsers("%" + username + "%");
        return userDOList.stream().map(userDO ->  {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(userDO, userVO);
            return userVO;
        }).collect(Collectors.toList());
    }


}
