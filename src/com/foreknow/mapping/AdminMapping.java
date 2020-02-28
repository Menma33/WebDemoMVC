package com.foreknow.mapping;

import com.foreknow.model.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapping implements EntityMapping
{
    @Override
    public Object mapping(ResultSet rs) throws SQLException {
        Admin admin = new Admin();
        admin.setUsername(rs.getString("USERNAME"));
        admin.setPassword(rs.getString("PASSWORD"));
        return admin;
    }
}
