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
	</table>
</div>
<div>
<table>
<tr>
	<td>
	More Refined Options:
	</td>
	<td>
	<form action="findrest.do" method="post">
		<input type="text" name="searchTerm" placeholder="Name of Restaurant">
		<input type="submit" value="Find a Restaurant!">
	</form>
	</td>
	<td>
	<form action="findrestList.do" method="post">
		<input type="text" placeholder="Type Of Restaurant">
		<input type="submit" value="List Restraunts Of a Type!">
	</form>
	</td>
	<td>
	<form action="addrest.do" method="post">
		<input type="number" value="">
		<input type="submit" name="restNums" value="Add Multiple Restaurants At Once!">
	</form>
	</td>
	</tr>
</table>
</div>
<h2>Display Test</h2>
<c:forEach var="rest" items="${fullList}">
<ul>
<li>${rest.name }	${rest.category }	${rest.price }</li>
</ul>
</c:forEach>




<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>