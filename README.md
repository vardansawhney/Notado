# Notado

A webapp that displays nearby study locations and information about them.

Submission for DeltaHacks VI

## Description

The app will display known study locations on a map. 
These are locations that have been submitted to the app by its users.
It shows all submissions in an 8km radius from the user.

You can use the app to find out the busyness of the study area and how noisy it is.
This will cut the time spent on finding productive study areas,
and help determine which study areas are suitable for certain projects.
Knowing about the accessibility of food can help students plan their meals as well.

Rate a study location of your choice and provide helpful tips to newer students.
The school can refer to the lower rated study areas when renovating to make
these locations more comfortable for the students.

## Technology

This is a web app that uses Java Servlets for the backend and VanillaJS for
the front end.

## Running

In order to build the project, you need `maven`.
In order to run the webapp, you need an Apache Tomcat server installed.
You also need to configure an account for Tomcat and Maven in order to get the
automated deploy working.
[This guide may be helpful](https://www.theserverside.com/video/Step-by-step-Maven-Tomcat-WAR-file-deploy-example)
To deploy the project to the server, cd into the `server/notado` folder, then
run `mvn tomcat7:deploy`. You may need to first install the maven dependencies.
The web app will then be hosted on `localhost:8080/notado`.

