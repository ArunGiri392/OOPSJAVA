// Define the abstract Shape class
public abstract class Shape {
    static final double PIE = 3.14;
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    // Abstract methods to be implemented by subclasses
    public abstract double area();
    public abstract double perimeter();
}

// Implement the Rectangle class extending Shape
class Rectangle extends Shape {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth, String name) {
        super(name);
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double area() {
        return length * breadth;
    }

    @Override
    public double perimeter() {
        return 2 * (length + breadth);
    }
}

// Implement the Circle class extending Shape
class Circle extends Shape {
    private double radius;

    public Circle(double radius, String name) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double area() {
        return PIE * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * PIE * radius;
    }
}

// Main class to demonstrate the functionality
class Main {
    public static void main(String[] args) {
        // Create an instance of Rectangle
        Rectangle rectangle = new Rectangle(4, 5, "rectangle");
        System.out.println("The area of " + rectangle.name + " is " + rectangle.area());
        System.out.println("The perimeter of " + rectangle.name + " is " + rectangle.perimeter());

        // Create an instance of Circle
        Circle circle = new Circle(4, "circle");
        System.out.println("The area of " + circle.name + " is " + circle.area());
        System.out.println("The perimeter of " + circle.name + " is " + circle.perimeter());
    }
}
