package com.authentication.demo1;

import constants.PrintFunctions;
import exceptions.BadEmailException;

import exceptions.BadPasswordException;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static constants.StringConstants.*;
import static service.authentication.Validator.emailValidator;
import static service.authentication.Validator.passwordValidator;

@RestController
@RequestMapping("/validation")
public class Controller {

    private static final List<UserData> userDataList = new ArrayList<>();

    @SneakyThrows
    @PostMapping
    public Object functionPostEmail(@RequestBody UserData userData) {
            try {
                emailValidator(userData.getEmail());
                passwordValidator(userData.getPassword());
                userDataList.add(userData);
                return PrintFunctions.
                    functionValidData(VALID_DATA);
            }
            catch (BadEmailException | BadPasswordException e) {
                if (e instanceof BadEmailException) {
                    return PrintFunctions.
                        functionPrintExceptionTextEmail(EXCEPTION_TEXT_EMAIL);
                }
                if (e instanceof BadPasswordException) {
                    return PrintFunctions.functionPrintExceptionTextPassword(EXCEPTION_TEXT_PASSWORD);
                }
            }
        return null;
    }

}
