<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList,com.model.Registration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {background-color: powderblue;}
    h1 {color: red;}    
    p {color: blue;}
  </style>
</head>
<body>
<center><h1> Hello  <% String uname= (String) session.getAttribute("userName");
  out.println(uname+"  Vote for your Hobbie"); 

%> </h1></center><br>
 
<br><a href="index.jsp"><h1 style="text-align:right">Logout</a><br>
<center><form action="DisplayServlet"><input type="submit" value="Display"></form></center><br>
<center><form action="SearchServlet"><input type="text" name="user" placeholder="Enter the name"><input type="submit" value="Search"></form></center><br>


<form action="InsertServlet">
<center><p><input type="radio" name="Hobbies" value="You voted for singing" >Singing</center></p><br> 
<center><p><input type="radio" name="Hobbies" value="You voted for cricket" >Cricket</center></p><br>  
<center><p><input type="radio" name="Hobbies" value="You voted for dancing" >Dancing </center></p><br>
<center><p><input type="radio" name="Hobbies" value="You voted for football" >Football </center></p><br>
<center><p><input type="submit" value="Vote">  <br>
</form>

<%
ArrayList<Registration> x = (ArrayList) session.getAttribute("display");



if(x!=null){
	
	%><table  frame="box"><tr > <th>Registration no</th><th>Username</th><th>Password</th></tr><tr><%

for(int i = 0; i<x.size(); i++)
{
	Registration r = x.get(i);
	
	out.println(r.getRegno()+" "+r.getUser()+" "+r.getPass());%></tr></table><%
}
}
%>





	

</body>
</html>