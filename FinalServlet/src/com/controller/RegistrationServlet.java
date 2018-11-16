package com.controller;
import com.model.Registration;
import com.model.Login;
import com.dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int regno = Integer.parseInt(request.getParameter("reg"));/*getting the requested parameters*/
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String Gender=request.getParameter("Gender");
		String bday = request.getParameter("bday");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		PrintWriter out = response.getWriter();//for printing on servlet
		//out.println(user+" "+pass);
		
		Registration r = new Registration();//instantiation of type registration
		r.setRegno(regno);
		r.setUser(user);
		r.setPass(pass);
		r.setGender(Gender);
		r.setBday(bday);
		r.setEmail(email);
		r.setPhone(phone);//setting the values
		
		List<Registration> lst = new ArrayList<>();//instantiation of list 
		lst.add(r);//adding the values
		HttpSession ses = request.getSession();//creating the new session
		ses.setAttribute("registered", "Registered successfully");//send to session
		
		
		Jdbc x = new Jdbc();//instantiation of class jdbc
		int i = x.saveData(lst);
		
		if(i>0)
			response.sendRedirect("Login.jsp");//send to login.jsp
		else
			response.sendRedirect("index.jsp");
		
         		
		
		
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}