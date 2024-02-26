package homework07.javapart2;

/** Implement the Rectangle class according to the problem statement.
 Additional requirements:
 The class should be encapsulated.
 The class should be tested.
 Methods that can be implemented in the Rectangle class:
 A method calculateArea() that calculates the area of the rectangle.
 A method calculatePerimeter() that calculates the perimeter of the rectangle.
 A method getDiagonal() that returns the length of the diagonal of the rectangle.
 Demonstrate the correctness of the created methods.
 */

public class Rectangle {
    private double width;
    private double height;
    private final double angle = 90;
    public Rectangle(){
        width = 0.0;
        height = 0.0;
    }
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    public double getAngle(){
        return angle;
    }
    public void setWidth(double newWidth){
        this.width = newWidth;
    }
    public void setHeight(double newHeight){
        this.height = newHeight;
    }
    public double calculateArea(){
        return width * height;
    }
    public double calculatePerimeter(){
        return 2 * (width + height);
    }
    public double getDiagonal(){
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }

    public static void main(String[] args) {
        Rectangle newRectangle = new Rectangle(9,4);
        System.out.println("\nWidth of the first rectangle: " + newRectangle.getWidth() +
                "\nHeight of the first rectangle: " + newRectangle.getHeight() +
                "\nAngle of the first rectangle: " + newRectangle.getAngle() +
                "\nArea of the first rectangle is: " + newRectangle.calculateArea() +
                "\nPerimeter of the first rectangle is: " + newRectangle.calculatePerimeter() +
                "\nLength of the diagonal of the first rectangle is: " + newRectangle.getDiagonal());

        newRectangle.setWidth(12.0);
        newRectangle.setHeight(8.0);
        System.out.println("\nWidth of the second rectangle: " + newRectangle.getWidth() +
                "\nHeight of the second rectangle: " + newRectangle.getHeight() +
                "\nAngle of the second rectangle: " + newRectangle.getAngle() +
                "\nArea of the second rectangle is: " + newRectangle.calculateArea() +
                "\nPerimeter of the second rectangle is: " + newRectangle.calculatePerimeter() +
                "\nLength of the diagonal of the second rectangle is: " + newRectangle.getDiagonal());
    }


}
