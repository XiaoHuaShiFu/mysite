package top.xiaohuashifu.learn.jvm.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import top.xiaohuashifu.learn.jvm.constant.Gender;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 声明jdbcType为整型
@MappedJdbcTypes(JdbcType.INTEGER)
// 声明JavaType为Gender
@MappedTypes(value = Gender.class)
public class GenderTypeHandler extends BaseTypeHandler<Gender> {
    // 设置非空性别参数
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Gender gender, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, gender.getId());
    }

    // 通过列名读取性别
    @Override
    public Gender getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int id = rs.getInt(columnName);
        return Gender.getGenderById(id);
    }

    // 通过下标读取性别
    @Override
    public Gender getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int id = rs.getInt(columnIndex);
        return Gender.getGenderById(id);
    }

    // 通过存储过程读取性别
    @Override
    public Gender getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int id = cs.getInt(columnIndex);
        return Gender.getGenderById(id);
    }
}
