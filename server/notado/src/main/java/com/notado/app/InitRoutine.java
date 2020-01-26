package com.notado.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitRoutine implements ServletContextListener {

	ServletContext context;

	public void contextInitialized(ServletContextEvent contextEvent) {
		// TODO: initialize stuff taht needs intializing
		// jdbc:mariadb://localhost:3306/notado
		
		Class.forName("com.mariadb.jdbc.Driver");
		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/notado", "david", "mysql");
			connection.prepareStatement();
		} catch (SQLException sqle) {
			System.err.println("The server was unable to initialize a connection to the database");
		}

		context = contextEvent.getServletContext();
	}

	public void contextDestroyed(ServletContextEvent contextEvent) {
		// TODO: delete stuff that needs removing on server shutdown
		context = contextEvent.getServletContext();
	}

}