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
<ul >

	<li>${books.title}</li>
	<li>${books.year}</li>
	<li>${books.description}</li>
	<li>${books.publisher}</li>
	<li>${books.category_Id.name}</li>
	<li>$${books.price}</li>
	<li><a href="addtocart/${books.book_id}">Add to cart</a></li>

</ul>
	
		
		
		
		
		
		

</body>
</html>