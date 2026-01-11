package week01_library_management_system;

public class Main {
    public static void main(String[] args) {

        // 1. Create a Library
        Library library = new Library();

        // 2. Create books
        Book book1 = new Book("I-H01", "Harry Potter", "J.K. Rowling");
        Book book2 = new Book("I-LOTR01", "Lord of the Rings", "J.R.R. Tolkien");
        Book book3 = new Book("I-GOT01", "Game of Thrones", "George R.R. Martin");
        Book book4 = new Book("I-HG01", "Hunger Games", "Suzanne Collins");

        // Add books to library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        // 3. Create Member
        Member member1 = new Member("Alice");

        library.registerMember(member1);

        // 4. Member borrows books
        member1.borrowBook(book1);
        member1.borrowBook(book2);
        member1.borrowBook(book3);
        member1.borrowBook(book4); // <------ Can't borrow, reached limit

        // 5. Create second member
        Member member2 = new Member("Bob");
        library.registerMember(member2);

        member2.borrowBook(book1); // Can't borrow, book isn't available

        member1.returnBook(book1); // returns book, now can borrow again

        // Now second can borrow the book
        member2.borrowBook(book1);

    }
}
