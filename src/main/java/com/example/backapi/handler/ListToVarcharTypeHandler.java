package com.example.backapi.handler;

import com.example.backapi.pojo.MessageBean;
import com.example.backapi.util.JsonUtils;
import org.apache.ibatis.type.*;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * BaseTypeHandler 这个类型是抽象类型，实现了 TypeHandler 的方法进行通用流程的封装，做了异常处理，并定义了几个类似的抽象方法。
 * 继承 BaseTypeHandler 类型可以极大地降低开发难度。
 *
 */
@MappedTypes(List.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class ListToVarcharTypeHandler extends BaseTypeHandler<List<MessageBean>> {

    /**
     * 将当前messageBean(本质是List)通过JsonUtils.toJson转换为Json格式的字符串，然后通过JDBC的方式将字符串填充到占位符
     * @param ps SQL预编译对象
     * @param i 需要赋值的索引位置(相当于在JDBC中对占位符的位置进行赋值)
     * @param parameter 索引位置i需要赋的值(原本要给这个位置赋的值，在setNonNullParameter方法中主要解决的问题就是将这个自定义类型变成数据库认识的类型)
     * @param jdbcType jdbc的类型
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<MessageBean> parameter, JdbcType jdbcType) throws SQLException {
         //转换成json字符串类型然后存到ps中
        ps.setString(i, JsonUtils.toJson(parameter));
    }

    /**
     * 因为messageBean在数据库中保存的是Json数组格式的字符串，所以先将该字符串通过JsonUtils.fromJsonList工具类转换为多个messageBean对象，再对临时的List进行填充，最后再返回这个List即可
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public List<MessageBean> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return JsonUtils.fromJsonList(rs.getString(columnName), MessageBean.class);
    }

    @Override
    public List<MessageBean> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return JsonUtils.fromJsonList(rs.getString(columnIndex), MessageBean.class);
    }

    @Override
    public List<MessageBean> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return JsonUtils.fromJsonList(cs.getString(columnIndex), MessageBean.class);
    }
}
