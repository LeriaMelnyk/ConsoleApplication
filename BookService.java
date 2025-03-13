import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> books = new ArrayList<>();
    private int bookIdCounter = 1;

    public void createBook(String title, String author, int ageRestriction) {
        books.add(new Book(bookIdCounter++, title, author, ageRestriction));
    }

    public Book readBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public boolean updateBook(int id, String newTitle, String newAuthor, int newAgeRestriction) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.set(books.indexOf(book), new Book(id, newTitle, newAuthor, newAgeRestriction));
                return true;
            }
        }
        return false;
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }

    public List<Book> listBooks() {
        return books;
    }
}
