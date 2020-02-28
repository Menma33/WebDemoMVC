package com.foreknow.service;

import com.foreknow.dao.impl.GuestbookDaoImpl;
import com.foreknow.db.DBManager;
import com.foreknow.model.Guestbook;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GuestbookServiceImpl implements GuestbookService {
    @Override
    public boolean save(Guestbook gb) {
        DBManager dbManager = DBManager.getInstance();
        Connection conn = dbManager.getConnection();
        GuestbookDaoImpl guestbookDao = new GuestbookDaoImpl();
        guestbookDao.setConnection(conn);
        boolean isRight = false;
        try {
            isRight = guestbookDao.addMessage(gb);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
                isRight = false;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return isRight;
    }

    @Override
    public List<Object> queryInfo() {
        DBManager dbManager = DBManager.getInstance();
        Connection conn = dbManager.getConnection();
        GuestbookDaoImpl guestbookDao = new GuestbookDaoImpl();
        guestbookDao.setConnection(conn);
        List<Object> items = null;
        try {
            items = guestbookDao.getQueryAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public boolean deleteBean(Integer id) {
        DBManager dbManager = DBManager.getInstance();
        Connection conn = dbManager.getConnection();
        GuestbookDaoImpl guestbookDao = new GuestbookDaoImpl();
        guestbookDao.setConnection(conn);
        boolean isRight = false;
        try {
            isRight = guestbookDao.deleteById(id);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
                isRight = false;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return isRight;
    }

    @Override
    public Object searchMessage(Integer id) {
        DBManager dbManager = DBManager.getInstance();
        Connection conn = dbManager.getConnection();
        GuestbookDaoImpl guestbookDao = new GuestbookDaoImpl();
        guestbookDao.setConnection(conn);
        Object message = null;
        try {
            message = guestbookDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public boolean modifyMessage(Guestbook gb) {
        DBManager dbManager = DBManager.getInstance();
        Connection conn = dbManager.getConnection();
        GuestbookDaoImpl guestbookDao = new GuestbookDaoImpl();
        guestbookDao.setConnection(conn);
        boolean isRight = false;
        try {
            isRight = guestbookDao.updateMessage(gb);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
                isRight = false;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return isRight;
    }
}


