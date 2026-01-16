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

    public boolean borrowBook(Book book) {
        if (!book.isAvailable()) {
            return false;
        }

        if (booksBorrowed.size() < MAX_BORROW_LIMIT) {
            book.borrowBook();
            booksBorrowed.add(book);
            return true;
        }

        return false;
    }

    public boolean returnBook(Book book) {
        if (booksBorrowed.remove(book)){
            book.returnBook();
            return true;
        }
        return false;

    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }
}
