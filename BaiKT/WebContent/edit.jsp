<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="pos" class="java.util.ArrayList" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa thông tin</title>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

button{
	cursor:pointer;
}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  color: black;
}
</style>
</head>
<body>
<table style="border: 1px solid #140908;">
	<tr><th>
	<h1 style ="border-bottom: 1px solid #140908;">Thông tin chi tiết nhân viên</h1>
	</th></tr>
	<tr><th>
	<form action="edit" method="post">
	<table id="customers">
	<tr><th>
	<label>ID:</label>
	<input type="text" name="id" value="${emp.id}" readonly><br>
	</th></tr>
	<tr>
	<th>
	<label>Mã nhân viên:</label>
	<input type="text" name="emp_code" value="${emp.emp_code}"><br>
	</th>
	<th>
	<label>Tên nhân viên:</label>
	<input type="text" name="name" value="${emp.name}"><br>
	</th>
	</tr>
	<tr>
	<th>
	<label>Ngày sinh:</label>
	<input type="text" name="birthday" value="${emp.birthday}"><br>
	</th>
	<th>
	<label>Giới tính:</label>
	<input type="radio" name="gender" value="0" ${emp.gender == 0?"checked":""}>
	<label>Nam</label>
	<input type="radio" name="gender" value="1" ${emp.gender == 1?"checked":""}>
	<label>Nữ</label><br>
	</th>
	</tr>
	<tr>
	<th>
	<label>Địa chỉ:</label>
	<input type="text" name="address" value="${emp.address}"><br>
	</th>
	<th>
	<label>Chức vụ:</label>
	<select name="position_id">
		<c:forEach var="pos" items="${pos}" >
			<option value="${pos.id}" ${emp.position_id == pos.id?"selected":""}>${pos.name}</option>
		</c:forEach>
	</select><br>
	</th>
	</tr>
	</table>
	<button type="submit"> Lưu</button>
	<button type="submit" form="homeForm"> Quay lại </button>
	
	
	</form>
	</th></tr>
</table>
</body>
</html>