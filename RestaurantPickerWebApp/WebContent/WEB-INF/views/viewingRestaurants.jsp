<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Find Restaurant</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/MyCss.css">
</head>
<body>
<div class="container-fluid">
<div class="topnav">
	<table>
	<tr>
	<td>
		<form action="index.do" method="get">
		<input type="submit" value="Home">
		</form>
	</td>
	<td>
	<form action="pickrandom.do" method="post">
		<input type="submit" value="Quick Pick!">
	</form>
	</td>
		<td>
	<form action="pickfavorite.do" method="post">
		<input type="submit" value="Pick a Favorite!"/>
	</form>
	</td>
	<td>
	<form action="quickadd.do" method="post" >
		<input type="submit" value="Quick Add!">
	</form>
	</td>
		<td>
	<form action="logout.do" method="post" >
		<input type="submit" value="Logout">
	</form>
	</td>
	</tr>
	</table>
</div>
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-10 text-center">
<h1>Restaurants Found:</h1>
<%-- <c:forEach var="r" items="searchTerm"> --%>
<c:if test="${not empty searchTerm}">
<table>
<c:forEach var="searchTerm" items="${searchTerm }">
<tr><td>Name:</td><td>${searchTerm.name }</td></tr>
<tr><td>Price:</td><td>${searchTerm.price }</td></tr>
<tr><td>Category:</td><td>${searchTerm.category }</td></tr>
<tr><td>Distance:</td><td>${searchTerm.distance }</td></tr>
<tr><td>Address:</td><td>${searchTerm.address }</td></tr>
<tr><td>Favorite:</td><td>
<c:if test="${searchTerm.favorite == 1 }"><img class="favorite" alt="Yes" src="images/checkmark.jpg"></c:if>
<c:if test="${searchTerm.favorite == 0 }"><img class="favorite" alt="No" src="images/xmark.jpg"></c:if></td></tr>
<tr><td>Website:</td><td>${searchTerm.logo }</td></tr>
<tr><td><form action="updatePage.do" name="" method="post">
<input type="submit" value="UPDATE THIS RESTAURANT"/>
<input type="hidden" name="id" value="${searchTerm.id }"/>
</form></td></tr>
<tr><td><form action="delete.do" name="" method="post">
<input type="submit" value="DELETE THIS RESTAURANT"/>
<input type="hidden" name="id" value="${searchTerm.id }"/>
</form></td></tr>
<tr><td></td></tr>
</c:forEach>
</table>
</c:if>
<c:if test="${empty searchTerm}">
<h1>No Restaurants Found, Check Spelling</h1>
</c:if>
<%-- </c:forEach> --%>

</div>
<div class="col-sm-1"></div>
</div><!-- END OF ROW -->
</div><!-- END OF CONTAINER -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>