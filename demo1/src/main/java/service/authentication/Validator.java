package service.authentication;

import exceptions.BadEmailException;
import exceptions.BadPasswordException;

public class Validator {

    public static void emailValidator(String email) throws BadEmailException {
        if (!email.isEmpty()) {
            if (email.matches("^[a-zA-Z0-9]{1,}"
                +"((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"
                +"@" +"[a-zA-Z0-9]{1,}"
                + "((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"
                + "\\.[a-zA-Z]{2,}$")) {


                return;
            }
            throw new BadEmailException("");
        }
        throw new BadEmailException("");
    }

    public static void passwordValidator(String password) throws BadPasswordException {
        if ((password!= null)) {
            if ((password.matches("^[a-zA-Z0-9]*$"))
                && (password.length() > 7 )) {
                return;
            }
            throw new BadPasswordException("");
        }
        throw new BadPasswordException("");
    }

}
