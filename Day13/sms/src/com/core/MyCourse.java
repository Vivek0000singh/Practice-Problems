package com.core;

public enum MyCourse {
    CORE_JAVA(60, 50),
    DBT(55, 40),
    PYTHON(50, 60),
    MERN(65, 45),
    WEB_JAVA(60, 55),
    DEV_OPS(70, 35);

    private final int minMarks;
    private int capacity;

    private MyCourse(int minMarks, int capacity) {
        this.minMarks = minMarks;
        this.capacity = capacity;
    }

    public int getMinMarks() {
        return minMarks;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void decreaseCapacity() {
        if (capacity > 0) {
            capacity--;
        }
    }

    public void increaseCapacity() {
        capacity++;
    }
}