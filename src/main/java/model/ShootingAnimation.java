package model;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class ShootingAnimation extends Transition {
    private final Pane gamePane;
    private final MainBall mainBall;
    private final Balls ball;
//    private final BallLines ballLine;

    public ShootingAnimation(Pane gamePane,MainBall mainBall,Balls ball) {
        this.gamePane = gamePane;
        this.mainBall = mainBall;
        this.ball = ball;
//        this.ballLine = ballLine;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double frac) {
        double y = ball.getCenterY() - 10;
        if (y<= mainBall.getCenterY() - mainBall.getRadius() - 50) {
            gamePane.getChildren().remove(ball);
            this.stop();

        }
        ball.setCenterY(y);
    }
}
