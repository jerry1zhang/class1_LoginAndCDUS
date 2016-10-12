<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书列表</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<link href="boots/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="boots/js/bootstrap.js"></script>
<script type="text/javascript">
	function save() {
		if ($("#key").val() == "") {
			$("#selectTop").val("搜索框为空");
			return false;
		}

		$("#Form1").submit();
	}
	function del(id) {
		alert(id);
		$("#bid").val(id);

		$("#DelById").submit();
	}
</script>
</head>
<body>
	<center>
		<h1>图书列表</h1>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>图书编号</th>
					<th>图书名称</th>
					<th>入库时间</th>
					<th>出版社</th>
					<th>作者</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${varlist}" var="var" varStatus="vs">
					<tr>
						<td>${vs.index+1}</td>
						<td>${var.Name}</td>
						<td>${var.bDate}</td>
						<td>${var.bPress}</td>
						<td>${var.bAuthor}</td>
						<td>
							<a href="bookup?bid=${var.Bid}">更新</a>&nbsp;&nbsp;
							<a onclick="del('${var.Bid}');">删除</a>
							<form id="DelById" method="post" action="bookdel">
								<input type="hidden" name="bid" id="bid">
							</form>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td><a href='bookadd'>新增</a></td>
					<form method="post" action="booklist" id="Form1">
						<td colspan="2">书名：<input type="text" name="Name" id="key"></td>
						<td colspan="2"><input type="button" id="Submit"
							onclick="save()" value="搜索"></td>
						<td><p id="selectTop"></p></td>
					</form>
				</tr>
			</tbody>
		</table>
	</center>
</body>
</html>