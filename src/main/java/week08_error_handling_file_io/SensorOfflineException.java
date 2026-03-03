package week08_error_handling_file_io;

public class SensorOfflineException extends Exception {
    public SensorOfflineException(String message) {
        super(message);
    }
}
