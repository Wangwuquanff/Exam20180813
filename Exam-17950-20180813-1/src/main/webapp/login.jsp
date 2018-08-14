<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录界面</title>
</head>
<body>
<center>
    <h1 style="align-content: center; color: aqua">电影租赁系统</h1>
    </br>
    </br>
    </br>
    </br>
    </br>
    </br>
    </br>
    </br>
    <h1 style="color:red">登录</h1>
    <form id="indexform" name="indexForm" action="<%=path%>/login" method="get">
        <table border="0">
            <tr>
                <td>账号：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password">
                </td>
            </tr>
        </table>
        <br>
        <span><input type="submit" value="登录" style="color:#BC8F8F">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" style="color:#BC8F8F"></span>

    </form>
</center>
</body>
</html>