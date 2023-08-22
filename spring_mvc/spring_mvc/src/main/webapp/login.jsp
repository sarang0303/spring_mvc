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
<h2>lOGIN PAGE</h2>
<form:form action="loginemp" modelAttribute="emp">
email:<form:input path="email"/>
password:<form:input path="password"/>
<input type="submit">
</form:form>

</body>
</html>