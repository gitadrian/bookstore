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
	<h1>Books</h1>
	<c:forEach items="${books}" var="books">
			${books.title} <br>
			Year: ${books.year}<br>
			Description: ${books.description}<br>
			Category: ${books.category_Id.name}<br>
			Price: $ ${books.price}<br>
			<a href="${pageContext.request.contextPath}/addtocart?id=${books.book_id}">Add to cart</a><br><br>


		</c:forEach> 
		
		<br><br><a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>
</body>
</html>