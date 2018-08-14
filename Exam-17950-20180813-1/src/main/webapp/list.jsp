<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有电影</title>
<style>
th, tr, td, table {
	border: 1px solid red;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th>FilmId</th>
			<th>Title</th>
			<th>Description<th>
		</tr>
         <c:forEach items="${key_list}" var="usr" varStatus="idx">
            <tr>
				<td>${usr.filmid}</td>
				<td>${usr.title}</td> 
				<td>${usr.description}</td> 
				<td>${usr.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
				<td><input type="button" value="增加"></td>
				<td><input type="button" value="删除" onclick="window.location='DeleteItem?Fid=${usr.filmid}'"></td>
				<td><input type="button" value="编辑" onclick="window.location='edit.jsp?Fid=${usr.filmid}&Des=${usr.description}&Lan=${usr.name}&Tit=${usr.title}'"></td>
			</tr>

		</c:forEach>

	</table>
</body>

</html>