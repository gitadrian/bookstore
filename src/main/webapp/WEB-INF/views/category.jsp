<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css"></c:url>" rel="stylesheet" />
	<link href="<c:url value="/resources/css/bootstrap-theme.min.css"></c:url>" rel="stylesheet" />
	<script src="<c:url value="/resources/js/bootstrap.min.js"></c:url>"></script>
	<script src="<c:url value="/resources/js/jquery-1.11.3.js"></c:url>"></script>
</head>
<body>

<nav class="navbar navbar-default navbar-static-top">
  		<div class="container">
   		 <a href="${pageContext.request.contextPath}"><h1>Bookstore</h1></a>
  		</div>
	</nav>

	<div class="row">
  		<div class="col-md-4">
  		
  			<h2>Categories</h2>
  			<ul>
  				<c:forEach items="${categories}" var="categories">
					<li><a href="${pageContext.request.contextPath}/category/${categories.name}">${categories.name}</a></li>
			
				</c:forEach> 
  				
			</ul>
  		
  		</div>
  		<div class="col-md-8">
  
  
  		
		<c:forEach items="${books}" var="books">
			${books.title} <br>
			Year: ${books.year}<br>
			Description: ${books.description}<br>
			Category: ${books.category_Id.name}<br>
			Price: $ ${books.price}<br>
			<a href="${pageContext.request.contextPath}/addtocart?id=${books.book_id}">Add to cart</a><br><br>
		</c:forEach> 
		
		
  		</div>
  
	</div>




</body>
</html>