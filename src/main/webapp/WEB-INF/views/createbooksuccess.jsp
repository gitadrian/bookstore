<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

	New book successfully created.<br><br>
	ID: ${createdbook.book_id} <br><br>
	Title: ${createdbook.title} <br><br>
	Year: ${createdbook.year} <br><br>
	Publisher: ${createdbook.publisher} <br><br>
	Price: ${createdbook.price} <br><br>
	Quantity: ${createdbook.quantity} <br><br>
	Category: ${createdbook.category_Id.name} <br><br>
	
	<a href="${pageContext.request.contextPath}">Home</a> | <a href="createbook">Create new book</a>
	
</body>
</html>