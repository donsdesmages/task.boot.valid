package service;

import exceptions.BadEmailException;

public interface UserService {
    public void signUp() throws BadEmailException;
}
