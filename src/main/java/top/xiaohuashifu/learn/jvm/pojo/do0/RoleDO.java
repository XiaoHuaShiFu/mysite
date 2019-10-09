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
@Alias(value = "role")
@Entity
public class RoleDO implements Serializable {

    private static final long serialVersionUID = -19978533650884498L;

    @Id
    private Integer id;

    private String roleName;

    private Date createTime;

    private Date updateTime;

    public RoleDO() {
    }

    public RoleDO(Integer id, String roleName, Date createTime, Date updateTime) {
        this.id = id;
        this.roleName = roleName;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
        return "RoleDO{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
