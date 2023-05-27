package view.animations;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import model.Ball;
import model.MainBall;

import java.util.ArrayList;

public class CyclingBalls  {
    private Ball ball;
    private ArrayList<Ball> balls = new ArrayList<>();
    private MainBall mainBall;
    private Pane gamePane;
    private Line line;
    private Rotate rotate;
    private Timeline timeline;
    private final double periodicity;



    public CyclingBalls(Ball ball,MainBall mainBall,Pane gamePane) {
        this.ball = ball;
        this.balls.add(ball);
        this.mainBall = mainBall;
        this.gamePane = gamePane;
        this.periodicity = 2000;
        this.rotate = new Rotate();
        this.line = new Line(ball.getCenterX(),ball.getCenterY(),mainBall.getCenterX(),mainBall.getCenterY());
        line.setFill(Color.BLACK);
        ball.setBallLine(line);
        this.gamePane.getChildren().add(line);
//        this.timeline = new Timeline(new KeyFrame(Duration.ZERO,new KeyValue(rotate.angleProperty(),0),new KeyFrame(Duration.millis(periodicity) , new KeyValue(rotate.angleProperty(),360))

//        this.setCycleDuration(Duration.millis(1000));
//        this.setCycleCount(-1);
    }

    public void ballRotation() {
        rotate.setPivotX(mainBall.getCenterX());
        rotate.setPivotY(mainBall.getCenterY());
        ball.translateXProperty().bind(mainBall.translateXProperty());
        ball.translateYProperty().bind(mainBall.translateYProperty());
        line.translateXProperty().bind(mainBall.translateXProperty());
        line.translateYProperty().bind(mainBall.translateYProperty());
        ball.getTransforms().add(rotate);
        line.getTransforms().add(rotate);
        timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), 0)),
                new KeyFrame(Duration.millis(periodicity), new KeyValue(rotate.angleProperty(), 360)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        //line part

    }
//    @Override
//    protected void interpolate(double v) {
//        Rotate rotate = new Rotate();
//        rotate.setPivotX(mainBall.getCenterX());
//        rotate.setPivotY(mainBall.getCenterY());
//        ball.getTransforms().addAll(rotate);
//        rotate.setAngle(360);
//    }
}
