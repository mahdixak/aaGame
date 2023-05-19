package model;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private static final ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static ArrayList<User> allUsers() {
        return allUsers;
    }

    public void addUser() {
        allUsers().add(this);
    }

    public static User findUserWithUsername(String username) {
        for (User user:User.allUsers()) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }
}
