package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Jdbc;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter  out=response.getWriter();//for printing on the servlet
		String user=null;//initialise to null value
		try {
		 user=request.getParameter("user");//getting the parameter
		 if(user=="")
			 throw new NullPointerException();//if user didn't enter anything but clicked on display
		} catch (Exception p) {
			RequestDispatcher rd = request.getRequestDispatcher("exception.jsp");//getting an exception 
			request.setAttribute("errm", p);// send exception 
			rd.forward(request, response); //forward the response
		
			p.printStackTrace();
		}
		out.println("<a href=\"index.jsp\"><h1 style=\"text-align:right\">Logout</a>");

		out.println("<body bgcolor='#E6E6FA'>");
		out.print("<center><h1> Display the record</h1></center>");//printing the table
		
		out.print("<center><table border='1'><tr bgcolor=\"#DC143C\"><th>Regno</th><th>Username</th><th>Password</th></tr>");
		try
		{
			Jdbc jd  = new Jdbc();//instatntiation of class jdbc
			Connection con = jd.myConnection();//creation of connection
			Statement st=con.createStatement();//create statement
			
			System.out.println(user+" inside search servlet");
			
			ResultSet rs=st.executeQuery("select * from reg");//selct query from reg table
			while(rs.next())
			{
				if(user.equals(rs.getString(2))) { //searching through username id
				out.print("<tr><td>");
				out.println(rs.getInt(1));//print the regno
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(2));//print the username
				out.print("</td>");

				out.print("<td>");
				out.println(rs.getString(3));//print the password
				out.print("</td>");
				
				out.print("</td></tr>");
				}
				
			}
		}
catch(Exception p)
{
System.out.println(p);	
}
		out.print("</table></center>");
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
