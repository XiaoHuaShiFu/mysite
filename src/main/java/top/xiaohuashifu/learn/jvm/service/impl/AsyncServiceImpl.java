package top.xiaohuashifu.learn.jvm.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import top.xiaohuashifu.learn.jvm.service.AsyncService;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-03 21:43
 */
@Service("asyncService")
public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async
    public void generateReport() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ddddddddddddddddddzzzzzzzzzz");
    }
}
