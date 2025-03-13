import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
