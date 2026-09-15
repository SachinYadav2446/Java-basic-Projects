import java.util.ArrayList;
import java.util.Scanner;
public class LibraryManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Book> library = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║   Library Management System         ║");
        System.out.println("║   (Inheritance & Polymorphism)      ║");
        System.out.println("╚═════════════════════════════════════╝\n");
        // Initialize library with sample books
        initializeLibrary();
        initializeMembers();
        boolean continueProgram = true;
        while(continueProgram) {
            displayMenu();
            System.out.print("Enter your choice (1-8): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input!\n");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    viewMemberBooks();
                    break;
                case 6:
                    searchBook();
                    break;
                case 7:
                    viewBookDetails();
                    break;
                case 8:
                    continueProgram = false;
                    System.out.println("\nThank you for using Library System!");
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }
        scanner.close();
    }
    static void displayMenu() {
        System.out.println("\n--- Library Management Menu ---");
        System.out.println("1. Add new book");
        System.out.println("2. View all books");
        System.out.println("3. Borrow a book");
        System.out.println("4. Return a book");
        System.out.println("5. View member's books");
        System.out.println("6. Search book");
        System.out.println("7. View book details");
        System.out.println("8. Exit");
    }
    static void initializeLibrary() {
        library.add(new PrintedBook("B001", "Java Programming", "Yadav", 2020, true, 400));
        library.add(new EBook("B002", "Python Guide", "Smith", 2021, true, 2.5));
        library.add(new AudioBook("B003", "Clean Code", "Uncle Bob", 2019, true, 480));
        library.add(new PrintedBook("B004", "Data Structures", "Cormen", 2018, true, 1000));
    }
    static void initializeMembers() {
        members.add(new Member("M001", "Yadav", "yadav@email.com"));
        members.add(new Member("M002", "Priya", "priya@email.com"));
        members.add(new Member("M003", "Arjun", "arjun@email.com"));
    }
    static void addBook() {
        System.out.print("\nSelect book type:");
        System.out.println("1. Printed Book");
        System.out.println("2. E-Book");
        System.out.println("3. Audio Book");
        System.out.print("Choice: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input!");
            scanner.nextLine();
            return;
        }
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine().trim();
        System.out.print("Enter Year: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid year!");
            scanner.nextLine();
            return;
        }
        int year = scanner.nextInt();
        Book book = null;
        if (type == 1) {
            System.out.print("Enter number of pages: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input!");
                scanner.nextLine();
                return;
            }
            int pages = scanner.nextInt();
            book = new PrintedBook(id, title, author, year, true, pages);
        } else if (type == 2) {
            System.out.print("Enter file size (in MB): ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid input!");
                scanner.nextLine();
                return;
            }
            double fileSize = scanner.nextDouble();
            book = new EBook(id, title, author, year, true, fileSize);
        } else if (type == 3) {
            System.out.print("Enter duration (in minutes): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input!");
                scanner.nextLine();
                return;
            }
            int duration = scanner.nextInt();
            book = new AudioBook(id, title, author, year, true, duration);
        } else {
            System.out.println("Invalid type!");
            return;
        }
        library.add(book);
        System.out.println("✓ Book added successfully!");
    }
    static void viewAllBooks() {
        if (library.isEmpty()) {
            System.out.println("\n📭 No books in library!");
            return;
        }
        System.out.println("\n--- Library Catalog ---");
        System.out.println("┌─────┬──────────────────────┬─────────────────┬──────┬─────────────┐");
        System.out.println("│ ID  │ Title                │ Author          │ Year │ Type        │");
        System.out.println("├─────┼──────────────────────┼─────────────────┼──────┼─────────────┤");
        for (Book book : library) {
            String type = book.getClass().getSimpleName();
            System.out.printf("│ %-3s │ %-20s │ %-15s │ %-4d │ %-11s │\n",
                            book.getBookId(),
                            book.getTitle(),
                            book.getAuthor(),
                            book.getYear(),
                            type);
        }
        System.out.println("└─────┴──────────────────────┴─────────────────┴──────┴─────────────┘");
    }
    static void borrowBook() {
        System.out.print("\nEnter member ID: ");
        String memberId = scanner.nextLine().trim();
        Member member = findMember(memberId);
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }
        System.out.print("Enter book ID to borrow: ");
        String bookId = scanner.nextLine().trim();
        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is not available!");
            return;
        }
        book.setAvailable(false);
        member.borrowBook(book);
        System.out.println("✓ Book borrowed successfully!");
        System.out.println("Borrowed by: " + member.getMemberName());
    }
    static void returnBook() {
        System.out.print("\nEnter member ID: ");
        String memberId = scanner.nextLine().trim();
        Member member = findMember(memberId);
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }
        System.out.print("Enter book ID to return: ");
        String bookId = scanner.nextLine().trim();
        Book book = member.returnBook(bookId);
        if (book != null) {
            book.setAvailable(true);
            System.out.println("✓ Book returned successfully!");
        } else {
            System.out.println("Member does not have this book!");
        }
    }
    static void viewMemberBooks() {
        System.out.print("\nEnter member ID: ");
        String memberId = scanner.nextLine().trim();
        Member member = findMember(memberId);
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }
        member.displayBorrowedBooks();
    }
    static void searchBook() {
        System.out.print("\nEnter search term (title or author): ");
        String searchTerm = scanner.nextLine().toLowerCase().trim();
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : library) {
            if (book.getTitle().toLowerCase().contains(searchTerm) ||
                book.getAuthor().toLowerCase().contains(searchTerm)) {
                results.add(book);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No books found!");
            return;
        }
        System.out.println("\n--- Search Results ---");
        for (Book book : results) {
            System.out.println(book.getBookId() + " - " + book.getTitle() + 
                              " by " + book.getAuthor() + " (" + book.getYear() + ")");
        }
    }
    static void viewBookDetails() {
        System.out.print("\nEnter book ID: ");
        String bookId = scanner.nextLine().trim();
        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        System.out.println("\n--- Book Details ---");
        book.displayDetails();
    }
    static Book findBook(String bookId) {
        for (Book book : library) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }
    static Member findMember(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
}
// ==================== Base Class ====================
abstract class Book {
    protected String bookId;
    protected String title;
    protected String author;
    protected int year;
    protected boolean available;
    public Book(String bookId, String title, String author, int year, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
    }
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    // Abstract method (must be implemented by subclasses)
    abstract void displayDetails();
}
// ==================== Subclasses ====================
class PrintedBook extends Book {
    private int numberOfPages;
    public PrintedBook(String bookId, String title, String author, 
                      int year, boolean available, int numberOfPages) {
        super(bookId, title, author, year, available);
        this.numberOfPages = numberOfPages;
    }
    public int getNumberOfPages() { return numberOfPages; }
    @Override
    void displayDetails() {
        System.out.println("Type: Printed Book");
        System.out.println("ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Pages: " + numberOfPages);
        System.out.println("Status: " + (available ? "Available" : "Not Available"));
    }
}
class EBook extends Book {
    private double fileSizeMB;
    public EBook(String bookId, String title, String author, 
                int year, boolean available, double fileSizeMB) {
        super(bookId, title, author, year, available);
        this.fileSizeMB = fileSizeMB;
    }
    public double getFileSizeMB() { return fileSizeMB; }
    @Override
    void displayDetails() {
        System.out.println("Type: E-Book");
        System.out.println("ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("File Size: " + fileSizeMB + " MB");
        System.out.println("Status: " + (available ? "Available" : "Not Available"));
    }
}
class AudioBook extends Book {
    private int durationMinutes;
    public AudioBook(String bookId, String title, String author, 
                    int year, boolean available, int durationMinutes) {
        super(bookId, title, author, year, available);
        this.durationMinutes = durationMinutes;
    }
    public int getDurationMinutes() { return durationMinutes; }
    @Override
    void displayDetails() {
        System.out.println("Type: Audio Book");
        System.out.println("ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Duration: " + durationMinutes + " minutes");
        System.out.println("Status: " + (available ? "Available" : "Not Available"));
    }
}
// ==================== Member Class ====================
class Member {
    private String memberId;
    private String memberName;
    private String email;
    private ArrayList<Book> borrowedBooks;
    public Member(String memberId, String memberName, String email) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }
    public String getMemberId() { return memberId; }
    public String getMemberName() { return memberName; }
    public String getEmail() { return email; }
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
    public Book returnBook(String bookId) {
        for (int i = 0; i < borrowedBooks.size(); i++) {
            if (borrowedBooks.get(i).getBookId().equals(bookId)) {
                return borrowedBooks.remove(i);
            }
        }
        return null;
    }
    public void displayBorrowedBooks() {
        System.out.println("\n--- " + memberName + "'s Borrowed Books ---");
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed");
            return;
        }
        for (Book book : borrowedBooks) {
            System.out.println("  • " + book.getTitle() + " by " + book.getAuthor());
        }
    }
}
