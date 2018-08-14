<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form id="indexform" name="indexForm" action="SelectAll" method="get">
        <span><input type="submit" value="插叙吧所有列表" style="color:#BC8F8F"></span>
    </form>

</body>
</html>