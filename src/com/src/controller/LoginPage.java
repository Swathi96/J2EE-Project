package com.src.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.LoginClass;


@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String userNameDB="";
		String passwordDB="";
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String,String> errors = new HashMap<>();
		try
		{
		   
				
			

			//creating connection with the database 
		Connection  con=DriverManager.getConnection("jdbc:h2:~/test","sa","");
		Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
		ResultSet resultSet = statement.executeQuery("select name,password from people"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
		while(resultSet.next()) // Until next row is present otherwise it return false
		{
		userNameDB = resultSet.getString("name"); //fetch the values present in database
		 passwordDB = resultSet.getString("password");
		if(username.length()<6)
			errors.put("username", "username must be greater than 6 character");
		if(password.length()<6)
			errors.put("password", "password must be greater than 6");
		
		}
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}// Just returning appropriate message otherwise
		
	
		 
	/*	if(username.length()<6)
			errors.put("username", "username must be greater than 6 character");
		else{
			
			
		}
		
		if(password.length()<6)
			errors.put("password", "password must be greater than 6");
		else{
			
			
		}*/
		if(errors.isEmpty()&&(username.equals(userNameDB) && password.equals(passwordDB))){
			try
			{
			   Connection  con=DriverManager.getConnection("jdbc:h2:~/test","sa","");
			Statement statement1 = con.createStatement();
			ResultSet rst = statement1.executeQuery("select name from people");
		    
		    
		    HashSet<String> peopleList = new HashSet<>();
		    while (rst.next()) {
		     
		       String name=rst.getString("name");
		    	peopleList.add(name);
		    }
			peopleList.remove(userNameDB);
		
			
		    HttpSession session=request.getSession();  
	        session.setAttribute("name",username); 
	        session.setMaxInactiveInterval(10000);
	  
			LoginClass rs=new LoginClass();
			
			rs.setPassword(passwordDB);
			rs.setUsername(userNameDB);
			request.setAttribute("peopleList", peopleList);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/Text.jsp");
			rd.forward(request, response);
			}
		
		catch(SQLException se){
			
			se.printStackTrace();
		}
		}
			else{
				request.setAttribute("errors",errors);
				
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
					
				
				
			}
	}

}
