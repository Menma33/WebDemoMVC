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
import java.util.List;

public class GetMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        //调用查询
        GuestbookService service = new GuestbookServiceImpl();
        List<Object> list = service.queryInfo();
        out.println("<html>");
        out.println("<head><title>get message</title></head>");
        out.println("<body>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>id</td>");
        out.println("<td>name</td>");
        out.println("<td>phone</td>");
        out.println("<td>email</td>");
        out.println("<td>title</td>");
        out.println("<td>content</td>");
        out.println("</tr>");
        for (Object value : list) {
            Guestbook guestbook = (Guestbook) value;
            out.println("<tr>");
            out.println("<td>" + guestbook.getId() + "</td>");
            out.println("<td>" + guestbook.getName() + "</td>");
            out.println("<td>" + guestbook.getPhone() + "</td>");
            out.println("<td>" + guestbook.getEmail() + "</td>");
            out.println("<td>" + guestbook.getTitle() + "</td>");
            out.println("<td>" + guestbook.getContent() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
