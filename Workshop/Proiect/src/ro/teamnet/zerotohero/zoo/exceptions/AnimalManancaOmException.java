package ro.teamnet.zerotohero.zoo.exceptions;

/**
 * Created by Andrei.Apostol on 7/4/2017.
 */
public class AnimalManancaOmException extends RuntimeException {
    public AnimalManancaOmException() {
        super();
    }
    public AnimalManancaOmException(String s) {
        super(s);
    }
    public AnimalManancaOmException(String s, Throwable throwable) {
        super(s, throwable);
    }
    public AnimalManancaOmException(Throwable throwable) {
        super(throwable);
    }
}
