package com.src.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.model.RegisterClass;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		  String username = request.getParameter("name");
	       
	        String pass = request.getParameter("pass");
	        RegisterClass rc=new RegisterClass();
	        
	        rc.setPassword(pass);
	        rc.setUsername(username);
	        try{
	        
	        //loading drivers for mysql
	        Class.forName("org.h2.Driver");

		//creating connection with the database 
	          Connection  con=DriverManager.getConnection
	                     ("jdbc:h2:~/test","sa","");

	        PreparedStatement ps=con.prepareStatement
	                  ("insert into people(name,password) values(?,?)");

	        ps.setString(1, rc.getUsername());
	        ps.setString(2, rc.getPassword());
	       
	        int i=ps.executeUpdate();
	        
	          if(i>0)
	          {	
	        	  
	        	  RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	        	  rd.forward(request, response);
	          }
	        
	        }
	        catch(Exception se)
	        {
	            se.printStackTrace();
	        }
		
	      
	}

}
