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
<title>Pick A Restaurant!</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/MyCss.css">
</head>
<body>
<div class="container-fluid">
<div class="row">
<div class="col-sm-4">
<div class="topnav">
	<table>
	<tr>
	<td>
		<form action="index.do" method="post">
		<input type="submit" value="Home">
		</form>
	</td>
	<td>
	<form action="pickrandom.do" method="post">
		<c:if test="${not empty user }"><input type="hidden" name="user" value="${user.id }"></c:if>
 		<input type="submit" value="Quick Pick!">
	</form>
	</td>
	<td>
	<form action="pickfavorite.do" method="post">
		<c:if test="${not empty user }"><input type="hidden" name="user" value="${user.id }"></c:if>
 		<input type="submit" value="Pick a Favorite!"/>
	</form>
	</td>
	<td>
	<form action="quickadd.do" method="post" >
		<c:if test="${not empty user }"><input type="hidden" name="user" value="${user.id }"></c:if>
		<input type="submit" value="Quick Add!">
	</form>
	</td>
	<td>
	<form action="logout.do" method="post" >
		<input type="submit" value="Logout">
	</form>
<!-- 	</td>
	<td>
	<form action="refresh.do" method="post" >
		<input type="submit" value="Refresh">
	</form>
	</td> -->
	</tr>
	</table>
</div>
</div>
</div> <!-- END OF NAVBAR -->
</div> <!-- END OF NAVBAR CONTAINER -->
<div class="jumbotron text-center">
  <h1>RESTAURANT PICKER</h1>      
  <p>User currently logged in: <c:if test="${not empty user }">${sessionScope.user.username }</c:if>
  <c:if test="${empty user }">N/A - logout and log back in, apologies for inconvenience</c:if></p>
  
</div>
<div class="container-fluid">
<div class="row">
<div class="col-sm-2 well"></div>
<div class="col-sm-8 text-center">
<img src="images/food.jpeg" class="img-rounded img-responsive" alt="Food">
<div class="page-header"><h2>Search for a Restaurant You've Added</h2></div>
<table>
<tr>
	<td>
	<form action="findrest.do" method="post">
	<c:if test="${not empty user }"><input type="hidden" name="user" value="${user.id }"></c:if>
		<input type="text" name="searchTerm" placeholder="Name of Restaurant">
		<input type="submit" value="Find a Restaurant!">
	</form>
	</td>
</tr>
</table>
<div class="page-header"><h2>List/Pick Restaurants of a Type</h2></div>
<table>
<tr>
	<td>
	<form action="findrestList.do" method="post">
		<select name="type">
		<option value="cat">Category</option>
		<option value="distance">Distance</option>
		<option value="price">Price</option>
		</select>
		<c:if test="${not empty user }"><input type="hidden" name="user" value="${user.id }"></c:if>
		<input type="submit" value="List Restaurants">
	</form>
	</td>
</tr>
</table>
<div class="page-header"><h2>Add More Than One Restaurant At a Time</h2>
</div>
<table>
<tr>
	<td>
	<form action="addrestPage.do" method="post">
		<input type="number" name="restNums" placeholder="# of Restaurants to Add" required>
		<c:if test="${not empty user }"><input type="hidden" name="user" value="${user.id }"></c:if>
		<input type="submit" value="Add Multiple">
	</form>
	</td>
	</tr>
</table>
<div class="page-header"><h2>Your Restaurants:</h2></div>
</div>
<div class="row">
<div class="col-sm-12">
<c:if test="${empty fullList }">
<h3>You don't have any Restaurants! Add some Restaurants!</h3>
</c:if>
<c:if test="${not empty fullList }">
<table class="table table-striped">
<thead>
<tr>
<th>Name</th><th>Category</th><th>Favorite</th>
</tr>
</thead>
<tbody>
<c:forEach var="rest" items="${fullList}">
<tr>
<td>${rest.name }</td>	<td>${rest.category }</td> <td><c:if test="${rest.favorite == 1 }"><img class="favorite" alt="Yes" src="images/checkmark.jpg"></c:if>
<c:if test="${rest.favorite == 0 }"><img class="favorite" alt="No" src="images/xmark.jpg"></c:if></td> 
<td><form action="updatePage.do" method="post"><c:if test="${not empty user }"><input type="hidden" name="user" value="${user.id }"></c:if><input type="hidden" name="id" value="${rest.id}"/><input type="submit" value="UPDATE THIS RESTAURANT"/></form></td>
<td><form action="delete.do" method="post"><c:if test="${not empty user }"><input type="hidden" name="user" value="${user.id }"></c:if><input type="hidden" name="id" value="${rest.id}"/><input type="submit" value="DELETE THIS RESTAURANT"/></form></td>
</tr>
</c:forEach>
</tbody>
</table>
</c:if>
</div>
</div>


<div class="col-sm-2 well"></div>





</div><!-- END OF BODY ROW -->
</div><!--  END OF CONTAINER FLUID -->











<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>