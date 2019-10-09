package top.xiaohuashifu.learn.jvm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import top.xiaohuashifu.learn.jvm.pojo.vo.UserVO;
import top.xiaohuashifu.learn.jvm.service.ActiveMqService;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-03 22:20
 */
@Service("activeMqService")
public class ActiveMqServiceImpl implements ActiveMqService {

    @Autowired
    private JmsTemplate jmsTemplate;

    private static final String destination = "xhsf-destination";

    @Override
    public void sendMessage(String message) {
        System.out.println("发送消息" + message);
        jmsTemplate.convertAndSend(message);
    }

    @Override
    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void receiveMessage(String message) {
        System.out.println("收到消息" + message);
    }

    @Override
    public void sendUser(UserVO userVO) {
        System.out.println("发送用户" + userVO);
        jmsTemplate.convertAndSend(destination, userVO);
    }

    @Override
    @JmsListener(destination = destination)
    public void receiveUser(UserVO userVO) {
        System.out.println("收到用户" + userVO);
    }


}
