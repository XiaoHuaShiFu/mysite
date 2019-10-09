package top.xiaohuashifu.learn.jvm.service;

import top.xiaohuashifu.learn.jvm.pojo.do0.RoleDO;

import java.util.List;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-03 19:34
 */
public interface RoleService {

    List<RoleDO> listRolesByUsername(String username);

}
