package com.validation.service.service.impl;

import com.validation.service.exception.BadEmailException;
import com.validation.service.exception.BadPasswordException;
import com.validation.service.service.UserService;
import org.springframework.stereotype.Service;

import static com.validation.service.util.Constant.EXCEPTION_TEXT_EMAIL;
import static com.validation.service.util.Constant.EXCEPTION_TEXT_PASSWORD;
import static com.validation.service.util.Constant.OK_STATUS;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String validate(String password, String email) {
        try {
            emailValidator(email);
            passwordValidator(password);
        } catch (BadEmailException e) {
            return EXCEPTION_TEXT_EMAIL;
        } catch (BadPasswordException e) {
            return EXCEPTION_TEXT_PASSWORD;
        }

        return OK_STATUS;
    }

    private void emailValidator(String email) throws BadEmailException {
        if (!email.isEmpty()) {
            if (email.matches("^[a-zA-Z0-9]{1,}"
                +"((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"
                +"@" +"[a-zA-Z0-9]{1,}"
                + "((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"
                + "\\.[a-zA-Z]{2,}$")) {
                return;
            }

            throw new BadEmailException();
        }

        throw new BadEmailException();
    }

    private void passwordValidator(String password) throws BadPasswordException {
        if (password != null) {
            if ((password.matches("^[a-zA-Z0-9]*$"))
                && (password.length() > 7 )) {
                return;
            }

            throw new BadPasswordException();
        }

        throw new BadPasswordException();
    }
}
