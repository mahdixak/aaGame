package model;

import java.util.ArrayList;

public class SinglePlayerGame {
    private final User currentPlayer;
    private Difficulty gameDifficulty;
    private MainBall mainBall;
    private ArrayList<Balls> balls;
    private ArrayList<BallLines> ballLines;

    public SinglePlayerGame(User currentPlayer,Difficulty difficulty) {
        this.currentPlayer = currentPlayer;
        this.gameDifficulty = difficulty;
        this.mainBall = new MainBall();
        this.balls = new ArrayList<>();
        this.ballLines = new ArrayList<>();
    }

    public User getCurrentPlayer() {
        return currentPlayer;
    }

    public Difficulty getGameDifficulty() {
        return gameDifficulty;
    }

    public MainBall getMainBall() {
        return mainBall;
    }

    public ArrayList<Balls> getBalls() {
        return balls;
    }

    public ArrayList<BallLines> getBallLines() {
        return ballLines;
    }

    public void setBallLines(ArrayList<BallLines> ballLines) {
        this.ballLines = ballLines;
    }

    public void setGameDifficulty(Difficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }
}
