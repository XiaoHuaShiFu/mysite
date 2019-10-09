package top.xiaohuashifu.learn.jvm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import top.xiaohuashifu.learn.jvm.pojo.User;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-06 23:08
 */
@Repository
public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User find(Integer id) {
        return mongoTemplate.findById(id, User.class);
    }

}
