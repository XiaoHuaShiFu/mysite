package top.xiaohuashifu.learn.jvm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-04 18:40
 */
@Configuration
public class RedisConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        // 设置字符串序列化器，这样Spring就会把Redis的key当成字符串处理
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * Redis消息监听器
     * @return MessageListener
     */
    @Bean("redisMessageListener")
    public MessageListener redisMessageListener() {
        return ((message, pattern) -> {
            // 消息体
            String body = new String(message.getBody());
            // 渠道名称
            String topic = new String(pattern);
            System.out.println(body);
            System.out.println(topic);
        });
    }

    /**
     * 任务池
     *
     * @return
     */
    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(20);
        return taskScheduler;
    }

    /**
     *  Redis监听容器
     * @return
     */
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        // Redis连接工厂
        container.setConnectionFactory(redisConnectionFactory);
        // 运行任务池
        container.setTaskExecutor(taskScheduler());
        // 监听频道
        Topic topic = new ChannelTopic("xhsfhome");
        // 使用监听器监听Redis消息
        container.addMessageListener(redisMessageListener(), topic);
        return container;
    }


}
