package view.animations;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Ball;

public class BallComingFromDown extends Transition {
    private Ball ball;
    private Pane gamePane;

    public BallComingFromDown(Ball ball, Pane gamePane) {
        this.ball = ball;
        this.gamePane = gamePane;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        double y = 850;
        ball.setCenterY(y);
        if (ball.getCenterY() > 750) {
            ball.setCenterY(y-10);
        } else {
            this.stop();
        }

    }
}
