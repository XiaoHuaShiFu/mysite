package top.xiaohuashifu.learn.jvm.pojo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-06 21:55
 */
@Document
public class User implements Serializable {

    private static final long serialVersionUID = 6979021185070083218L;
    
    @Id
    private Integer id;

    private String username;

    private String password;

    private Boolean available;
    
    private List<Role> roles;

    public User() {
    }

    public User(Integer id, String username, String password, Boolean available, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.available = available;
        this.roles = roles;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", available=" + available +
                ", roles=" + roles +
                '}';
    }
}
