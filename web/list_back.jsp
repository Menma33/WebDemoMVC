<%@ page import="java.util.List" %>
<%@ page import="com.foreknow.model.Guestbook" %><%--
  Created by IntelliJ IDEA.
  User: menma
  Date: 2020/2/27
  Time: 9:21 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>所有留言</title>
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">

</head>
<body>

<%--<%=list.size()%>--%>
<div class="container">
    <table class="table table-hover">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>phone</td>
            <td>email</td>
            <td>title</td>
            <td>content</td>
            <td>createdtime</td>
            <td>操作</td>
        </tr>
        <%
            List<Object> list = (List<Object>) request.getAttribute("list");
            for (Object item:list){
                Guestbook gb = (Guestbook)item;
        %>
        <tr>
            <td><%=gb.getId()%></td>
            <td><%=gb.getName()%></td>
            <td><%=gb.getPhone()%></td>
            <td><%=gb.getEmail()%></td>
            <td><%=gb.getTitle()%></td>
            <td><%=gb.getContent()%></td>
            <td><%=gb.getCreatedtime()%></td>
            <td>
                <a href="<%=path%>/user/message?q=search&id=<%=gb.getId()%>" class="btn btn-primary">修改</a>
                <a href="<%=path%>/user/message?q=delete&id=<%=gb.getId()%>" class="btn btn-danger">删除</a>
            </td>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
