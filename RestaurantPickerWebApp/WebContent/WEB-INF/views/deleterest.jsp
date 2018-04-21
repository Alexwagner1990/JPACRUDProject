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
<title>Delete Restaurant</title>
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
<c:if test="${deleted }">
<h1>Restaurant Deleted!</h1>
</c:if>
<c:if test="${!deleted }">
<h1>Restaurant didn't get deleted, something went wrong, sorry!</h1>
</c:if>

</div>
</body>
</html>