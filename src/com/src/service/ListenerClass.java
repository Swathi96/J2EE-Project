package com.src.service;

import java.sql.SQLException;

import javax.servlet.ServletContext;
//import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
//import java.sql.SQLException;

@WebListener
public class ListenerClass implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerClass() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	ServletContext context=arg0.getServletContext();
    	
    	try {
			context.setAttribute("namesList", FactoryClass.getInstance().dBCall());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    	
	
}
