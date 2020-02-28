package com.foreknow.controller;

import com.foreknow.model.Admin;
import com.foreknow.service.AdminService;
import com.foreknow.service.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        //如何获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        AdminService service = new AdminServiceImpl();
        Admin admin = service.isValidate(username,password);
        if (admin!=null){
            req.getRequestDispatcher("/user/message?q=list").forward(req,resp);
        }else{
            out.println("登陆失败");
        }
        
    }
}
