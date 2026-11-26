import java.util.Scanner;

/**
 * Main.java
 * Entry point of the Library Management System.
 * Shows a menu and calls the matching method of the Library class.
 */
public class Main {

    // One Scanner shared by all input methods
    private static final Scanner scanner = new Scanner(System.in);

    // ------------------------------------------------------------
    // Input validation helpers
    // ------------------------------------------------------------

    /** Keeps asking until the user enters a valid positive whole number. */
    private static int readPositiveInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                }
                System.out.println("Invalid input! Please enter a number greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    /** Keeps asking until the user enters a non-empty text. */
    private static String readText(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Invalid input! This field cannot be empty.");
        }
    }

    // ------------------------------------------------------------
    // Menu
    // ------------------------------------------------------------

    private static void showMenu() {
        System.out.println("\n========== LIBRARY MANAGEMENT SYSTEM ==========");
        System.out.println("1. Add New Book");
        System.out.println("2. Display Available Books");
        System.out.println("3. Search Book by ID");
        System.out.println("4. Search Book by Name");
        System.out.println("5. Issue Book");
        System.out.println("6. Return Book");
        System.out.println("7. Display Issued Books");
        System.out.println("8. Show Total Number of Books");
        System.out.println("9. Exit");
        System.out.println("===============================================");
    }

    public static void main(String[] args) {
        Library library = new Library();
        boolean running = true;

        while (running) {
            showMenu();
            int choice = readPositiveInt("Enter your choice (1-9): ");
            System.out.println();

            switch (choice) {
                case 1:
                    int id = readPositiveInt("Enter Book ID: ");
                    String title = readText("Enter Book Title: ");
                    String author = readText("Enter Author Name: ");
                    library.addBook(id, title, author);
                    break;
                case 2:
                    library.displayAvailableBooks();
                    break;
                case 3:
                    library.searchById(readPositiveInt("Enter Book ID to search: "));
                    break;
                case 4:
                    library.searchByName(readText("Enter Book Name to search: "));
                    break;
                case 5:
                    int issueId = readPositiveInt("Enter Book ID to issue: ");
                    String student = readText("Enter Student Name: ");
                    library.issueBook(issueId, student);
                    break;
                case 6:
                    library.returnBook(readPositiveInt("Enter Book ID to return: "));
                    break;
                case 7:
                    library.displayIssuedBooks();
                    break;
                case 8:
                    library.showTotalBooks();
                    break;
                case 9:
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 9.");
            }
        }
        scanner.close();
    }
}
