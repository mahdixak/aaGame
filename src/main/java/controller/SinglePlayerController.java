package controller;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import model.Balls;
import model.MainBall;
import model.User;
import view.StartMenu;

public class SinglePlayerController {
    private User currentPlayer;

    public User getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayerName) {
        this.currentPlayer = User.findUserWithUsername(currentPlayerName);
    }

    public void createPanel(Pane gamePane) {
        MainBall mainBall = new MainBall();
//        Background background = new Background(setBackground());
//        gamePane.setBackground(background);
        gamePane.getChildren().add(mainBall);
    }

    private BackgroundImage setBackground() {
        Image image = new Image(SinglePlayerController.class.getResource("/images/icon.png").toExternalForm(),800,800,false,false);
        BackgroundImage backgroundImage =  new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        return new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    }


    public void setBall(Pane gamePane) {
        Balls ball = new Balls();
        gamePane.getChildren().add(ball);
        gamePane.getChildren().get(0).requestFocus();
        gamePane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String keyName = keyEvent.getCode().getName();
                if (keyName.equals("Left")) {
                    ball.moveLeft();
                }
                else if (keyName.equals("Right"))
                    ball.moveRight();
                else if (keyName.equals("Up")||keyName.equals("Space")){
                    ball.shoot(gamePane);
                    System.out.println("boz");
                }
            }
        });
    }
}
