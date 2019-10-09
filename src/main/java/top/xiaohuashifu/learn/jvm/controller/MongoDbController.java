package top.xiaohuashifu.learn.jvm.controller;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;
import top.xiaohuashifu.learn.jvm.pojo.User;
import top.xiaohuashifu.learn.jvm.repository.UserRepository;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-05 15:48
 */
@RestController
@RequestMapping("/mongo")
public class MongoDbController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
        return userRepository.find(id);
    }

    @PostMapping
    public User post(@RequestBody User user) {
        return mongoTemplate.save(user);
    }

    @DeleteMapping("/{id}")
    public DeleteResult delete(@PathVariable Integer id) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = Query.query(criteria);
        return mongoTemplate.remove(query, User.class);
    }

    @PutMapping
    public UpdateResult put(@RequestBody User user) {
        Criteria criteria = Criteria.where("id").is(user.getId());
        Query query = Query.query(criteria);
        Update update = Update.update("username", user.getUsername());
        update.set("roles", user.getRoles());
        return mongoTemplate.updateFirst(query, update, User.class);
    }

}
