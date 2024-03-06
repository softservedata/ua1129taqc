package com.softserve.edu.homeworkjava2.task2;

public class Rectangle {
    private double width;
    private double height;
    private double angle;

    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
        this.angle = 90;
    }

    public Rectangle(double width, double height) {
        validateDimensionMoreThanZero(width);
        validateDimensionMoreThanZero(height);
        this.width = width;
        this.height = height;
        this.angle = 90;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        validateDimensionMoreThanZero(width);
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        validateDimensionMoreThanZero(height);
        this.height = height;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        validateAngle(angle);
        this.angle = angle;
    }

    public double calculateArea() {
        return height * width;
    }

    public double calculatePerimeter() {
        return 2 * (height + width);
    }

    public double getDiagonal() {
        return Math.sqrt((Math.pow(width, 2) + Math.pow(height, 2)));
    }

    private void validateDimensionMoreThanZero(double dimension) {
        if (dimension <= 0) {
            throw new IllegalStateException("Width or height can't be less or equal to zero");
        }
    }

    private void validateAngle(double angle) {
        if (angle <= 0) {
            throw new IllegalStateException("Width or height can't be less or equal to zero");
        }
    }
}
