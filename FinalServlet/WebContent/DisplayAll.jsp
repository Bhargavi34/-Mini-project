<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList,com.model.Registration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp"><h1 style="text-align:right">Logout</a>

<%
ArrayList<Registration> x = (ArrayList) session.getAttribute("display");



if(x!=null){
	
	%><center></center><table bgcolor="#FFDAB9" frame="box"><tr bgcolor="#DC143C"> <th>Registration no</th><th>Username</th><th>Password</th></tr><%

for(int i = 0; i<x.size(); i++)
{
	Registration r = x.get(i);
	%><tr><%
	%><td><%out.print(r.getRegno());%></td><%
	%><td><%out.print(r.getUser());%></td><%
	%><td><%out.print(r.getPass());%></td><%

	
	%></td></tr><%
}
}
%></table></center><%
%>

</body>
</html>