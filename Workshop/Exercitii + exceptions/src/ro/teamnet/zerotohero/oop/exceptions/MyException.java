package ro.teamnet.zerotohero.oop.exceptions;

/**
 * Created by Andrei.Apostol on 7/4/2017.
 */

public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
