// Define an abstract class representing a Person interface
abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Abstract methods to be implemented by subclasses
    public abstract void printName();
    public abstract void printAge();
}

// Implement the Person interface in the Employee class
class Employee extends Person {
    public Employee(String name, int age) {
        super(name, age);
    }

    @Override
    public void printName() {
        System.out.println("Employee Name: " + name);
    }

    @Override
    public void printAge() {
        System.out.println("Employee Age: " + age);
    }
}

// Implement the Person interface in the Customer class
class Customer extends Person {
    public Customer(String name, int age) {
        super(name, age);
    }

    @Override
    public void printName() {
        System.out.println("Customer Name: " + name);
    }

    @Override
    public void printAge() {
        System.out.println("Customer Age: " + age);
    }
}

// Main class to demonstrate the functionality
public class Abstraction {
    public static void main(String[] args) {
        // Create instances of Employee and Customer
        Employee employee = new Employee("John", 30);
        Customer customer = new Customer("Alice", 25);

        // Use the interface methods
        employee.printName();  // Output: Employee Name: John
        employee.printAge();   // Output: Employee Age: 30

        customer.printName();  // Output: Customer Name: Alice
        customer.printAge();   // Output: Customer Age: 25
    }
}
