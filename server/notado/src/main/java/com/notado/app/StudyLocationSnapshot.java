package com.notado.app;

/**
 * Represents the data that will be sent to the webapp.
 */
public class StudyLocationSnapshot {

    private int id;
    private double latitude, longitude;
    private String name;
    private double noise, busy, food;

    public StudyLocationSnapshot(StudyLocation loc) {
        this.id = loc.getId();
        this.latitude = loc.getLatitude();
        this.longitude = loc.getLongitude();
        this.name = loc.getName();
        this.noise = loc.avgNoise();
        this.busy = loc.avgBusy();
        this.food = loc.avgFood();
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

    public double getNoise() {
        return noise;
    }

    public double getBusy() {
        return busy;
    }

    public double getFood() {
        return food;
    }

}
