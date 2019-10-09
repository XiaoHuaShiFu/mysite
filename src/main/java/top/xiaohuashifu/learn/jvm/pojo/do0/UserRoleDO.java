package top.xiaohuashifu.learn.jvm.pojo.do0;

import org.apache.ibatis.type.Alias;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-02 23:28
 */
@Alias(value = "user_role")
@Entity
public class UserRoleDO implements Serializable {

    private static final long serialVersionUID = -7652902704977087343L;

    @Id
    private Integer id;

    private Integer roleId;

    private Integer userId;

    private Date createTime;

    private Date updateTime;

    public UserRoleDO() {
    }

    public UserRoleDO(Integer id, Integer roleId, Integer userId, Date createTime, Date updateTime) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserRoleDO{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
