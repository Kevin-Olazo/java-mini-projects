package week08_error_handling_file_io;

public class InvalidReadingException extends RuntimeException {
    public InvalidReadingException(String message) {
        super(message);
    }
}
