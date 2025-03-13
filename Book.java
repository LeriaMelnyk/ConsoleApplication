public class Book {
    private final int id;
    private final int ageRestriction;
    private final String title;
    private final String author;

    public Book(int id, String title, String author, int ageRestriction) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ageRestriction = ageRestriction;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getAgeRestriction() { return ageRestriction; }

    @Override
    public String toString() {
        return "Book: id=" + id + ", title='" + title + "', author='" + author + ", ageRestriction=" + ageRestriction;
    }
}
