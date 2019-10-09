package top.xiaohuashifu.learn.jvm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.xiaohuashifu.learn.jvm.pojo.do0.RoleDO;
import top.xiaohuashifu.learn.jvm.pojo.do0.UserDO;
import top.xiaohuashifu.learn.jvm.service.RoleService;
import top.xiaohuashifu.learn.jvm.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-03 19:34
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO userDO = userService.getUserDO(username);
        List<RoleDO> roleDOList = roleService.listRolesByUsername(username);

        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (RoleDO roleDO : roleDOList) {
            GrantedAuthority authority = new SimpleGrantedAuthority(roleDO.getRoleName());
            authorityList.add(authority);
        }
        User user = new User(userDO.getUsername(), userDO.getPassword(), authorityList);
        System.out.println(user);
        return user;
    }
}
