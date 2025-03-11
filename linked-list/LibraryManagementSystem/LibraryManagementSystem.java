import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    Book head = null;
    Book tail = null;
    int bookCount = 0;

    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
        System.out.println("Book added at the beginning.");
    }

    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
        System.out.println("Book added at the end.");
    }

    public void removeBookById(int bookId) {
        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }
        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        bookCount--;
        System.out.println("Book removed.");
    }

    public void searchBook(String query) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(query) || temp.author.equalsIgnoreCase(query)) {
                System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void updateAvailability(int bookId, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                System.out.println("Availability status updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void displayBooksForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    public void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    public void countTotalBooks() {
        System.out.println("Total number of books in the library: " + bookCount);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Remove Book by ID");
            System.out.println("4. Search Book by Title/Author");
            System.out.println("5. Update Book Availability");
            System.out.println("6. Display Books Forward");
            System.out.println("7. Display Books Reverse");
            System.out.println("8. Count Total Books");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    System.out.print("Is Available (true/false): ");
                    boolean isAvailable = scanner.nextBoolean();
                    library.addBookAtBeginning(title, author, genre, bookId, isAvailable);
                    break;
                case 2:
                    System.out.print("Enter Title: ");
                    scanner.nextLine();
                    title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    bookId = scanner.nextInt();
                    System.out.print("Is Available (true/false): ");
                    isAvailable = scanner.nextBoolean();
                    library.addBookAtEnd(title, author, genre, bookId, isAvailable);
                    break;
                case 3:
                    System.out.print("Enter Book ID to remove: ");
                    bookId = scanner.nextInt();
                    library.removeBookById(bookId);
                    break;
                case 4:
                    System.out.print("Enter Title or Author to search: ");
                    scanner.nextLine();
                    String query = scanner.nextLine();
                    library.searchBook(query);
                    break;
                case 5:
                    System.out.print("Enter Book ID to update availability: ");
                    bookId = scanner.nextInt();
                    System.out.print("Enter Availability (true/false): ");
                    isAvailable = scanner.nextBoolean();
                    library.updateAvailability(bookId, isAvailable);
                    break;
                case 6:
                    library.displayBooksForward();
                    break;
                case 7:
                    library.displayBooksReverse();
                    break;
                case 8:
                    library.countTotalBooks();
                    break;
                case 9:
                    scanner.close();
                    return;
            }
        }
    }
}
