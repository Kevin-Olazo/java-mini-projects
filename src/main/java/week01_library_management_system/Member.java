package week01_library_management_system;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Member {
    // Private fields
    private final String memberId;
    private String name;
    private List<Book> booksBorrowed;

    // NO MAGIC NUMBERS
    private static final int MAX_BORROW_LIMIT = 3;

    // Constructor
    public Member(String name) {
        this.memberId = UUID.randomUUID().toString();
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
        this.name = name;
        this.booksBorrowed = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (!book.isAvailable()) {
            System.out.println("Book is not available.");
            return;
        } else if (booksBorrowed.size() < MAX_BORROW_LIMIT) {
            book.borrowBook();
            booksBorrowed.add(book);
        } else {
            System.out.println("You have reached the limit of books you can borrow (3).");
        }
    }

    public void returnBook(Book book) {
        if (booksBorrowed.remove(book)){
            book.returnBook();
        } else {
            System.out.println("You haven't borrowed that book");
        }
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }
}
