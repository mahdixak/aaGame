package view.animations;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Ball;
import model.MainBall;

import static view.Controllers.gameController;

public class shootingBalls extends Transition {
    private final Pane gamePane;
    private final MainBall mainBall;
    private final Ball ball;
//    private final BallLines ballLine;

    public shootingBalls(Pane gamePane, MainBall mainBall, Ball ball) {
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
        if (ball.getBoundsInParent().intersects(mainBall.getBoundsInParent())) {
            System.out.println("hit the ball!");
            System.exit(0);
        }
        ball.setCenterY(y);
        gameController.addHighCoreForShootingBall();
    }
}
