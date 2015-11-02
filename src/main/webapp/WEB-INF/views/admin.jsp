<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<thead>
		<tr><th>id</th>
			<th>Title</th>
			<th>Year</th>
			<th>Publisher</th>
			<th>Category</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Description</th>
			<th>Actions</th>
		</tr>
	</thead>
	<c:forEach items="${books}" var="books">
			<tr>
				<td>${books.book_id}</td>
				<td>${books.title}</td>
				<td>${books.year}</td>
				<td>${books.publisher}</td>
				<td>${books.category_Id.name}</td>
				<td>${books.price}</td>
				<td>${books.quantity}</td>
				<td>${books.description}</td>
				<td><a href="${pageContext.request.contextPath}/edit/${books.book_id}">Edit</a> | <a href="${pageContext.request.contextPath}/delete/${books.book_id}">Delete</a></td>
			</tr>


		</c:forEach> 
</table>


</body>
</html>