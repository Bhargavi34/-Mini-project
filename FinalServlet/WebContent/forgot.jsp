<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {background-color: powderblue;}
    h1 {color: red;}    
    h2 {color: blue;}
  </style>
</head>
<body>

<form action="Forgot" method="post">
<h1><center>Enter your email-id to reset a new password</center></h1><br>
<h2><center>Enter Userid:<input type="text" name="user"></center></h2><br>
<h2><center>New Password:<input type="password" name="pass"></center></h2><br>
<h2><center>Confirm New password:<input type="password" name="cpass"></center></h2><br>



<center><input type="submit" value="Submit"></center>
</form>


</body>
</html>