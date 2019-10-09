package top.xiaohuashifu.learn.jvm.service;

import top.xiaohuashifu.learn.jvm.pojo.vo.UserVO;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-03 22:19
 */
public interface ActiveMqService {

    void sendMessage(String message);

    void receiveMessage(String message);

    void sendUser(UserVO userVO);

    void receiveUser(UserVO userVO);

}
