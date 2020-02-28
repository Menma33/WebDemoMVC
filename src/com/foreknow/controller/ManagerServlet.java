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
import java.util.List;

public class ManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        //所有的操作都要在doGet中完成
        PrintWriter out = resp.getWriter();
        String method = req.getParameter("q");
        switch (method) {
            case "list":
                list(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "search":
                search(req,resp);
                break;
            case "update":
                update(req,resp);
                break;
            default:
                out.println("没有找到方法");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        //调用查询
        GuestbookService service = new GuestbookServiceImpl();
        List<Object> list = service.queryInfo();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        GuestbookService service = new GuestbookServiceImpl();
        if (service.deleteBean(id)) {
            req.getRequestDispatcher("/user/message?q=list").forward(req, resp);
        }

    }

    protected void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        GuestbookService service = new GuestbookServiceImpl();
        PrintWriter out = resp.getWriter();
        Object message = service.searchMessage(id);
        if (message==null) {
            out.println("没有这条留言");
        }else {
            req.setAttribute("message",message);
            req.getRequestDispatcher("/updateInfo.jsp").forward(req, resp);
        }
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Integer id =Integer.parseInt(req.getParameter("id"));
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
        gb.setId(id);
        if (service.modifyMessage(gb)){
            req.getRequestDispatcher("/user/message?q=list").forward(req, resp);
        }else {
            out.println("修改失败");
        }
    }
}
