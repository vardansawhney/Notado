package com.notado.app;

import java.util.Vector;
import java.io.BufferedWriter;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonStudyRadiusServlet extends HttpServlet 
{

    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
            double latitude = Double.parseDouble(request.getParameter("latitude"));
            double longitude = Double.parseDouble(request.getParameter("longitude"));

            if (-180 <= longitude && longitude <= 180
                && -90 <= latitude && latitude <= 90) {
            
                // Search with 0.05 degrees in a box (around 8 km)
                // This hecks over people who want to use the app on the
                // poles or the longitude 180
                double minLat = latitude - 0.05 < -90? -90: latitude - 0.05;
                double minLong = longitude - 0.05 < -180? -180: longitude - 0.05;

                double maxLat = latitude + 0.05 < 90? 90: latitude + 0.05;
                double maxLong = longitude + 0.05 < 180? 180: longitude + 0.05;

                Vector<StudyLocation> inRange = new Vector<>();

                Vector<StudyLocation> locations =
                    (Vector<StudyLocation>)getServletContext().getAttribute("locations");

                for (StudyLocation a : locations) {
                    if (minLat <= a.getLatitude() && a.getLatitude() <= maxLat
                        && minLong <= a.getLongitude() && a.getLongitude() <= maxLong) {
                        inRange.add(a);
                    }
                }

                ObjectMapper mapper = new ObjectMapper();
                String jsonLocations = mapper.writeValueAsString(inRange);
                response.setCharacterEncoding("utf-8");
                try {
                    BufferedWriter bw = new BufferedWriter(response.getWriter());
                    bw.write(jsonLocations);
                    bw.close();
                } catch (IOException e){
                    getServletContext().log("The JSON couldn't be writen to the GET response");
			        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                }

            } else {
                // Invalid input
			    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }

		}
		catch(Exception e)
		{
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
