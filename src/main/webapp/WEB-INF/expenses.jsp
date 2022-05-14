<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JAVA</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div  class="btn-btn" class="continer">
		<h1>Hello</h1>
		<table>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="expense" items="${expenses}">
				<tr>
					<td><a href="/expense/${expense.id}/show"><c:out value="${expense.name}"></c:out></a></td>
					<td><c:out value="${expense.vendor}"></c:out></td>
					<td><c:out value="${expense.amount}"></c:out></td>
					<td><a href="/expense/${expense.id}/edit">edit</a></td>
					<td><form action="/expense/${expense.id}" method="post">
							<input type="hidden" name="_method" value="delete"> <input
								type="submit" value="Delete">
						</form></td>
				</tr>
			</c:forEach>
		</table>


		<hr />
		<form:form action="/expense" method="post" modelAttribute="expense">
			<p>
				<form:label path="name">Expense Name</form:label>
				<form:errors path="name" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="vendor">Vendor</form:label>
				<form:errors path="vendor" />
				<form:input path="vendor" />
			</p>
			<p>
				<form:label path="amount">Amount</form:label>
				<form:errors path="amount" />
				<form:input type="number" path="amount" />
			</p>
			<p>
				<form:label path="description">Description</form:label>
				<form:errors path="description" />
				<form:textarea path="description" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>