package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Balls extends Circle {
    private final int ballNumber;
    private int ballIndex = 1;

    public Balls() {
        super(400,750,20, Color.BLACK);
        this.ballNumber = ballIndex;
        ballIndex++;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public void moveLeft() {
        if (this.getCenterX() > 400 )
            this.setCenterX(this.getCenterX() - 20);
    }

    public void moveRight() {
        if (this.getCenterX() < 600)
            this.setCenterX(this.getCenterX() + 20);
    }

    public void dropBall() {
    }
}
