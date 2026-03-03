package week08_error_handling_file_io;

// Checked Exception, extiende de Exception
public class CorruptDataException extends Exception {

    // 1. constructor default, solo mensaje
    public CorruptDataException(String message) {
        super(message);
    }

    // 2. Constructor con mensaje y CAUSA original (aplicamos Exception Chaining)
    public CorruptDataException(String message, Throwable cause){
        super(message,cause);
    }
}
