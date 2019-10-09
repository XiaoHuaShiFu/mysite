package top.xiaohuashifu.learn.jvm.pojo.vo;

import java.io.Serializable;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-10-02 23:28
 */
public class RoleVO implements Serializable {

    private static final long serialVersionUID = 5182596508183723247L;

    private Integer id;

    private String name;

    public RoleVO() {
    }

    public RoleVO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
