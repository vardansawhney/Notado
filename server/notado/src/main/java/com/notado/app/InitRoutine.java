package com.notado.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitRoutine implements ServletContextListener {

	ServletContext context;

	public void contextInitialized(ServletContextEvent contextEvent) {
		// TODO: initialize stuff taht needs intializing
		// jdbc:mariadb://localhost:3306/notado
		
		try {
			Class.forName("com.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.err.println("Couldn't load MariaDB Driver .jar");
		}

		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/notado", "david", Password.password);
			Statement tableCreation = connection.createStatement();

			// Add the tables to the database
			tableCreation.addBatch(
				"CREATE TABLE IF NOT EXISTS StudyLocation ("
				+ "latitude DOUBLE NOT NULL,"
				+ "longitude DOUBLE NOT NULL,"
				+ "name VARCHAR(255) NOT NULL,"
				+ "id INT NOT NULL,"
				+ "PRIMARY KEY (id)"
			+ ");");
			tableCreation.addBatch(
				"CREATE TABLE IF NOT EXISTS StudyLocationReview ("
				+ "uuid INT NOT NULL,"
				+ "location REFERENCES StudyLocation NOT NULL,"
				+ "noise int NOT NULL,"
				+ "busy int NOT NULL,"
				+ "food int NOT NULL),"
				+ "PRIMARY KEY (location, uuid)"
			+ ");");
		} catch (SQLException sqle) {
			System.err.println("The server was unable to initialize a connection to the database");
		}

		context = contextEvent.getServletContext();
		context.setAttribute("DBConnection", connection);

	}

	public void contextDestroyed(ServletContextEvent contextEvent) {
		// TODO: delete stuff that needs removing on server shutdown
		context = contextEvent.getServletContext();
		context.getAttribute("DBConnection");
	}

}