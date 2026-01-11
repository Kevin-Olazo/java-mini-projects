package Week01_LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Member {
    // Private fields
    private final String memberId;
    private String name;
    private List<Book> booksBorrowed;

    // Constructor
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.booksBorrowed = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (booksBorrowed.size() < 3 && book.isAvailable()) {
            book.borrowBook();
            booksBorrowed.add(book);
        } else {
            System.out.println("You have reached the limit of books you can borrow (3).");
        }
    }

}
