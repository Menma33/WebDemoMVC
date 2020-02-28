package com.foreknow.service;

import com.foreknow.model.Guestbook;

import java.util.List;

public interface GuestbookService {
    /**
     * 添加留言业务方法
     * @param gb
     * @return
     */
    public boolean save(Guestbook gb);

    /**
     * 查询所有留言信息
     * @return
     */
    public List<Object> queryInfo();

    /**
     * 根据id删除留言信息
     * @param id
     * @return
     */
    public boolean deleteBean(Integer id);

    /**
     * 根据id查找信息
     * @param id
     * @return
     */
    public Object searchMessage(Integer id);

    /**
     * 修改留言
     * @param gb
     * @return
     */
    public boolean modifyMessage(Guestbook gb);
}
