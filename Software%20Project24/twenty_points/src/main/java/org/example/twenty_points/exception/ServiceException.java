package org.example.twenty_points.exception;

<<<<<<< HEAD
public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
=======
public class ServiceException extends Exception {
    public ServiceException(String message) {
        super();
>>>>>>> backend
    }
    public ServiceException() {

    }
}
