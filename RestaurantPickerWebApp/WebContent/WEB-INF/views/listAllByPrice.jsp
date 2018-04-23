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
<title>List Restaurants by Price</title>
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
	<form action="quickadd.do" method="post" >
		<input type="submit" value="Quick Add!">
	</form>
	</td>
	</tr>
	</table>
</div>
</div>
</div> <!-- END OF NAVBAR -->
</div> <!-- END OF NAVBAR CONTAINER -->
<div class="jumbotron text-center">
  <h1>RESTAURANTS BY PRICE</h1>      
  <p>List all Restaurants by a Price</p>
</div>
<div class="container-fluid text-center">
<div class="row">
<div class="col-sm-4"></div>
<div class="col-sm-4">
<form action="findPrice.do" method="post">
Enter a Price:<select name="price">
<option value="NONE">N/A</option>
<option value="CHEAP">Cheap</option>
<option value="AVERAGE">Average</option>
<option value="PRICEY">Pricey</option>
</select>
<input type="submit" value="Find Restaurants">
</form>
</div>
<div class="col-sm-4"></div>
</div>

<c:if test="${not empty restList }">
<div class="row">
<div class="col-4-sm"></div>
<div class="col-4-sm">
<form action="randomPrice.do" method="post">
<input type="hidden" name="choice" value="${choice}"/><input type="submit" value="Pick a Random Restaurant From List!"/>
</form>
<table class="table table-striped">
<thead>
<tr>
<th>Name</th><th>Category</th><th>Price</th><th>Address</th><th>Website</th>
</tr>
</thead>
<tbody>
<c:forEach var="rest" items="${restList}">
<tr>
<td>${rest.name }</td>	<td>${rest.category }</td> <td>${rest.price }</td> <td>${rest.address }</td> <td>${rest.logo }</td> 
<td><form action="updatePage.do" method="post"><input type="hidden" name="id" value="${rest.id}"/><input type="submit" value="UPDATE THIS RESTAURANT"></form></td>
<td><form action="delete.do" method="post"><input type="hidden" name="id" value="${rest.id}"/><input type="submit" value="DELETE THIS RESTAURANT"></form></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<div class="col-4-sm"></div>
</div>
</c:if>


</div>










<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>