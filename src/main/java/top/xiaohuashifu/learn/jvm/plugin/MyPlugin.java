package top.xiaohuashifu.learn.jvm.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.springframework.transaction.PlatformTransactionManager;

import java.sql.Connection;
import java.util.Properties;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-22 2:01
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare",
                args = {Connection.class, Integer.class})
})
public class MyPlugin implements Interceptor {

    private Properties properties;

    // 拦截方法逻辑
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("插件拦截的方法");
        return invocation.proceed();
    }

    // 生成MyBatis拦截器代理对象
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    // 设置插件属性
    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
