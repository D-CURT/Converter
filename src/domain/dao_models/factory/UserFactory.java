package domain.dao_models.factory;

import domain.dao_models.User;
import utils.exceptions.ConverterException;

import java.util.Arrays;

public class UserFactory {
    public static User create(String login, String password) {
        if (validate(login, password)) return new User(login, password);
        throw new ConverterException();
    }

    public static User create(String name, String login, String password) {
        if (validate(name, login, password)) return new User(name, login, password);
        throw new ConverterException();
    }

    private static boolean validate(String ... args) {
        return Arrays.stream(args).allMatch(s -> s != null && !s.isEmpty());
    }
}
