package Week01_LibraryManagementSystem;

public class Book {
    // Private fields
    private final String isbn;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor (set isAvailable true as default)
    public Book(String isbn, String title, String author) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("isbn cannot be empty or null");
        }
        this.isbn = isbn;

        setTitle(title);
        setAuthor(author);
        this.isAvailable = true;
    }

    // Custom method to borrow book.
    public void borrowBook() {
        // Check if isAvailable (true) first
        if (isAvailable) {
            // If isAvailable then set false
            this.isAvailable = false;

        } else { // If not available (false) let the user know
            System.out.println("Book isn't available");
        }
    }

    public void setTitle(String title) {
        // Validation for title
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty or null");
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        // Validation for title, if empty or null set "Unknown author" as default
        if (author == null || author.trim().isEmpty()) {
            this.author = "Unknown author";
        }
        this.author = author;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
