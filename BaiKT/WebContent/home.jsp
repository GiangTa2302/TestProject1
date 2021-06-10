<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="emps" class="java.util.ArrayList" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sach cac nhan vien</title>
<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
table {
  border-collapse: collapse;
  width: 100%;
}
#customers td, #customers th {
  border: 1px solid #140908;
  padding: 8px;
}

tr, td{
	border: 1px solid #140908;
}

button{
	cursor:pointer;
}


#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
<table>
	<tr><th>
	<h1>Danh sách nhân viên</h1>
	</th></tr>
	<tr><th>
	<form action="position" method="post" name="homeForm">
	<button type="submit" style="float:right; margin-bottom:10px" >Thêm</button>
	<table id="customers">
		<thead >
			<tr>
				<th>Mã nhân viên</th>
				<th>Tên nhân viên</th>
				<th>Ngày sinh</th>
				<th>Chức vụ</th>
				<th>Thao tác</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${emps}" >
				<tr>
					<td>${emp.emp_code}</td>
					<td>${emp.name}</td>
					<td>${emp.birthday}</td>
					<td>${emp.stastus}</td>
					<td><a href="edit?id=${emp.id}"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16"><path fill-rule="evenodd" d="M11.013 1.427a1.75 1.75 0 012.474 0l1.086 1.086a1.75 1.75 0 010 2.474l-8.61 8.61c-.21.21-.47.364-.756.445l-3.251.93a.75.75 0 01-.927-.928l.929-3.25a1.75 1.75 0 01.445-.758l8.61-8.61zm1.414 1.06a.25.25 0 00-.354 0L10.811 3.75l1.439 1.44 1.263-1.263a.25.25 0 000-.354l-1.086-1.086zM11.189 6.25L9.75 4.81l-6.286 6.287a.25.25 0 00-.064.108l-.558 1.953 1.953-.558a.249.249 0 00.108-.064l6.286-6.286z"></path></svg></a>&ensp;
					<a href="#" onclick="showMess(${emp.id})"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16"><path fill-rule="evenodd" d="M6.5 1.75a.25.25 0 01.25-.25h2.5a.25.25 0 01.25.25V3h-3V1.75zm4.5 0V3h2.25a.75.75 0 010 1.5H2.75a.75.75 0 010-1.5H5V1.75C5 .784 5.784 0 6.75 0h2.5C10.216 0 11 .784 11 1.75zM4.496 6.675a.75.75 0 10-1.492.15l.66 6.6A1.75 1.75 0 005.405 15h5.19c.9 0 1.652-.681 1.741-1.576l.66-6.6a.75.75 0 00-1.492-.149l-.66 6.6a.25.25 0 01-.249.225h-5.19a.25.25 0 01-.249-.225l-.66-6.6z"></path></svg></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
	</th></tr>
</table>
	<script>
		function showMess(id){
			var option = confirm('Bạn có muốn xóa?');
			if(option === true){
				window.location.href = 'delete?id='+id;
			}
		}
	</script>
</body>
</html>