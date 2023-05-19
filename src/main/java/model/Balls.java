package model;

import javafx.scene.shape.Circle;

public class Balls extends Circle {
    private final int ballNumber;
    private int ballIndex = 1;

    public Balls() {
        this.ballNumber = ballIndex;
        ballIndex++;
    }

    public int getBallNumber() {
        return ballNumber;
    }
}
