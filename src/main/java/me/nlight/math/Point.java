package me.nlight.math;

public class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getLength() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
}
