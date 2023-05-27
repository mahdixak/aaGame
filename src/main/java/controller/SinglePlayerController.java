package controller;

import javafx.event.EventHandler;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import model.Ball;
import model.MainBall;
import model.User;

public class SinglePlayerController {
    private User currentPlayer;
    private Pane gamePane;
    private int ballsRemaining;

    public String getCurrentPlayer() {
        return currentPlayer.getUsername();
    }

    public void setCurrentPlayer(String currentPlayerName) {
        if (currentPlayerName.equals("guest"))
            this.currentPlayer = new User("guest", "guest123");
        else
            this.currentPlayer = User.findUserWithUsername(currentPlayerName);
    }

    public void createPanel() {
        MainBall mainBall = new MainBall();
//        Background background = new Background(setBackground());
//        gamePane.setBackground(background);
        gamePane.getChildren().add(mainBall);
    }

    private BackgroundImage setBackground() {
        Image image = new Image(SinglePlayerController.class.getResource("/images/icon.png").toExternalForm(), 800, 800, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        return new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    }


    public void setBall() {
        if (ballsRemaining == 0) {
            System.out.println("game is over!");
            System.exit(0);
        }
        Ball ball = new Ball(ballsRemaining);
        ballsRemaining--;
        gamePane.getChildren().add(ball);
        ball.setFocusTraversable(true);
        gamePane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String keyName = keyEvent.getCode().getName();
                if (keyName.equals("Left")) {
                    ball.moveLeft();
                } else if (keyName.equals("Right"))
                    ball.moveRight();
                else if (keyName.equals("Up") || keyName.equals("Space")) {
                    ball.shoot(gamePane);
                    System.out.println(ball.getBallNumber());
                    System.out.println(ballsRemaining);
                    setBall();
                }
            }
        });
    }

    public void ballSetToMainBall(Ball ball) {
//        BallLine ballLine = new BallLine();
        Line line = new Line();
        line.setFill(Color.BLACK);
        line.setStartX(ball.getCenterX());
        line.setEndX(ball.getCenterY());
        line.setStartY(gamePane.getChildren().get(1).getLayoutY());
        line.setEndY(gamePane.getChildren().get(0).getLayoutY());
        gamePane.getChildren().add(line);
    }

    public Pane getGamePane() {
        return gamePane;
    }

    public void setGamePane(Pane gamePane) {
        this.gamePane = gamePane;
    }

    public void setBallsRemaining(int ballsRemaining) {
        this.ballsRemaining = ballsRemaining;
    }

    public int getBallsRemaining() {
        return ballsRemaining;
    }
}
