package com.softserve.edu.JavaPart2HW;

public class Rectangle {
    double width;
    double height;
    double angle = 90.0;

    public Rectangle(double width, double height, double angle) {
        this.width = width;
        this.height = height;
        this.angle = angle;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(){

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

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    public double getDiagonal() {
        return width * width + height * height;
    }

    public static void main (String[]args){
        Rectangle rectangle = new Rectangle(5.0, 10.0);
        double area = rectangle.calculateArea();
        System.out.println("Area of the rectangle: " + area);

        double perimeter = rectangle.calculatePerimeter();
        System.out.println("Perimeter of the rectangle: " + perimeter);

        double diagonal = rectangle.getDiagonal();
        System.out.println("Diagonal of the rectangle: " + diagonal);
    }

}