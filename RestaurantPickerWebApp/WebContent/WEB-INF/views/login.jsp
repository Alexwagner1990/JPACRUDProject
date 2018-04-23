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
<title>Restaurant Picker!</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/MyCss.css">
</head>
<body>
<div class="jumbotron text-center">
  <h1>WELCOME TO RESTAURANT PICKER</h1>      
  <p>Want to go out to eat tonight, but not sure where to go? Let Restaurant Picker help!</p>
  <p>Give us some restaurants to choose from, and we'll pick a restaurant for you!</p>
</div>
<div class="container-fluid">
<div class="row">
<div class="col-sm-2 well"></div>
<div class="col-sm-8 text-center">
<form action="loginAsUser.do" method="post">
<input type="text" name="login[]" placeholder="User Name" required/>
<input type="password" name="login[]" placeholder="Password" required/>
<input type="submit" class="btn btn-primary btn-block" value="LOG IN"/>
</form>
<c:if test="${login == 1 }">
<p>Login Unsuccessful, check credentials!</p>
</c:if>
<br>
<form action="createAccount.do" method="post">
<input type="text" name="create[]" placeholder="Choose a User Name" required/>
<input type="password" name="create[]" placeholder="Choose a Password" required/>
<input type="submit" class="btn btn-primary btn-block" value="CREATE ACCOUNT"/>
</form>
<c:if test="${created == 0 }">
<p>That username is taken, try another!</p>
</c:if>
<c:if test="${created == 1}">
<p>User successfully created!</p>
</c:if>
<br>
<form action="changeAccount.do" method="post">
<input type="text" name="change[]" placeholder="User Name" required/>
<input type="password" name="change[]" placeholder="Old Password" required/>
<input type="password" name="change[]" placeholder="New Password" required/>
<input type="submit" class="btn btn-primary btn-block" value="CHANGE PASSWORD"/>
</form>
<c:if test="${change == 1 }">
<p>Password Updated!</p>
</c:if>
<c:if test="${change == 2 }">
<p>Incorrect Password, try again</p>
</c:if>
<br>
<form action="deleteAccount.do" method="post">
<input type="text" name="delete[]" placeholder="User Name" required/>
<input type="password" name="delete[]" placeholder="Password" required/>
<input type="submit" class="btn btn-primary btn-block" value="DELETE ACCOUNT"/>
</form>
<c:if test="${delete == 1 }">
<p>Delete Successful!</p>
</c:if>
<c:if test="${delete == 2 }">
<p>Delete Not Successful, check credentials and try again</p>
</c:if>
<div class="col-sm-2 well"></div>
</div>
</div><!-- END OF BODY ROW -->
</div><!--  END OF CONTAINER FLUID -->











<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>