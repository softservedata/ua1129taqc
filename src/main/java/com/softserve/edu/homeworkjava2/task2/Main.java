package com.softserve.edu.homeworkjava2.task2;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5.0, 7.0);
        double area = rectangle.calculateArea();
        double diagonal = rectangle.getDiagonal();
        double perimeter = rectangle.calculatePerimeter();

        System.out.println("Area: " + area);
        System.out.println("Diagonal: " + diagonal);
        System.out.println("Perimeter: " + perimeter);
    }
}
