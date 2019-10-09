package top.xiaohuashifu.learn.jvm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.xiaohuashifu.learn.jvm.pojo.vo.UserVO;
import top.xiaohuashifu.learn.jvm.service.UserBatchService;
import top.xiaohuashifu.learn.jvm.service.UserService;

import java.util.List;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-22 17:23
 */
@Service("userBatchService")
public class UserBatchServiceImpl implements UserBatchService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.NESTED)
    public int saveUsers(List<UserVO> userVOList) {
        int count = 0;
        for (UserVO userVO : userVOList) {
            userService.saveUser(userVO);
            count ++;
        }
        return count;
    }

}
