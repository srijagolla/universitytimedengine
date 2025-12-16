public class TimeExpiredException extends Exception {
    public TimeExpiredException(String msg) { super(msg); }
}

class InvalidResponseFormatException extends Exception {
    public InvalidResponseFormatException(String msg) { super(msg); }
}