package com.foreknow.controller;

import com.foreknow.model.Guestbook;
import com.foreknow.service.GuestbookService;
import com.foreknow.service.GuestbookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        GuestbookService service = new GuestbookServiceImpl();
        Guestbook gb = new Guestbook();
        gb.setName(name);
        gb.setPhone(phone);
        gb.setEmail(email);
        gb.setTitle(title);
        gb.setContent(content);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String createdTime = simpleDateFormat.format(new Date());
        gb.setCreatedtime(createdTime);

        if(service.save(gb)){
//            out.println("<a href='/WebDemoMVC/user/get'>查看所有留言信息</a>");
//            req.getRequestDispatcher("/user/get").forward(req,resp);
//            resp.sendRedirect(req.getContextPath()+"/user/get");
            req.getRequestDispatcher("/user/message?q=list").forward(req,resp);
        }else{
            out.println("添加失败");
        }

    }
}
