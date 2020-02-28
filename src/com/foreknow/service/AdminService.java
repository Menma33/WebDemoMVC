package com.foreknow.service;

import com.foreknow.model.Admin;

public interface AdminService {

    /**
     * 验证登陆
     * @param username
     * @param password
     * @return
     */
    public Admin isValidate(String username,String password);
}
