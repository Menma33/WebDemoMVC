package com.foreknow.dao.impl;

import com.foreknow.dao.AdminDao;
import com.foreknow.model.Admin;

import java.sql.SQLException;
import java.util.List;

public class AdminDapImpl extends BaseDAO implements AdminDao {
    @Override
    public Admin isCheckLogin(String username, String password) throws SQLException {
        String sql = "select * from admin where username=? and password = ?";
        List<Object> list = jdbcTemplate.query(sql, mappingFactory.getMap(mappingFactory.ADMIN_MAPPING), username, password);
        if (list.size() > 0) {
            return (Admin) list.get(0);
        } else {
            return null;
        }
    }
}
