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
	QUICK BUTTONS:
	</td>
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
	<form action="pickrandomByParam.do" method="post">
		<input type="submit" value="Pick a Random Restaurant By Param!">
	</form>
	</td>
	<td>
	<form action="addrest.do" method="post" name="restNums">
		<input type="submit" value="Quick Add!">
	</form>
	</td>
	</tr>
</div>
<h1>Add Restaurant:</h1>

<c:forEach var="num" items="${RestNumber }">
<form action="addresttodata.do">
Title:<input type="text" name="title">
Description:<input type="text" name="title">
Price:<input type="text" name="title">
Category:<input type="text" name="title">
Distance:<input type="text" name="title" value=>
Address:<input type="text" name="title" value="PLACEHOLDER">
Logo(Url):<input type="text" name="title" placeholder="PLACEHOLDER">
Favorite:<input type="text" name="favorite" value=0>
<input type="hidden" name="user_id" value=0>
</form>
</c:forEach>

</body>
</html>