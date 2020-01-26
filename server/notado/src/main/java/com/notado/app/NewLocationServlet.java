package com.notado.app;

import java.util.Vector;
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

            double latitude = Double.parseDouble(request.getParameter("latitude"));
            double longitude = Double.parseDouble(request.getParameter("longitude"));
            String name = request.getParameter("name");

            int user = Integer.parseInt(request.getParameter("user"));
            int noise = Integer.parseInt(request.getParameter("noise"));
            int busy = Integer.parseInt(request.getParameter("busy"));
            int food = Integer.parseInt(request.getParameter("food"));

            if (!(noise > 0 && noise <= 10
                && busy > 0 && busy <= 10
                && food > 0 && food <= 10)) {

                // Invalid ratings
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            } else if (!(-180 <= longitude && longitude <= 180
                && -90 <= latitude && latitude <= 90)) {

                // Invalid location
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            } else {

                // Valid
                Vector<StudyLocation> locations = 
                    (Vector<StudyLocation>) getServletContext().getAttribute("locations");
                locations.add(new StudyLocation(
                    locations.size(),
                    name,
                    latitude,
                    longitude
                ));
                locations.get(locations.size() - 1).addReview(new StudyLocationReview(
                    user,
                    noise,
                    busy,
                    food
                ));
            }

        } catch (Exception e) {
            // FAIL.png
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

}
