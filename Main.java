import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        BookService bookService = new BookService();
        TransactionService transactionService = new TransactionService();
        Scanner scanner = new Scanner(System.in);
        Scanner command = new Scanner(System.in);

        System.out.print(
                "USERS:\n" +
                        "1. New user\n" +
                        "2. Delete user\n" +
                        "3. List of users\n\n" +
                        "4. Search user\n\n" +


                        "BOOKS:\n" +
                        "5. New book\n" +
                        "5.1 Update book\n" +
                        "6. Delete book\n" +
                        "7. List of books\n" +
                        "8. Sort books\n" +


                        "TRANSACTIONS:\n" +
                        "9. New transaction\n" +
                        "10. Search transaction\n" +
                        "11. Update return date\n" +
                        "12. Delete transaction\n" +
                        "13. List all transactions\n\n"
        );

        System.out.println("Enter command: ");

        boolean running = true;
        while (running) {
            switch (command.nextLine()) {
                case "1":
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    userService.addUser(name,email,age);
                    System.out.println("User created!");
                    break;
                case "2":
                    System.out.print("Enter user ID: ");
                    int userId = Integer.parseInt(scanner.nextLine());
                    userService.deleteUser(userId);
                    System.out.println("User deleted!");
                    break;
                case "3":
                    System.out.println("Users: " + userService.listUsers());
                    break;
                case "4":
                    System.out.print("Enter search keyword: ");
                    String keyword = scanner.nextLine();
                    System.out.println("Search results: " + userService.searchUsers(keyword));
                    break;
                case "5":
                    System.out.print("Enter title of book: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter author of book: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter age of book: ");
                    int bookAge = Integer.parseInt(scanner.nextLine());
                    bookService.createBook(bookTitle,author,bookAge);
                    System.out.print("Book added!");
                    break;
                case "5.1":
                    System.out.print("Enter book ID: ");
                    int updateBookId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new age restriction: ");
                    int newAgeRestriction = Integer.parseInt(scanner.nextLine());
                    boolean updated = bookService.updateBook(updateBookId, newTitle, newAuthor, newAgeRestriction);
                    if (updated) {
                        System.out.println("Book updated successfully!");
                    } else {
                        System.out.println("Book update failed! Book ID not found.");
                    }
                    break;
                case "6":
                    System.out.print("Enter book ID: ");
                    int bookId = Integer.parseInt(scanner.nextLine());
                    bookService.deleteBook(bookId);
                    System.out.println("Book deleted!");
                case "7":
                    System.out.println("Books: " + bookService.listBooks());
                    break;
                case "8":
                    System.out.print("Sort by (id/title/author/age): ");
                    String sortBy = scanner.nextLine();
                    System.out.println("Sorted books: " + bookService.sortBooks(sortBy));
                    break;
                case "9":
                    System.out.print("Enter user ID: ");
                    int userId1 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter book ID: ");
                    int bookId1 = Integer.parseInt(scanner.nextLine());
                    if (transactionService.createTransaction(userId1, bookId1)) {
                        System.out.println("Transaction created successfully!");
                    } else {
                        System.out.println("Transaction failed!");
                    }
                    break;

                case "10":
                    System.out.print("Enter transaction ID: ");
                    int transactionId = Integer.parseInt(scanner.nextLine());

                    Transaction transaction = transactionService.readTransaction(transactionId);
                    if (transaction != null) {
                        System.out.println("Transaction found: " + transaction);
                    } else {
                        System.out.println("Transaction not found!");
                    }
                    break;

                case "11":
                    System.out.print("Enter transaction ID: ");
                    int updateTransactionId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new return date (YYYY-MM-DD): ");
                    LocalDate newReturnDate = LocalDate.parse(scanner.nextLine());
                    boolean updated1 = transactionService.updateTransaction(updateTransactionId, newReturnDate);
                    if (updated1) {
                        System.out.println("Transaction updated successfully!");
                    } else {
                        System.out.println("Transaction update failed!");
                    }
                    break;

                case "12":
                    System.out.print("Enter transaction ID: ");
                    int deleteTransactionId = Integer.parseInt(scanner.nextLine());
                    if (transactionService.deleteTransaction(deleteTransactionId)) {
                        System.out.println("Transaction deleted successfully!");
                    } else {
                        System.out.println("Transaction deletion failed! Transaction not found.");
                    }
                    break;
                case "13":
                   System.out.println("List of transactions:");
                   for (Transaction t : transactionService.listTransactions()) {
                       System.out.println(t);
                   }
                   break;
                case "exit":
                    System.out.println("Application closed");
                    running = false;
                    break;
                default:
                    System.out.println("Command not recognized!");
                    break;
            }
        }
        command.close();
    }
}
