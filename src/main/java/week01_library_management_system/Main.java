package week01_library_management_system;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        Book book1 = new Book("I-H01", "Harry Potter", "J.K. Rowling");
        Book book2 = new Book("I-LOTR01", "Lord of the Rings", "J.R.R. Tolkien");

        Member member1 = new Member("Alice");

        member1.borrowBook(book1);


    }
}
