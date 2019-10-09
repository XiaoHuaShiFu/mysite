package top.xiaohuashifu.learn.jvm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xiaohuashifu.learn.jvm.dao.RoleMapper;
import top.xiaohuashifu.learn.jvm.pojo.do0.RoleDO;
import top.xiaohuashifu.learn.jvm.pojo.do0.UserDO;
import top.xiaohuashifu.learn.jvm.service.RoleService;

import java.util.List;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-03 19:43
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleDO> listRolesByUsername(String username) {
        return roleMapper.listRolesByUsername(username);
    }
}
