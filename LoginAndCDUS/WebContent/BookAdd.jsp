<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书新增</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	function save(){
		if ($("#Name").val()=="") {
			$("#Name").tips({
				side:3,
	            msg:'请输入书名',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#Name").focus();
			return false;
		}
		if ($("#bPress").val()=="") {
			$("#bPress").tips({
				side:3,
	            msg:'请输入出版社',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#bPress").focus();
			return false;
		}
		if ($("#bAuthor").val()=="") {
			$("#bAuthor").tips({
				side:3,
	            msg:'请输入作者名',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#bAuthor").focus();
			return false;
		}
		if ($("#bValue").val()=="") {
			$("#bValue").tips({
				side:3,
	            msg:'请输入价格',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#bValue").focus();
			return false;
		}
		if ($("#select1").val()=="") {
			$("#select1").tips({
				side:3,
	            msg:'请选择类型',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#select1").focus();
			return false;
		}else{
			$("#BookKindsNo").val($("#select1").val());
		}
		$("#Form").submit();
	}
</script>
</head>
<body>
<center>
	<form method="post" action="bookadd" id="Form">
		<table>
			<tr>
				<td>图书名：</td>
				<td><input type="text" name="Name" id="Name"></td>
			</tr>
			<tr>
				<td>出版社：</td>
				<td><input type="text" name="bPress" id="bPress"></td>
			</tr>
			<tr>
				<td>作者名：</td>
				<td><input type="text" name="bAuthor" id="bAuthor"></td>
			</tr>
			<tr>
				<td>价格：</td>
				<td><input type="text" name="bValue" id="bValue"></td>
			</tr>
			<tr>
				<td>图书类型</td>
				<td><select id="select1">
					<option></option>
					<c:forEach items="${varlist}" var="var">
						<option value="${var.bookKindsNo}">${var.bookKindsName}</option>
					</c:forEach>
				</select>
				<input type="hidden" name="BookKindsNo" id="BookKindsNo"></td>
			</tr>
			<tr>
				<td><input type="button" name="submitb" onclick="save()" value="提交"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>