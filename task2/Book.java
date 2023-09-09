import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private double price;


    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nPrice: $" + price;
    }
}

class OnlineBookStore {
    private List<Book> books;

    public OnlineBookStore() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Available books:");
            for (Book book : books) {
                System.out.println(book);
                System.out.println("---------------------");
            }
        }
    }

    public static void main(String[] args) {
        OnlineBookStore bookStore = new OnlineBookStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            scanner.close();
          
 

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    Book newBook = new Book(title, author, price);
                    bookStore.addBook(newBook);
                    break;
                case 2:
                    bookStore.listBooks();
                    break;
                case 3:
                    System.out.println("Exiting the book store.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }
}
