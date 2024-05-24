import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private String location;
    private List<Book> booksAvailable;

    public Library(String name, String location) {
        this.name = name;
        this.location = location;
        this.booksAvailable = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.booksAvailable.add(book);
    }

    public void removeBook(Book book) {
        this.booksAvailable.remove(book);
    }

    public Book searchBook(String bookName) {
        for (Book book : this.booksAvailable) {
            if (book.getName().equals(bookName) && book.isAvailable()) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(Customer customer, String bookName, String borrowDate) {
        Book book = searchBook(bookName);
        if (book != null) {
            if (book.borrow(customer, borrowDate)) {
                System.out.println("Book is successfully borrowed by " + customer.getName());
                removeBook(book);
            } else {
                System.out.println("Book is not available now");
            }
        } else {
            System.out.println("Book is not in the library");
        }
    }

    public void returnBook(Book book) {
        book.returned();
        addBook(book);
    }
}

class Customer {
    private int customerId;
    private String name;
    private String email;
    private String phoneNumber;

    public Customer(int customerId, String name, String email, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getName(){
        return name;
    }
}

class Book {
    private String name;
    private String genre;
    private String author;
    private String publicationDate;
    private boolean isAvailable;
    private String borrowDate;
    private Customer borrower;

    public Book(String name, String genre, String author, String publicationDate) {
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isAvailable = true;
        this.borrowDate = null;
        this.borrower = null;
    }

    public boolean borrow(Customer customer, String borrowDate) {
        if (isAvailable) {
            isAvailable = false;
            borrower = customer;
            this.borrowDate = borrowDate;
            return true;
        }
        return false;
    }

    public void returned() {
        isAvailable = true;
        borrowDate = null;
        borrower = null;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}

 class Main {
    public static void main(String[] args) {
        // Instantiate some books
        Book book1 = new Book("The Great Gatsby", "Fiction", "F. Scott Fitzgerald", "April 10, 1925");
        Book book2 = new Book("To Kill a Mockingbird", "Fiction", "Harper Lee", "July 11, 1960");

        // Instantiate a customer
        Customer customer1 = new Customer(1, "John Doe", "john@example.com", "123-456-7890");

        // Instantiate a library
        Library library = new Library("Franklin library", "123 Main St");

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);

        // Simulate borrowing a book by the customer
        String borrowDate = "2024-05-16";
        library.borrowBook(customer1, "The Great Gatsby", borrowDate);
        library.returnBook(book1);
    }
}
