package com.foreknow.dao.impl;

import com.foreknow.dao.GuestbookDao;
import com.foreknow.model.Guestbook;

import java.sql.SQLException;
import java.util.List;

public class GuestbookDaoImpl extends BaseDAO implements GuestbookDao{

    @Override
    public boolean addMessage(Guestbook gb) {
        String sql = "insert into guestbook(name,email,phone,title,content,createdtime) values(?,?,?,?,?,?)";
        int isRight = jdbcTemplate.update(sql,gb.getName(),gb.getEmail(),gb.getPhone(),gb.getTitle(),gb.getContent(),gb.getCreatedtime());
        return isRight==1;
    }

    @Override
    public List<Object> getQueryAll() throws SQLException {
        String sql = "select * from guestbook";
        List list = jdbcTemplate.query(sql,mappingFactory.getMap(mappingFactory.GUESTBOOK_MAPPING));
        if (list.size()>0){
            return list;
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer id) throws SQLException {
        String sql = "delete from guestbook where id=?";
        return jdbcTemplate.update(sql,id)==1;
    }

    @Override
    public Object selectById(Integer id) throws SQLException {
        String sql = "select * from guestbook where id=?";
        List<Object> list = jdbcTemplate.query(sql,mappingFactory.getMap(mappingFactory.GUESTBOOK_MAPPING),id);
        if (list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean updateMessage(Guestbook gb) throws SQLException {
        String sql = "update guestbook set name=?,email=?,phone=?,title=?,content=?,createdtime=? where id=?";
        int isRight = jdbcTemplate.update(sql,gb.getName(),gb.getEmail(),gb.getPhone(),gb.getTitle(),gb.getContent(),gb.getCreatedtime(),gb.getId());
        return isRight==1;
    }
}
