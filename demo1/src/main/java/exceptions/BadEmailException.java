package exceptions;

public class BadEmailException extends Exception {
    public BadEmailException(String nameException){
        super(nameException);
    }
}
