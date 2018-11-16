package com.controller;
import com.model.*;
import com.dao.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");//getting the requested parameter
		
		System.out.println("in login servlet");
		System.out.println(user+" "+pass);
		
		Login l = new Login();//creation of object of type login
		l.setUsername(user);
		l.setPassword(pass);//setting the values of parameters
		
		List<Login> lst = new ArrayList<>();//instantiating the arraylist
		lst.add(l);//adding to the list
		
		HttpSession ses = request.getSession();//creating the new session
		ses.setAttribute("userName", l.getUsername());//send to the session
		ses.setAttribute("err", "Please enter valid credentials"); 

		
		Jdbc x = new Jdbc();
		if(x.searchRecord(lst)) { //Search for data
			
			
			response.sendRedirect("Welcome.jsp");//send to welcome.jsp
		}
		else {
			response.sendRedirect("Login.jsp");//if no data then redirect to login.jsp
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}