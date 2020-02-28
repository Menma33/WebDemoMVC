package com.foreknow.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "ServletTest",urlPatterns ={"/demo"} ,initParams = {
        @WebInitParam(name = "abc" ,value = "123")
})
public class ServletTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>这bu是一个Servlet程序</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(new Date());
        out.println("服务器端向客户端请求的方法"+request.getMethod());
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        String pageSize = config.getInitParameter("abc");
//        String pageSize = config.getServletContext().getInitParameter("pageSize");
        System.out.printf(pageSize);

    }

    @Override
    public void destroy() {
        System.out.println("销毁了");
    }
}
