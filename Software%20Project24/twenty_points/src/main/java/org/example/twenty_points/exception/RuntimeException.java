package org.example.twenty_points.exception;

public class RuntimeException extends java.lang.RuntimeException {
    public RuntimeException(String message) {
        super(message);
    }
    public RuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
    public RuntimeException(Throwable cause) {
        super(cause);
    }
}
