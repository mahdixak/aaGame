package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class MainBall extends Circle {
    private Text userHighScore;

    public MainBall() {
        super(400, 400, 150, Color.BLACK);
    }

    public Text getUserHighScore() {
        return userHighScore;
    }

    public void setUserHighScore(Text userHighScore) {
        this.userHighScore = userHighScore;
    }
}
