# 📚 Library-Management-System

A simple **console-based Library Management System** built with **Core Java** and **Object-Oriented Programming (OOP)** concepts. It is designed as a beginner-friendly project to practice classes, objects, constructors, encapsulation, `ArrayList`, and input validation.

---

## 📖 Project Description

This application lets a librarian manage a small collection of books from the command line. Books are stored in an `ArrayList`, and the program lets you add books, search for them, issue them to students, return them, and see how many books the library holds. No database or external library is needed — everything runs in memory using plain Java.

> **Note:** Data is stored in memory only, so it resets every time the program is closed.

---

## ✨ Features

- ➕ Add new books (with duplicate Book ID check)
- 📋 Display all available books
- 🔍 Search books by **Book ID** or **Book Name** (partial, case-insensitive match)
- 📤 Issue books to students
- 📥 Return books
- 📕 Display all issued books (with the student's name)
- 🔢 Show total, available and issued book counts
- ✅ Input validation (invalid numbers, empty text, wrong menu choices)

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java (JDK 8 or higher) | Programming language |
| `ArrayList` (Java Collections) | Storing book details |
| `Scanner` | Reading console input |
| Git & GitHub | Version control |

**OOP concepts used:** Classes & Objects, Constructors, Encapsulation (private fields with getters), Abstraction (separate `Library` class for operations).

---

## 📁 Project Structure

```
Library-Management-System/
├── src/
│   ├── Main.java      # Menu and user input (entry point)
│   ├── Book.java      # Book class (data of one book)
│   └── Library.java   # Library class (ArrayList + all operations)
├── .gitignore
└── README.md
```

---

## 🚀 How to Install and Run

### Prerequisites
- Install the **JDK (version 8 or higher)**. Check with:
  ```bash
  java -version
  javac -version
  ```

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/<your-username>/Library-Management-System.git
   cd Library-Management-System
   ```

2. **Compile the code**
   ```bash
   mkdir out
   javac -d out src/*.java
   ```
   On Windows (Command Prompt), use `mkdir out` and then `javac -d out src\*.java`.

3. **Run the program**
   ```bash
   java -cp out Main
   ```

### Using an IDE
Open the folder in IntelliJ IDEA, Eclipse, or VS Code, then run `Main.java`.

---

## 🖥️ Sample Output

```
========== LIBRARY MANAGEMENT SYSTEM ==========
1. Add New Book
2. Display Available Books
3. Search Book by ID
4. Search Book by Name
5. Issue Book
6. Return Book
7. Display Issued Books
8. Show Total Number of Books
9. Exit
===============================================
Enter your choice (1-9): 1

Enter Book ID: 101
Enter Book Title: Java Programming
Enter Author Name: James Gosling
Book added successfully!

Enter your choice (1-9): 1

Enter Book ID: abc
Invalid input! Please enter a valid number.
Enter Book ID: 102
Enter Book Title: Data Structures
Enter Author Name: Mark Allen
Book added successfully!

Enter your choice (1-9): 2

ID     Title                        Author                 Status
-------------------------------------------------------------------------
101    Java Programming             James Gosling          Available
102    Data Structures              Mark Allen             Available

Enter your choice (1-9): 4

Enter Book Name to search: data
ID     Title                        Author                 Status
-------------------------------------------------------------------------
102    Data Structures              Mark Allen             Available

Enter your choice (1-9): 5

Enter Book ID to issue: 101
Enter Student Name: Rahul
"Java Programming" has been issued to Rahul.

Enter your choice (1-9): 7

ID     Title                        Author                 Status
-------------------------------------------------------------------------
101    Java Programming             James Gosling          Issued to Rahul

Enter your choice (1-9): 8

Total books in library : 2
Available books        : 1
Issued books           : 1

Enter your choice (1-9): 6

Enter Book ID to return: 101
"Java Programming" has been returned by Rahul.

Enter your choice (1-9): 9

Thank you for using the Library Management System. Goodbye!
```

---

## 🔮 Future Improvements

- Save data to a file or database so it is not lost on exit
- Add student records and due dates / fines
- Add a GUI using Java Swing or JavaFX

---

## 📄 License

This project is open source and free to use for learning purposes.

## 👤 Author

**Your Name** – [GitHub Profile](https://github.com/<your-username>)
