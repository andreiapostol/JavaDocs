package exercise.exercise4.exceptions;

/**
 * Created by Andrei.Apostol on 7/5/2017.
 */

    public class InvalidIndexException extends Exception {
        public InvalidIndexException(String message) {
            super(message);
        }

        public InvalidIndexException(String message, Throwable throwable) {
            super(message, throwable);
        }
    }
