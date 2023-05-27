package model;

import java.util.ArrayList;

public class GameDataBase {
    private final User gameOwner;
    private final MainBall mainBall;
    private final ArrayList<Ball> droppedBalls;
    private boolean stage1Access;
    private boolean stage2Access;
    private boolean stage3Access;
    private boolean stage4Access;

    public GameDataBase(User gameOwner, MainBall mainBall) {
        this.gameOwner = gameOwner;
        this.mainBall = mainBall;
        this.droppedBalls = new ArrayList<>();
        this.stage1Access = true;
        this.stage2Access = false;
        this.stage3Access = false;
        this.stage4Access = false;
    }

    public User getGameOwner() {
        return gameOwner;
    }

    public MainBall getMainBall() {
        return mainBall;
    }

    public ArrayList<Ball> getDroppedBalls() {
        return droppedBalls;
    }

    public boolean isStage1Access() {
        return stage1Access;
    }

    public boolean isStage2Access() {
        return stage2Access;
    }

    public boolean isStage3Access() {
        return stage3Access;
    }

    public boolean isStage4Access() {
        return stage4Access;
    }
}
