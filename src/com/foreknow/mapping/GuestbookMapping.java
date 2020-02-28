package com.foreknow.mapping;

import com.foreknow.model.Guestbook;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestbookMapping implements EntityMapping {
    @Override
    public Object mapping(ResultSet rs) throws SQLException {
        Guestbook gb = new Guestbook();
        gb.setId(rs.getInt("ID"));
        gb.setName(rs.getString("NAME"));
        gb.setPhone(rs.getString("PHONE"));
        gb.setEmail(rs.getString("EMAIL"));
        gb.setTitle(rs.getString("TITLE"));
        gb.setContent(rs.getString("CONTENT"));
        gb.setCreatedtime(rs.getString("CREATEDTIME"));
        return gb;
    }
}
