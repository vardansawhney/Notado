package com.notado.app;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewReviewServlet extends HttpServlet 
{
	
	//private static final long serialVersionID = 3134742735150446896L;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
            double latitude = Double.parseDouble(request.getParameter("latitude"));
            double longitude = Double.parseDouble(request.getParameter("longitude"));
            String name = request.getParameter("name");
            int noiseRating = Integer.parseInt(request.getParameter("noiserating"));
            int foodAccessRating = Integer.parseInt(request.getParameter("foodaccessrating"));
            int availabilityRating = Integer.parseInt(request.getParameter("availabilityrating"));
		}
		catch (Exception e) 
		{
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
