package dao;

import domain.dao_models.User;

import java.util.Collections;
import java.util.List;

public class UserStorage {
    private static UserStorage instance;
    private List<User> users;

    private UserStorage() {}

    private UserStorage(List<User> users) {
        this.users = users;
    }

    public static synchronized UserStorage getInstance() {
        return instance == null ? instance = new UserStorage(Collections.singletonList(new User("user", "123"))) : instance;
    }

    public boolean add(User user) {
        return users.add(user);
    }

    public boolean check(User user) {
        return users.contains(user);
    }
}
