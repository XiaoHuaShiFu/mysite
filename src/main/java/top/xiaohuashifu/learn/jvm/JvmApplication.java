package top.xiaohuashifu.learn.jvm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@MapperScan(basePackages = "top.xiaohuashifu.learn.jvm.pojo.do0")
@EnableCaching
public class JvmApplication {

    public static void main(String[] args) {
        SpringApplication.run(JvmApplication.class, args);
//
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        System.out.println(passwordEncoder.encode("1234567"));

    }
}
