package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {

    private static final Map<Integer, User> databaseOfUsers = new HashMap<>();

    public static void add(User newUser) {
        databaseOfUsers.put(newUser.getId(),newUser);
    }

    public static Collection<User> getAll() {
        return databaseOfUsers.values();
    }

    public static User getById(int id) {
        return databaseOfUsers.get(id);
    }

    public static Map<Integer, User> getDatabaseOfUsers() {
        return databaseOfUsers;
    }
}
