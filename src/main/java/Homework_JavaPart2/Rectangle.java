package Homework_JavaPart2;
public class Rectangle {

    private double width;
    private double height;


    public Rectangle() {
        // Initialize fields to default values
        this.width = 0;
        this.height = 0;
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
        // Angle is always 90 degrees
        double angle = 90;
        return angle;
    }


    public double calculateArea() {
        return width * height;
    }


    public double calculatePerimeter() {
        return 2 * (width + height);
    }


    public double getDiagonal() {
        return Math.sqrt(width * width + height * height);
    }

    public static void main(String[] args) {

        Rectangle myRectangle = new Rectangle(5, 10);


        System.out.println("Width: " + myRectangle.getWidth());
        System.out.println("Height: " + myRectangle.getHeight());
        System.out.println("Angle: " + myRectangle.getAngle());
        System.out.println("Area: " + myRectangle.calculateArea());
        System.out.println("Perimeter: " + myRectangle.calculatePerimeter());
        System.out.println("Diagonal: " + myRectangle.getDiagonal());
    }
}
