<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer Form</title>
</head>
<body>
	<h2>Bank</h2>
	<div id="container">
		<h3>Add Customer</h3>

	 <form:form action="addcustomer" modelAttribute="customer">
		<form:hidden path="id"/>
FirstName<form:input path="firstName" />
			<br />
LastName<form:input path="lastName" />
			<br />
Email<form:input path="email" />
			<br />
			<input type="submit" value="save" />
			<br/>
		</form:form> 
		<div style="clear;both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/list">Back to List</a>
		</p>
	</div>
</body>
</html>