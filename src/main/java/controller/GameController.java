package controller;

import javafx.scene.layout.Pane;
import model.Ball;
import model.GameStage;
import model.MainBall;
import model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GameController {
    private User currentPlayer;

    public void setPlayerUsername(String playerUsername) {
        if (playerUsername.equals("guest"))
            this.currentPlayer = new User("guest","guest123");
        else
            this.currentPlayer = User.findUserWithUsername(playerUsername);
    }

    public User getPlayerUsername() {
        return currentPlayer;
    }


    public void addHighCoreForShootingBall() {
        currentPlayer.riseHighscore();
    }

    public void addBallLine(Ball ball) {

    }
    public void reverseMainBallRotation(Pane pane, MainBall mainBall,ArrayList<Ball> balls) {

    }

    public void riseBallsRadios(Pane pane,ArrayList<Ball> balls) {

    }

    public void invisibleBallsOnTheMainBall(Pane pane,ArrayList<Ball> balls) {

    }

    public void windOnTheBalls(Pane pane,Ball ball) {

    }
//    public void showHighScores() {
//        ArrayList<Integer> highscoreFirstToDown = new ArrayList<>();
//        for (User user:User.allUsers()) {
//            highscoreFirstToDown.add(user.getHighScore());
//        }
//        Collections.sort(highscoreFirstToDown);
//        System.out.println(highscoreFirstToDown);
//    }
}
