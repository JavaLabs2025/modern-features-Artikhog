package org.lab;

public value class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x() { return x; }
    public double y() { return y; }

    public Point withX(double newX) {
        return new Point(newX, this.y);
    }

    public Point withY(double newY) {
        return new Point(this.x, newY);
    }
}
