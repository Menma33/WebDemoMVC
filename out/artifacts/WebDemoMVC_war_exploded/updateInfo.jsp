<%@ page import="com.foreknow.model.Guestbook" %><%--
  Created by IntelliJ IDEA.
  User: menma
  Date: 2020/2/27
  Time: 6:38 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    Guestbook gb = (Guestbook) request.getAttribute("message");
%>
<html>
<head>
    <title>修改信息</title>
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/CLEditor1_3_0/jquery.cleditor.css">
    <script src="<%=path%>/CLEditor1_3_0/jquery.min.js"></script>
    <script src="<%=path%>/CLEditor1_3_0/jquery.cleditor.js"></script>
    <script>
        $(function () {
            //初始化cleditor插件
            $("#input").cleditor();
        })
    </script>
</head>
<div class="container">
    <form class="form-horizontal" method="post" action="message?q=update&id=<%=gb.getId()%>">
        <fieldset>
            <legend>
                <h1>修改留言信息</h1>
            </legend>
            <div class="form-group">
                <label for="inputName3" class="col-md-4 control-label">姓名：</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="inputName3" value="<%=gb.getName()%>" name="name">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPhone3" class="col-md-4 control-label">电话号码：</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="inputPhone3" value="<%=gb.getPhone()%>" name="phone">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-md-4 control-label">电子邮箱：</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="inputEmail3" value="<%=gb.getEmail()%>" name="email">
                </div>
            </div>
            <div class="form-group">
                <label for="inputTitle3" class="col-md-4 control-label">标题：</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="inputTitle3" value="<%=gb.getTitle()%>" name="title">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label">内容：</label>
                <div class="col-md-4">
                    <textarea class="form-control" id="input" cols="30" rows="10" name="content"><%=gb.getContent()%></textarea>
                </div>
            </div>

            <div class="form-group" align="center">
                <button type="submit" class="btn btn-primary btn-lg">修改留言</button>
                <button type="reset" class="btn btn-default btn-lg">重置留言</button>
            </div>

            <legend align="center"></legend>

        </fieldset>

    </form>
</div>
</body>
</html>
