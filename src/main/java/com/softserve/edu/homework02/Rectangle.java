package com.softserve.edu.homework02;

public class Rectangle {

    //Create a class Rectangle to represent a rectangle.

    private double width;
    private double height;
    private final int angle = 90;

    public Rectangle() {
        width = 1.0;
        height = 1.0;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getAngle() {
        return angle;
    }

    public double calculateArea() {
        return width * height;
    };

    public double calculatePerimeter() {
        return 2 * (width + height);
    };

    public double getDiagonal() {
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    };

    public static void main(String[] args) {

        //create a new instance
        Rectangle rectangle = new Rectangle(100, 10);
        System.out.println("Width: " + rectangle.getWidth());
        System.out.println("Height: " + rectangle.getHeight());
        System.out.println("Angle: " + (int)rectangle.getAngle() + "°");
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
        System.out.println("Diagonal: " + rectangle.getDiagonal());

        System.out.println("-------------------------------------------");

        //change values
        rectangle.setWidth(5);
        rectangle.setHeight(7);
        System.out.println("Width: " + rectangle.getWidth());
        System.out.println("Height: " + rectangle.getHeight());
        System.out.println("Angle: " + (int)rectangle.getAngle() + "°");
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
        System.out.println("Diagonal: " + rectangle.getDiagonal());

    }
}
