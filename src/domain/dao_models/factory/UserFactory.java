package domain.dao_models.factory;

import domain.dao_models.User;
import utils.exceptions.ConverterException;

import static utils.Constants.EMPTY;

public class UserFactory {
    public static User create(String login, String password) {
        if (validate(login, password)) return new User(login, password);
        throw new ConverterException();
    }

    private static boolean validate(String login, String password) {
        if (login == null || password == null) return false;
        return !login.equals(EMPTY) && !password.equals(EMPTY);
    }
}
