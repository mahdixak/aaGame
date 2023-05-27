package model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import view.Controllers;
import view.animations.BallComingFromDown;
import view.animations.shootingBalls;

public class Ball extends Circle {
    private final int ballNumber;
    private Line line;
    private int ballIndex;

    public Ball(int index) {
        super(500,950,20, Color.BLACK);
        this.ballNumber = index;
        this.setId(String.valueOf(index));
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public void moveLeft() {
        if (this.getCenterX() > 300 )
            this.setCenterX(this.getCenterX() - 20);
    }

    public void moveRight() {
        if (this.getCenterX() < 500)
            this.setCenterX(this.getCenterX() + 20);
    }

    public void dropBall() {
    }

    public void shoot(Pane gamePane) {
        shootingBalls shootingAnimation = new shootingBalls(gamePane,(MainBall) gamePane.getChildren().get(0),(Ball) gamePane.getChildren().get(1));
        shootingAnimation.play();
        Ball ball = (Ball) gamePane.getChildren().get(1);
        ball.setFocusTraversable(false);

//        Ball ball = new Ball();
//        BallComingFromDown ballComingFromDown = new BallComingFromDown(ball,gamePane);
//        ballComingFromDown.play();
    }

    public void setBallLine(Line line) {
        this.line = line;
    }
}
