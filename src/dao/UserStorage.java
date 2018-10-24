package dao;

import domain.dao_models.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static UserStorage instance;
    private List<User> users;

    private UserStorage() {}

    private UserStorage(List<User> users) {
        this.users = users;
    }

    public static synchronized UserStorage getInstance() {
        return instance == null ? instance = new UserStorage(new ArrayList<>()) : instance;
    }

    public boolean add(User user) {
        return users.add(user);
    }
}
