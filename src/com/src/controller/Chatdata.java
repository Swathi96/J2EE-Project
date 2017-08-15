package com.src.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.model.ChatStore;


@WebServlet("/Chatdata")
public class Chatdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Chatdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try{
			try {
		
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection  con=DriverManager.getConnection("jdbc:h2:~/test","sa","");
		Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
		ResultSet rst = statement.executeQuery("select name from people");
	    String text=request.getParameter("text");
	    String name=request.getParameter("list");
	    ChatStore cs=new ChatStore();
	    cs.setName(name);
	    cs.setText(text);
	    System.out.println(text);
	    request.setAttribute("list", name);
	    
	    
	    
	    HashSet<String> peopleList = new HashSet<>();
	    while (rst.next()) {
	     
	       String name1=rst.getString("name");
	    	peopleList.add(name1);
	    }
	    peopleList.remove(name);
	    request.setAttribute("peopleList", peopleList);
	    RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/Text.jsp");
	    rd.forward(request, response);
	  /*  HashSet<String> PeopleList = new HashSet<>();
	  while (rst.next()) {
	      //  Customer customer = new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
	       String name=rst.getString("name");
	    	PeopleList.add(name);
	    }*/
	    
	
	}
		catch(SQLException se){
			
			se.printStackTrace();
		}
}

}
