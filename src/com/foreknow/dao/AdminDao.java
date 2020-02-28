package com.foreknow.dao;

import com.foreknow.model.Admin;

import java.sql.SQLException;

public interface AdminDao {

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    public Admin isCheckLogin(String username,String password) throws SQLException;
}
