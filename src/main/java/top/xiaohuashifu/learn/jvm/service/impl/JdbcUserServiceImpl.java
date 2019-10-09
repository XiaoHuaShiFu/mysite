package top.xiaohuashifu.learn.jvm.service.impl;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import top.xiaohuashifu.learn.jvm.dao.UserMapper;
import top.xiaohuashifu.learn.jvm.pojo.do0.UserDO;
import top.xiaohuashifu.learn.jvm.pojo.vo.UserVO;
import top.xiaohuashifu.learn.jvm.service.JdbcUserService;
import top.xiaohuashifu.learn.jvm.service.UserService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * 描述:用户服务层
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @update 2019-09-22 11:41
 * @create 2019-09-22 11:41
 */
@Service("jdbcUserService")
public class JdbcUserServiceImpl implements JdbcUserService {

    /**
     * UserMapper
     */
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DataSource dataSource;

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
    public UserVO saveUser(UserVO userVO) {
        Connection connection = null;
        try {
            // 获取连接
            connection = dataSource.getConnection();
            // 开启事务
            connection.setAutoCommit(false);
            // 设置隔离级别
            connection.setTransactionIsolation(TransactionIsolationLevel.READ_COMMITTED.getLevel());
            PreparedStatement ps =
                    connection.prepareStatement("insert into t_user(username, gender) values (?, ?)");
            ps.setString(1, userVO.getUsername());
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userVO, userDO);
        userVO.setId(userDO.getId());
        return userVO;
    }

    @Override
    public UserVO getUser(Integer id) {
        UserDO userDO = userMapper.getUser(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userDO, userVO);
        return userVO;
    }

}
