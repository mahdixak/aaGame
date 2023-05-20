package model;

import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private Difficulty difficulty;
    private int highScore;
    private Circle avatar;
    private static final ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.highScore = 0;
        this.setDifficulty(Difficulty.EASY);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Circle getAvatar() {
        return avatar;
    }

    public void setAvatar(Circle avatar) {
        this.avatar = avatar;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
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

    public int getHighScore() {
        return highScore;
    }
}
