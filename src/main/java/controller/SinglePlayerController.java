package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.Balls;
import model.MainBall;
import model.SinglePlayerGame;
import model.User;

import java.util.ArrayList;

public class SinglePlayerController {
    private final User currentPlayer;

    public SinglePlayerController(String currentPlayerUsername) {
        this.currentPlayer = User.findUserWithUsername(currentPlayerUsername);
    }

    public void createPanel(Pane gamePane) {
        SinglePlayerGame singlePlayerGame = new SinglePlayerGame(this.currentPlayer,this.currentPlayer.getDifficulty());
        MainBall mainBall = new MainBall();
        Balls balls = setBall(gamePane);
        gamePane.getChildren().add(balls);
        gamePane.getChildren().add(mainBall);
        gamePane.getChildren().get(0).requestFocus();
    }

    private Balls setBall(Pane gamePane) {
        Balls ball = new Balls();
        ball.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String keyName = keyEvent.getCode().getName();
                if (keyName.equals("Left")) {
                    ball.moveLeft();
                } else if (keyName.equals("Right")) {
                    ball.moveRight();
                } else if (keyName.equals("Up")) {
                    ball.dropBall();
                }
            }
        });
        return ball;
    }
}
