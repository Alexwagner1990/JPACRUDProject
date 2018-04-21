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
<h1>Add Restaurant:</h1>

<form action="addrest.do" method="post">
<table>
<tr><td>Name:</td><td><input type="text" name="name" value=" " placeholder="Restaurant Name"></td></tr>
<tr><td>Price:</td><td><input type="text" name="price" value=" " placeholder="CHEAP, AVERAGE, PRICEY, or NONE"></td></tr>
<tr><td>Category:</td><td><input type="text" name="category" value=" " placeholder="Category"></td></tr>
<tr><td>Distance:</td><td><input type="text" name="distance" value=" " placeholder="CLOSE, AVERAGE, FAR, or NONE"></td></tr>
<tr><td>Address:</td><td><input type="text" name="address" value=" " placeholder="Address"></td></tr>
<tr><td>Logo(Url):</td><td><input type="text" name="logo" value=" " placeholder="Address"></td></tr>
<tr><td>Favorite:</td><td><input type="number" name="favorite" value="0" placeholder="1 to mark favorite, 0 to not"></td></tr>
</table>
<input type="hidden" name="userId" value="0"/>
<input type="hidden" name="id" value="0"/>
<input type="submit" value="ADD RESTAURANT"/>
</form>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>