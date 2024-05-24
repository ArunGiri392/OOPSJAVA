// Define the abstract Shape class
abstract class Shape {
    static final double PIE = 3.14;

    public Shape() {
        // Constructor
    }

    // Abstract method to be implemented by subclasses
    public abstract double area();
}

// Implement the Circle class extending Shape
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        System.out.println("I am from circle");
        return PIE * radius * radius;
    }
}

// Implement the Rectangle class extending Shape
class Rectangle extends Shape {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double area() {
        System.out.println("I am from rectangle");
        return length * breadth;
    }
}

// Function to print the area, demonstrating polymorphism
public class Polymorphism {
    public static void printArea(Shape shape) {
        System.out.println(shape.area());
    }

    public static void main(String[] args) {
        // Create instances of Circle and Rectangle
        Circle circle = new Circle(2);
        Rectangle rectangle = new Rectangle(3, 4); // Added breadth for Rectangle

        // Use the printArea method to demonstrate polymorphism
        printArea(circle);      // Output: I am from circle \n <circle_area>
        printArea(rectangle);   // Output: I am from rectangle \n <rectangle_area>
    }
}
