<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customers List</title>
</head>
<body>
	<h1>Customers</h1>
	<div id="container">
	<div id="content">
	<input type="button" value="Add Customer" 
	onclick="window.location.href='showFormForAdd';return false;">
	<form action="list">
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
		</tr>

		<c:forEach var="temp" items="${customer}">
			
			<c:url var="updatelink" value="/showFormForUpdate">
			<c:param name="customerId" value="${temp.id}"/>
			</c:url>
			
			<c:url var="deletelink" value="/delete">
			<c:param name="customerId" value="${temp.id}"/>
			</c:url>
			
			<tr>
				<td>${temp.firstName}</td>
				<td>${temp.lastName}</td>
				<td>${temp.email}</td>
				<td>
				<a href="${updatelink}">Update</a>
				|
				<a href="${deletelink}" 
				         onclick="if(!(confirm('Are you sure want to delete?'))) return false">Delete<a></a>
				</td>
			</tr>

		</c:forEach>
	</table>
	</form>
	</div>
	</div>
</body>
</html>