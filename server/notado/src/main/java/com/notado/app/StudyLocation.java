package com.notado.app;

import java.util.Vector;

public class StudyLocation {

    private int id;
    private double latitude, longitude;
    private String name;
    private Vector<StudyLocationReview> reviews;

    public StudyLocation(int id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        reviews = new Vector<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double avgNoise() {
        int sum = 0;
        for (StudyLocationReview a: reviews) {
            sum += a.getNoise();
        }
        return ((double)sum)/reviews.size();
    }

    public double avgBusy() {
        int sum = 0;
        for (StudyLocationReview a: reviews) {
            sum += a.getBusy();
        }
        return ((double)sum)/reviews.size();
    } 

    public double avgFood() {
        int sum = 0;
        for (StudyLocationReview a: reviews) {
            sum += a.getFood();
        }
        return ((double)sum)/reviews.size();
    }

    public void addReview(StudyLocationReview review) {
        reviews.add(review);
    }

}
