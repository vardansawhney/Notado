package com.notado.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitRoutine implements ServletContextListener {

	ServletContext context;

	public void contextInitialized(ServletContextEvent contextEvent) {
		// TODO: initialize stuff taht needs intializing
		context = contextEvent.getServletContext();

	}

	public void contextDestroyed(ServletContextEvent contextEvent) {
		// TODO: delete stuff that needs removing on server shutdown
		context = contextEvent.getServletContext();
	}

}