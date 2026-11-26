import java.util.ArrayList;

/**
 * Library.java
 * Holds all the books (in an ArrayList) and contains the library operations.
 * Methods that need to show messages print them directly to keep things simple.
 */
public class Library {

    // ArrayList that stores every Book object
    private ArrayList<Book> books;

    /** Constructor: creates an empty library. */
    public Library() {
        books = new ArrayList<>();
    }

    // ------------------------------------------------------------
    // Helper methods
    // ------------------------------------------------------------

    /** Finds a book by its ID. Returns null if not found. */
    private Book findById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    /** Prints the table header used when listing books. */
    private void printHeader() {
        System.out.printf("%-6s %-28s %-22s %s%n", "ID", "Title", "Author", "Status");
        System.out.println("-------------------------------------------------------------------------");
    }

    // ------------------------------------------------------------
    // Library features
    // ------------------------------------------------------------

    /** Adds a new book. Duplicate book IDs are not allowed. */
    public void addBook(int bookId, String title, String author) {
        if (findById(bookId) != null) {
            System.out.println("Error: A book with ID " + bookId + " already exists.");
            return;
        }
        books.add(new Book(bookId, title, author));
        System.out.println("Book added successfully!");
    }

    /** Displays all books that are currently available (not issued). */
    public void displayAvailableBooks() {
        boolean found = false;
        for (Book book : books) {
            if (!book.isIssued()) {
                if (!found) {
                    printHeader();   // print the header only once
                    found = true;
                }
                book.display();
            }
        }
        if (!found) {
            System.out.println("No available books right now.");
        }
    }

    /** Searches for a book by ID and displays it. */
    public void searchById(int bookId) {
        Book book = findById(bookId);
        if (book == null) {
            System.out.println("No book found with ID " + bookId + ".");
        } else {
            printHeader();
            book.display();
        }
    }

    /** Searches for books by name. Partial and case-insensitive matches work. */
    public void searchByName(String name) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(name.toLowerCase())) {
                if (!found) {
                    printHeader();
                    found = true;
                }
                book.display();
            }
        }
        if (!found) {
            System.out.println("No book found with the name \"" + name + "\".");
        }
    }

    /** Issues a book to a student if the book exists and is available. */
    public void issueBook(int bookId, String studentName) {
        Book book = findById(bookId);
        if (book == null) {
            System.out.println("Error: No book found with ID " + bookId + ".");
        } else if (book.isIssued()) {
            System.out.println("Sorry, this book is already issued to " + book.getIssuedTo() + ".");
        } else {
            book.issue(studentName);
            System.out.println("\"" + book.getTitle() + "\" has been issued to " + studentName + ".");
        }
    }

    /** Returns a book to the library if it was issued. */
    public void returnBook(int bookId) {
        Book book = findById(bookId);
        if (book == null) {
            System.out.println("Error: No book found with ID " + bookId + ".");
        } else if (!book.isIssued()) {
            System.out.println("This book was not issued, so it cannot be returned.");
        } else {
            String student = book.getIssuedTo();
            book.returnBook();
            System.out.println("\"" + book.getTitle() + "\" has been returned by " + student + ".");
        }
    }

    /** Displays all books that are currently issued. */
    public void displayIssuedBooks() {
        boolean found = false;
        for (Book book : books) {
            if (book.isIssued()) {
                if (!found) {
                    printHeader();
                    found = true;
                }
                book.display();
            }
        }
        if (!found) {
            System.out.println("No books are currently issued.");
        }
    }

    /** Shows the total, available and issued book counts. */
    public void showTotalBooks() {
        int issuedCount = 0;
        for (Book book : books) {
            if (book.isIssued()) {
                issuedCount++;
            }
        }
        System.out.println("Total books in library : " + books.size());
        System.out.println("Available books        : " + (books.size() - issuedCount));
        System.out.println("Issued books           : " + issuedCount);
    }
}
