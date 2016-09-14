<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书信息更新</title>
</head>
<body>
<center>
	<form method="post" action="bookup">
		<input type="hidden" name="bid" value="${bid}">
		<table>
			<tr>
				<td>书名：</td>
				<td><input type="text" name="Name" value="${Name}"></td>
			</tr>
			<tr>
				<td>出版社：</td>
				<td><input type="text" name="bPress" value="${bPress}"></td>
			</tr>
			<tr>
				<td>作者：</td>
				<td><input type="text" name="bAuthor" value="${bAuthor}"></td>
			</tr>
			<tr>
				<td>价格：</td>
				<td><input type="text" name="bValue" value="${bValue}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
			<tr><td colspan="2"><a href='booklist'>返回列表</a></td></tr>
		</table>
	</form>
</center>
</body>
</html>