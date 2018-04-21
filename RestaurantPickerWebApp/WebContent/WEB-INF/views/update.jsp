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
<title>Update Restaurant</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
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
<div>
<h1>UPDATE RESTAURANT</h1>
<form action="update.do" name="restaurant" method="post">
<input type="hidden" name="id" value="${restaurant.id}">
<input type="hidden" name="userId" value="${restaurant.userId}">
<table>
<tr><td>Name:</td><td>${restaurant.name }</td><td><input type="text" name="name" placeholder="New Name"/></td></tr>
<tr><td>Price:</td><td>${restaurant.price }</td><td><input type="text" name="price" placeholder="New Price"/></td></tr>
<tr><td>Category:</td><td>${restaurant.category }</td><td><input type="text" name="category" placeholder="New Category"/></td></tr>
<tr><td>Distance:</td><td>${restaurant.distance }</td><td><input type="text" name="distance" placeholder="New Distance"/></td></tr>
<tr><td>Address:</td><td>${restaurant.address }</td><td><input type="text" name="address" placeholder="New Address"/></td></tr>
<tr><td>Favorite:</td><td>${restaurant.favorite }</td><td><input type="number" name="favorite" placeholder="New Favorite"/></td></tr>
<tr><td>Logo URL:</td><td>${restaurant.logo }</td><td><input type="text" name="logo" placeholder="Logo URL"/></td></tr>
</table>
<input type="submit" value="MAKE SELECTED CHANGES">
</form>

</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>