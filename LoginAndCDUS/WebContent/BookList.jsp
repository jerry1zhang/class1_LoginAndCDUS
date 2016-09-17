<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书列表</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	function save(){
		if ($("#key").val()=="") {
			$("#selectTop").val("搜索框为空");
			return false;
		}

		$("#Form1").submit()
	}
</script>
</head>
<body>
<center>
	<h1>图书列表</h1>
	<table>
		<tr>
			<td>图书编号</td>
			<td>图书名称</td>
			<td>入库时间</td>
			<td>出版社</td>
			<td>作者</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${varlist}" var="var" varStatus="vs">
			<tr>
				<td>${vs.index+1}</td>
				<td>${var.Name}</td>
				<td>${var.bDate}</td>
				<td>${var.bPress}</td>
				<td>${var.bAuthor}</td>
				<td><a href="bookup?bid=${var.Bid}">更新</a><a href="bookdel?bid=${var.Bid}">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td><a href='bookadd'>新增</a></td>
			<form method="post" action="booklist" id="Form1">
				<td colspan="2">书名：<input type="text" name="Name" id="key"></td>
				<td colspan="2"><input type="button" id="Submit" onclick="save()" value="搜索"></td>
				<td><p id="selectTop"></p></td>
			</form>
		</tr>
	</table>
</center>
<form></form>
</body>
</html>