package top.xiaohuashifu.learn.jvm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-27 15:29
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public Object get(String key) {
        return redisTemplate.execute(new SessionCallback<>() {
            @Override
            public  Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.watch("zzz");
                redisOperations.multi();
                redisOperations.opsForValue().get("hhh");
                return redisOperations.exec();
            }
        });
    }

    @PostMapping
    public String set(String key, String value) {
        redisTemplate.executePipelined(new SessionCallback<>() {
            @Override
            public  Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.opsForValue().set(key, value);
                redisOperations.opsForValue().set(key, value + 1);
                return null;
            }
        });
        return "success";
    }

    @PostMapping("/session")
    public Object setSession() {
        redisTemplate.execute(new SessionCallback<>() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.opsForValue().set("hhh", "zzzzz");
                redisOperations.opsForValue().set("zzz", "hhhh");
                return null;
            }
        });
        return "success";
    }

    @GetMapping("/session")
    public Object getSession() {
        return redisTemplate.execute((RedisConnection rc) -> {
            HashMap<Object, Object> map = new HashMap<>();
            map.put("hhh", Arrays.toString(rc.get("hhh".getBytes())));
            map.put("zzz", String.valueOf(rc.get("zzz".getBytes())));
            return map;
        });
    }

    @GetMapping("/send")
    public String send(String channel, String message) {
        redisTemplate.convertAndSend(channel, message);
        return "success";
    }

    @GetMapping("/lua")
    public String lua(String key, String value) {
        DefaultRedisScript<String> rs = new DefaultRedisScript<>();
        // 设置脚本
        rs.setScriptText("return 'Hello Redis'");
        // 设置返回类型。不设置则没有返回结果
        rs.setResultType(String.class);

        RedisSerializer<String> stringRedisSerializer = redisTemplate.getStringSerializer();

        // 执行Lua脚本
        String result = (String) redisTemplate.execute(rs, stringRedisSerializer, stringRedisSerializer, null);

        return result;
    }

    @GetMapping("/lua1")
    public Long lua1(String key1, String key2, String value1, String value2) {
        String lua = "redis.call('set', KEYS[1], ARGV[1]) \n"
                + "redis.call('set', KEYS[2], ARGV[2]) \n"
                + "local str1 = redis.call('get', KEYS[1]) \n"
                + "local str2 = redis.call('get', KEYS[2]) \n"
                + "if str1 == str2 then \n"
                + "return 1 \n"
                + "end \n"
                + "return 0 \n";

        DefaultRedisScript<Long> rs = new DefaultRedisScript<Long>();
        // 设置脚本
        rs.setScriptText(lua);
        // 设置返回类型。不设置则没有返回结果
        rs.setResultType(Long.class);

        RedisSerializer<String> stringRedisSerializer = redisTemplate.getStringSerializer();

        List<String> keyList = new ArrayList<>();
        keyList.add(key1);
        keyList.add(key2);

        // 执行Lua脚本
        Long result = (Long) redisTemplate.execute(rs, stringRedisSerializer, stringRedisSerializer, keyList, value1, value2);

        return result;
    }

}
