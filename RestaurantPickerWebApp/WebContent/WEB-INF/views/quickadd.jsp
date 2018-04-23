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
		<td>
	<form action="pickfavorite.do" method="post">
		<input type="submit" value="Pick a Favorite!"/>
	</form>
	</td>
		<td>
	<form action="loginPage.do" method="get" >
		<input type="submit" value="Logout">
	</form>
	</td>
	</tr>
	</table>
</div>
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-10 text-center">
<h1>Add Restaurant:</h1>

<form action="addrest.do" method="post">
<table>
<tr><td>Name:</td><td><input type="text" name="name" placeholder="Restaurant Name" required></td></tr>
<tr><td>Price:</td><td><select name="price">
<option value="NONE">N/A</option>
<option value="CHEAP">Cheap</option>
<option value="AVERAGE">Average</option>
<option value="PRICEY">Pricey</option></select></td></tr>
<tr><td>Category:</td><td><input type="text" name="category" value=" " placeholder="Category"></td></tr>
<tr><td>Distance:</td><td><select name="distance">
<option value="NONE">N/A</option>
<option value="CLOSE">Close</option>
<option value="AVERAGE">Average</option>
<option value="FAR">Far</option></select></td></tr>
<tr><td>Address:</td><td><input type="text" name="address" value=" " placeholder="Address"></td></tr>
<tr><td>Website:</td><td><input type="text" name="logo" value=" " placeholder="Address"></td></tr>
<tr><td>Favorite:</td><td><select name="favorite">
<option value="0">Unfavorite</option>
<option value="1">Favorite</option></select></td></tr>
</table>
<input type="hidden" name="userId" value="0"/>
<input type="hidden" name="id" value="0"/>
<input type="submit" value="ADD RESTAURANT"/>
</form>

</div>
<div class="col-sm-1"></div>

</div><!-- END OF ROW -->
</div><!-- END OF CONTAINER -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>