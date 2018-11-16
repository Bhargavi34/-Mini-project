<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">

<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.4.2/css/all.css' integrity='sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns' crossorigin='anonymous'>

  <link rel="stylesheet" href="registration.css">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<style>


img {
    border-radius: 50%;
  margin-left: auto;
    margin-right: auto;
}

 


</style>
 



</head>
<body style="background-color:lightyellow;">
<form action="RegistrationServlet">




<div  class="container border border-dark w-50 p-3" style="background-color:lightblue;">



  <div class="row">
    <div class="col-sm">
      <label for="reg">Registration Number :</label>
    </div>
    <div class="col-sm">
      <input  name="reg" type="number" min=100000 max=599999 size="20" required>
    </div>
   
  </div>


<div class="row">
    <div class="col-sm">
      <label for="u"> <i class='fas fa-user'></i> Username: </label>
    </div>
    <div class="col-sm">  
      <input name="user" type="text"  value=""  size="20" required>
    </div>
   
  </div>


<div class="row">
    <div class="col-sm">
      <label for="reg"><i class='fas fa-key'></i> Password :</label>
    </div>
    <div class="col-sm">
      <input name="pass" type="password" value="" size="20" required>
    </div>
   
  </div>

<div class="row">
    <div class="col-sm">
      <label for="reg"><i class='fa fa-neuter'></i>Gender:</label>
    </div>
    <div class="col-sm">
      <input type="radio" name="Gender" value="Male" >Male </input> 
            <input type="radio" name="Gender" value="Female">Female </input> 
      
    </div>
   
  </div>
<div class="row">
    <div class="col-sm">
      <label for="reg"><i class='fa fa-birthday-cake'></i>Date Of Birth:</label>
    </div>
    <div class="col-sm">
      <input type="date" name="bday" value="1990-01-01" size="20" required>
    </div>
   
  </div>
   <div class="row">
    <div class="col-sm">
      <label for="reg"><i class='fa fa-industry'></i>City:</label>
    </div>
    <div class="col-sm">
      <select>
  <option value="Select">Select</option>
  <option value="Mumbai">Mumbai</option>
  <option value="Delhi">Delhi</option>
  <option value="Shimla">Shimla</option>
</select>
    </div>
   
  </div>
   
<div class="row">
    <div class="col-sm">
      <label for="reg"> </span> <span class="glyphicon glyphicon-envelope"></span> Email :</label>
    </div>
    <div class="col-sm">
      <input type="email" name="email" size="20" required>
    </div>
   
  </div>

<div class="row">
    <div class="col-sm">
      <label for="reg"><i class='fa fa-phone'></i> Phone :</label>
    </div>
    <div class="col-sm">
      <input name="phone" pattern="[789][0-9]{9}" type="text" value=""  size="20" required>
    </div>
   
  </div>

<div class="row w-100 p-3" >
<input style="width:80%;  margin-left: auto; margin-right: auto;" type="submit"  class = "btn btn-primary btn-lg" value="Submit"> 
  </div>
  
</div>








</body>
</html>

