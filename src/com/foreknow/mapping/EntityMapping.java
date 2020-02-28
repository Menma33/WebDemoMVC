package com.foreknow.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityMapping {
    /**
     * 将结果集重的一行数据映射成一个对象
     */
    public Object mapping(ResultSet rs) throws SQLException;
}
