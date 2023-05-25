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
    private Avatar avatar;
    private static final ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.highScore = -8;
        this.setDifficulty(Difficulty.EASY);
    }
    public User(String username,String password,long highScore,String difficultly,String avatar) {
        this.username = username;
        this.password = password;
        this.highScore = (int) highScore;
        Difficulty.setUserDifficulty(this,difficultly);
        Avatar.setUserAvatar(this,avatar);
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

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatarIndex) {
        if (avatarIndex.equals("circle1"))
            this.avatar = Avatar.avatar1;
        else if (avatarIndex.equals("circle2"))
            this.avatar = Avatar.avatar2;
        else if (avatarIndex.equals("circle3"))
            this.avatar = Avatar.avatar3;
        else if (avatarIndex.equals("circle4"))
            this.avatar = Avatar.avatar4;
        else if (avatarIndex.equals("circle5"))
            this.avatar = Avatar.avatar5;
        else if (avatarIndex.equals("circle6"))
            this.avatar = Avatar.avatar6;
        else if (avatarIndex.equals("circle7"))
            this.avatar = Avatar.avatar7;
        else if (avatarIndex.equals("circle8"))
            this.avatar = Avatar.avatar8;
        else if (avatarIndex.equals("circle9"))
            this.avatar = Avatar.avatar9;
        else if (avatarIndex.equals("circle10"))
            this.avatar = Avatar.avatar10;
        else if (avatarIndex.equals("circle11"))
            this.avatar = Avatar.avatar11;
        else if (avatarIndex.equals("circle12"))
            this.avatar = Avatar.avatar12;
    }

    public void setAvatar(Avatar avatar) {
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

    public void riseHighscore() {
        this.highScore += this.getDifficulty().getHighScoreForEachShoot();
    }
}
