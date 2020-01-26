package com.notado.app;


public class StudyLocationReview {

    private int user;
    private int noise, busy, food;

    public StudyLocationReview(int user, int noise, int busy, int food) {
        this.user = user;
        this.noise = noise;
        this.busy = busy;
        this.food = food;
    }

    public int getNoise() {
        return noise;
    }

    public int getBusy() {
        return busy;
    }

    public int getFood() {
        return food;
    }

}
