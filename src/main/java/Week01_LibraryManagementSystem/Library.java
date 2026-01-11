package Week01_LibraryManagementSystem;

import java.util.List;

public class Library {
    private List<Book> bookList;
    private List<Member> memberList;

    public void addBook(Book book) {
        bookList.add(book);
    }

    public Book findBook(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("Error. ISBN cannot be null or empty");
        }

        for (Book b : bookList) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }

        return null;
    }

    public List<Book> getBooks() {
        return List.copyOf(bookList);
    }


}
