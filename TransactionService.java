import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {
    private List<Transaction> transactions = new ArrayList<>();
    private int transactionIdCounter = 1;

    private UserService userService;
    private BookService bookService;

    public TransactionService() {
        this.userService = userService;
        this.bookService = bookService;
    }

    public boolean createTransaction(int userId, int bookId) {
        User user = userService.readUser(userId);
        Book book = bookService.readBook(bookId);

        if (user == null || book == null) {
            System.out.println("User or book not found!");
            return false;
        }

        if (user.getAge() < book.getAgeRestriction()) {
            System.out.println("Transaction denied: user age is below the book's age limit.");
            return false;
        }

        transactions.add(new Transaction(transactionIdCounter++, userId, bookId,
                LocalDate.now(), LocalDate.now().plusDays(14)));
        System.out.println("Transaction successful!");
        return true;
    }

    public Transaction readTransaction(int id) {
        for (Transaction transaction : transactions) {
            if (transaction.getId() == id) {
                return transaction;
            }
        }
        return null;
    }

    public boolean updateTransaction(int transactionId, LocalDate newReturnDate) {
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction.getId() == transactionId) {
                transactions.set(i, new Transaction(
                        transaction.getId(),
                        transaction.getUserId(),
                        transaction.getBookId(),
                        transaction.getIssueDate(),
                        newReturnDate
                ));
                System.out.println("Transaction updated successfully!");
                return true;
            }
        }
        System.out.println("Transaction not found!");
        return false;
    }

    public boolean deleteTransaction(int id) {
        return transactions.removeIf(transaction -> transaction.getId() == id);
    }


    public List<Transaction> listTransactions() {
        return transactions;
    }
}
