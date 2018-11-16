package com.controller;
import java.sql.*;
import com.dao.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Jdbc;

/**
 * Servlet implementation class Forgot
 */
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try
{
	Jdbc jd  = new Jdbc(); //creation of object of class jdbc
	Connection con = jd.myConnection(); //creating the connection
	
	String user=request.getParameter("user"); 
	String pass=request.getParameter("pass");//Returns the value of requested parameter
	PreparedStatement ps=con.prepareStatement("Update reg set password=? where userid=?");//Prepared statement for executing the SQL query
	ps.setString(2,user);//getting the value of second parameter
	ps.setString(1,pass);//getting the value of first parameter
	int i=ps.executeUpdate();//execute query 
	if(i>0)
	{
		response.sendRedirect("update.jsp");//sending response to update jsp page
		
	}
	else 
	{
		response.sendRedirect("error.jsp");
	}
}
catch(Exception e)
{
e.printStackTrace();//print exception stacktrace

	
}
		
		
		
		
		
		doGet(request, response);
	}

}
