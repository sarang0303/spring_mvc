<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Edit</h2>
<form:form action="edit" modelAttribute="employee">
ID:<form:input path="id" readonly="true"/>
Name:<form:input path="name"/>
phone:<form:input path="phone"/>
email:<form:input path="email"/>
password:<form:input path="password"/>
<input type="submit">
</form:form>


</body>
</html>