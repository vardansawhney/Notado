package com.notado.app;

import java.util.Vector;
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

        
		context = contextEvent.getServletContext();
        context.setAttribute("locations", new Vector<StudyLocation>());

        // NOTE: the database communication has been removed
//		Connection connection = null;
//
//		try {
//			connection = DriverManager.getConnection(
//                "jdbc:mariadb://127.0.0.1/notado", "david", "");
//            context.log("Connected to the database");
//			Statement tableCreation = connection.createStatement();
//
//			// Add the tables to the database
//			tableCreation.addBatch(
//				"CREATE TABLE IF NOT EXISTS StudyLocation ("
//				+ "latitude DOUBLE NOT NULL,"
//				+ "longitude DOUBLE NOT NULL,"
//				+ "name VARCHAR(255) NOT NULL,"
//				+ "id INT NOT NULL,"
//				+ "PRIMARY KEY (id)"
//			+ ");");
//			tableCreation.addBatch(
//				"CREATE TABLE IF NOT EXISTS StudyLocationReview ("
//				+ "uuid INT NOT NULL,"
//                + "location INT NOT NULL,"
//				+ "noise int NOT NULL,"
//				+ "busy int NOT NULL,"
//				+ "food int NOT NULL,"
//				+ "FOREIGN KEY location REFERENCES StudyLocation (id),"
//				+ "PRIMARY KEY (location, uuid)"
//			+ ");");
//            tableCreation.executeBatch();
//		} catch (Exception e) {
//			context.log("The server was unable to initialize a connection to the database");
//		}
//
//		context.setAttribute("DBConnection", connection);

	}

	public void contextDestroyed(ServletContextEvent contextEvent) {
		// TODO: delete stuff that needs removing on server shutdown
		context = contextEvent.getServletContext();
//		try {
//			Connection connection = ((Connection) context.getAttribute("DBConnection"));
//            if (connection != null) {
//                connection.close();
//            }
//            context.log("Disconnected from the database");
//        } catch (SQLException e) {
//            context.log("Unable to close database connection");
//        }
	}

}
