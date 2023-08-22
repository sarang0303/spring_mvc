<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<table border="2px solid">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>phone</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<c:forEach var="employee" items="${list}">
			<tr>
				<td>${employee.getId() }</td>
				<td>${employee.getName() }</td>
				<td>${employee.getPhone() }</td>
				<td>${employee.getEmail() }</td>
				<td>${employee.getPassword() }</td>
				<td><a href="delete?id=${employee.getId() }"><button>DELETE</button></a></td>
				<td><a href="update?id=${employee.getId() }"><button>UPDATE</button></a></td>

			</tr>
		</c:forEach>

	</table>
</body>
</html>