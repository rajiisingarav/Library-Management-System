/**
 * Book.java
 * Represents a single book in the library.
 * Demonstrates: encapsulation (private fields + getters/setters) and constructors.
 */
public class Book {

    // ----- Private fields (encapsulation) -----
    private int bookId;
    private String title;
    private String author;
    private boolean isIssued;      // true if the book is currently issued
    private String issuedTo;       // name of the student who has the book

    /**
     * Constructor: creates a new book. A new book is always available.
     *
     * @param bookId unique ID of the book
     * @param title  name of the book
     * @param author author of the book
     */
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
        this.issuedTo = "";
    }

    // ----- Getters -----
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public String getIssuedTo() {
        return issuedTo;
    }

    // ----- Actions -----

    /** Marks the book as issued to the given student. */
    public void issue(String studentName) {
        this.isIssued = true;
        this.issuedTo = studentName;
    }

    /** Marks the book as returned (available again). */
    public void returnBook() {
        this.isIssued = false;
        this.issuedTo = "";
    }

    /** Prints the book details in a single formatted line. */
    public void display() {
        String status = isIssued ? "Issued to " + issuedTo : "Available";
        System.out.printf("%-6d %-28s %-22s %s%n", bookId, title, author, status);
    }
}
