import java.time.LocalDate;

public class Transaction {
    private final int id;
    private final int userId;
    private final int bookId;
    private final LocalDate issueDate;
    private final LocalDate dueDate;

    public Transaction(int id, int userId, int bookId, LocalDate issueDate, LocalDate dueDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public int getBookId() { return bookId; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getDueDate() { return dueDate; }

    @Override
    public String toString() {
        return "Transaction{id=" + id + ", userId=" + userId + ", bookId=" + bookId +
                ", issueDate=" + issueDate + ", dueDate=" + dueDate + "}";
    }
}

