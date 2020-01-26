package com.notado.app;

import java.util.Vector;

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
            int id = Integer.parseInt(request.getParameter("id"));
            int user = Integer.parseInt(request.getParameter("user"));
            int noise = Integer.parseInt(request.getParameter("noise"));
            int food = Integer.parseInt(request.getParameter("food"));
            int busy = Integer.parseInt(request.getParameter("busy"));
            
            Vector<StudyLocation> locations = (Vector<StudyLocation>)
                getServletContext().getAttribute("locations");

            if (noise > 0 && noise <= 10
                && busy > 0 && busy <= 10
                && food > 0 && food <= 10
                && id < locations.size()) {
                // Valid
                locations.get(id).addReview(new StudyLocationReview(
                    user,
                    noise,
                    busy,
                    food
                ));
            } else {
			    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
		}
		catch (Exception e) 
		{
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
