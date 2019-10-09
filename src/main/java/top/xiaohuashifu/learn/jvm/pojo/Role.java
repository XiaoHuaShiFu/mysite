package top.xiaohuashifu.learn.jvm.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-06 21:59
 */
@Document
public class Role implements Serializable {

    private static final long serialVersionUID = -945522096305097345L;

    @Id
    private Integer id;

    private String roleName;

    private String note;

    public Role() {
    }

    public Role(Integer id, String roleName, String note) {
        this.id = id;
        this.roleName = roleName;
        this.note = note;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
