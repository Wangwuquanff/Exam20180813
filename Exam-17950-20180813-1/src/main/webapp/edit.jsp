<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String fid = (String)request.getParameter("Fid");
    String mtitle = (String)request.getParameter("Tit");
    String mdec = (String)request.getParameter("Des");
    String mname = (String)request.getParameter("Lan");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>编辑界面</title>
</head>
<body>
<center>
    <h1 style="align-content: center; color: aqua">修改您的信息</h1>
    </br>
    </br>
    </br>
    </br>
    <h1 style="color:red">信息</h1>
    <form id="indexform" name="indexForm" action="Editfilm" method="get">
        <table border="0">
             <tr>
                <td>序号：</td>
                <td><input type="text" name="xuhao" value="<%=fid%>"></td>
            </tr>
            <tr>
                <td>标题：</td>
                <td><input type="text" name="biaoti" value="<%=mtitle%>" ></td>
            </tr>
            <tr>
                <td>描述：</td>
                <td><input type="text" name="miaoshu" value="<%=mdec%>"></td>
            </tr>
            <tr>
                <td>语言：</td>
                <td><input type="text" name="yuyan" value="<%=mname%>" disabled="true"></td>
            </tr>
        </table>
        <br>
        <span><input type="submit" value="修改" style="color:#BC8F8F">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" style="color:#BC8F8F"></span>

    </form>
</center>
</body>
</html>