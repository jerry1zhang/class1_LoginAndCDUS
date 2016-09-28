<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书信息更新</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	function save(){
		if ($("#Name").val()=="") {
			$("#nameTop").html("书名不能为空");
			return false;
		}
		if ($("#bPress").val()=="") {
			return false;
		}
		if ($("#bAuthor").val()=="") {
			return false;
		}
		if ($("#bValue").val()=="") {
			return false;
		}
		$("#Form").submit();

	}

</script>
</head>
<body>
<center>
	<form method="post" action="bookup" id="Form">
		<input type="hidden" name="bid" value="${bid}">
		<table>
			<tr>
				<td>书名：</td>
				<td><input type="text" name="Name" id="Name" value="${Name}"><span id="nameTop"></span></td>
			</tr>
			<tr>
				<td>出版社：</td>
				<td><input type="text" name="bPress" id="bPress" value="${bPress}"><span id="bPressTop"></span></td>
			</tr>
			<tr>
				<td>作者：</td>
				<td><input type="text" name="bAuthor" id="bAuthor" value="${bAuthor}"><span id="bAuthorTop"></span></td>
			</tr>
			<tr>
				<td>价格：</td>
				<td><input type="text" name="bValue" id="bValue" value="${bValue}"><span id="bValueTop"></span></td>
			</tr>
			<tr>
				<td><input type="button" value="提交" onclick="save()"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
			<tr><td colspan="2"><a href='booklist'>返回列表</a></td></tr>
		</table>
	</form>
</center>
</body>
</html>