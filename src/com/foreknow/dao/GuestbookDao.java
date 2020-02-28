package com.foreknow.dao;

import com.foreknow.model.Guestbook;

import java.sql.SQLException;
import java.util.List;

/**
 * 接口
 * 在接口中要声明对Guestbook Bean的操作
 */
public interface GuestbookDao {
    /**
     * 添加留言信息
     * @param gb
     * @return
     */
    public boolean addMessage(Guestbook gb);

    /**
     * 查询所有留言信息
     * @return
     * @throws SQLException
     */
    public List<Object> getQueryAll() throws SQLException;

    /**
     * 根据id删除用户信息
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean deleteById(Integer id) throws SQLException;

    /**
     * 根据id查询留言
     * @param id
     * @return
     * @throws SQLException
     */
    public Object selectById(Integer id) throws SQLException;

    /**
     * 更新留言信息
     * @param gb
     * @return
     * @throws SQLException
     */
    public boolean updateMessage(Guestbook gb) throws SQLException;

}
