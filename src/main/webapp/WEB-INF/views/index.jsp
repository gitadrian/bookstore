<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<title>Insert title here</title>
	
	<link href="<c:url value="resources/css/bootstrap.min.css"></c:url>" rel="stylesheet" />
	<link href="<c:url value="resources/css/bootstrap-theme.min.css"></c:url>" rel="stylesheet" />
	<script src="<c:url value="resources/js/bootstrap.min.js"></c:url>"></script>
	<script src="<c:url value="resources/js/jquery-1.11.3.js"></c:url>"></script>
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
  
  
  		<h1>Books</h1>
		<c:forEach items="${books}" var="books">
			${books.title} <br>
			Price: $ ${books.price}<br>
			<a href="${pageContext.request.contextPath}/bookdetails/${books.book_id}">View Details</a><br><br>
		</c:forEach> 
		
		<br><br><a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>
  		</div>
  
	</div>

	
</body>
</html>