<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/6/21
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统登录页面</title>
</head>
<body>
    <%--作业：做笔记post和get方法的区别--%>
    <form action="<%=request.getContextPath()%>/system/login.action" name="login_form">
        <table>
            <tr>
               <th colspan="2">用户登录</th>
            </tr>
            <tr>
                <td>帐号：</td>
                <td><input name="account" type="text"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input name="password" type="password" ></td>
            </tr>
            <tr>
                <td><input type="reset"></td>
                <td><input type="submit"></td>
            </tr>
        </table>
    </form>
</body>
</html>
