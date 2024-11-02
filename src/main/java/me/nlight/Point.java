package me.nlight;

public class Point {
    private double x;
    private double y;

    Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getLength() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
}
