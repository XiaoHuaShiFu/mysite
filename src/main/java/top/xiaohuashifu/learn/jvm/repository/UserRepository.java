package top.xiaohuashifu.learn.jvm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
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
public interface UserRepository extends MongoRepository<User, Integer> {

    User find(Integer id);

}
