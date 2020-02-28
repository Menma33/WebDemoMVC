package com.foreknow.test;

import com.foreknow.db.DBManager;

public class TestDBManager {
    public static void main(String[] args) {
        DBManager dbManager = DBManager.getInstance();
        dbManager.getConnection();
    }
}
