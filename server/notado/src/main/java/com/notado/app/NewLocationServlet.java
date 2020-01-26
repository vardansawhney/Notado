package com.notado.app;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewLocationServlet extends HttpServlet {

    /**
	 * ?? MY IDE told me to do this
	 */
	private static final long serialVersionUID = 3134742735150446895L;

	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            // Get the database connection from the server context
            //(Connection) getServletContext().getAttribute("database");

            double latitude = Double.parseDouble(request.getParameter("latitude"));
            double longitude = Double.parseDouble(request.getParameter("longitude"));

        } catch (Exception e) {
            // FAIL.png
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

}