package com.foreknow.service;

import com.foreknow.dao.AdminDao;
import com.foreknow.dao.impl.AdminDapImpl;
import com.foreknow.db.DBManager;
import com.foreknow.model.Admin;

import java.sql.Connection;
import java.sql.SQLException;

public class AdminServiceImpl implements AdminService{
    @Override
    public Admin isValidate(String username, String password) {
        DBManager dbManager =DBManager.getInstance();
        Connection connection = dbManager.getConnection();
        AdminDapImpl adminDao = new AdminDapImpl();
        adminDao.setConnection(connection);
        Admin admin = null;
        try {
            admin = adminDao.isCheckLogin(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
