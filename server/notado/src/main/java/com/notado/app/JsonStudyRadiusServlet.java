package com.notado.app;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonStudyRadiusServlet extends HttpServlet 
{

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
            double latitude = Double.parseDouble(request.getParameter("latitude"));
            double longitude = Double.parseDouble(request.getParameter("longitude"));
            // TODO: 0.05 degrees + and - for search area
		}
		catch(Exception e)
		{
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
		}
	}
}
