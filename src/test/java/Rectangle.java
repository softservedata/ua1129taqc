import org.jetbrains.annotations.TestOnly;
import static org.junit.Assert.assertEquals;
import java.util.Scanner;

public class Rectangle {
    private double width;
    private double height;
    private double angle;

    public Rectangle() {
        this.width = width;
        this.height = height;
        this.angle= angle;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getAngle() {
        return angle;
    }

    public double CalculateArea() {
        return height * width;
    }

    public double CalculatePerimeter() {
        return height + width;
    }

    public double getDiagonal() {
        return Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2));
    }

    @TestOnly
    public void testCalculateArea() {
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        double expectedArea = 15.0;
        assertEquals(expectedArea, rectangle.CalculateArea(), 0.0001);
    }

    @TestOnly
    public void testGetDiagonal() {
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        double expectedDiagonal = 5.0;
        assertEquals(expectedDiagonal, rectangle.getDiagonal(), 0.0001);
    }

    @TestOnly
    public void testCalculatePerimeter() {
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        double expectedPerimeter = 7.0;
        assertEquals(expectedPerimeter, rectangle.CalculatePerimeter(), 0.0001);

    }
}