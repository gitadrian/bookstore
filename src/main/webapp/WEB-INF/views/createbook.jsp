<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="resources/css/bootstrap-theme.min.css" rel="stylesheet" />
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/jquery-1.11.3.js"></script>
</head>
<body>
	<h1>Create new book</h1>

	<form:form commandName="books" method="POST" action="createbookaction">
		Title: <form:input path="title" />
		<br>
		<br>
		Year: <form:input path="year" />
		<br>
		<br>
		Publisher: <form:input path="publisher" />
		<br>
		<br>
		Price: <form:input path="price" />
		<br>
		<br>
		Quantity: <form:input path="quantity" />
		<br>
		<br>
		Category: <form:select path="category_Id" items="${categories}"
			itemLabel="name" itemValue="categoryId">
		</form:select>
		<br>
		<br>
		Description: <form:textarea path="description" />
		<br>
		<br>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>








</body>
</html>