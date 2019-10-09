package top.xiaohuashifu.learn.jvm.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-09 10:39
 */
@Component
public class WwwHealthIndicator extends AbstractHealthIndicator {

    private final static String BAIDU_HOST = "www.baidu.com";

    private final static int TIME_OUT = 3000;

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        boolean status = ping();
        if (status) {
            builder.withDetail("message", "当前服务器可以访问万维网。").up();
        } else {
            builder.withDetail("message", "当前服务器无法访问万维网。").outOfService();
        }
    }


    private boolean ping() {
        try {
            return InetAddress.getByName(BAIDU_HOST).isReachable(TIME_OUT);
        } catch (Exception ex) {
            return false;
        }
    }

}
