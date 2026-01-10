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
        // Check if isAvailable is false first
        if (!isAvailable) {
            System.out.println("Book isn't available");
        } else { // If not available (false), then we lend the book and set it false
            System.out.println("Borrowing the book titled: " + title);
            setAvailable(false);
        }
    }

    public void returnBook() {
        if (isAvailable) {
            System.out.println("Book already available");
        } else {
            System.out.println("Returning book titled: " + title);
            setAvailable(true);
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
        } else {
            this.author = author;
        }
    }

    private void setAvailable(boolean available) {
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
