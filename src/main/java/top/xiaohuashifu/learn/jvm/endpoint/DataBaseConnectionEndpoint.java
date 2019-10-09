package top.xiaohuashifu.learn.jvm.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-09 2:39
 */
@Component
@Endpoint(
        id="dbcheck",
        // 是否在默认情况下启动端点
        enableByDefault = true
)
public class DataBaseConnectionEndpoint {

    /**
     * @ReadOperation 代表HTTP的GET请求
     * @return
     */
    @ReadOperation
    public Map<String, Object> test() {
        Map<String, Object> map = new HashMap<>();
        map.put("connect", "success");
        return map;
    }

}
