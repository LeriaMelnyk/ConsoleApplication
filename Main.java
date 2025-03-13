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

                        "BOOKS:\n" +
                        "4. New book\n" +
                        "5. Delete book\n" +
                        "6. List of books\n" +
                        "7. Search book\n\n" +

                        "TRANSACTIONS:\n" +
                        "8. Search transactions\n" +
                        "9. List of transactions\n" +
                        "10. New transaction\n" +
                        "11. Control overdue transaction\n"
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
                    System.out.print("Enter title of book: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter author of book: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter age of book: ");
                    int bookAge = Integer.parseInt(scanner.nextLine());
                    System.out.print("Book added!");
                case "5":
                    System.out.print("Enter book ID: ");
                    int bookId = Integer.parseInt(scanner.nextLine());
                    bookService.deleteBook(bookId);
                    System.out.println("Book deleted!");
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
