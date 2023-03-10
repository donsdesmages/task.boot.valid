package exceptions;

public class BadPasswordException extends Exception {
    public BadPasswordException(String nameExceptionPassword){
        super(nameExceptionPassword);
    }
}
