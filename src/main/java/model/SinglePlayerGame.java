package model;

public class SinglePlayerGame {


    private final User currentPlayer;
    private Difficulty gameDifficulty;

    public SinglePlayerGame(User currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
