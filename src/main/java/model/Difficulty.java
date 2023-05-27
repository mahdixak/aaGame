package model;

public enum Difficulty {
    EASY("easy",1, 8, 7, 20,  1.2,5),
    MEDIUM("medium",2, 12, 5, 40,  1.5,10),
    HARD("hard",3, 16, 3, 60,  1.8,15);

    ;
    private final String difficulty;
    private final int difficultyIndex;
    private final int highScoreForEachShoot;
    private final int friezeTime;
    private final int numberOfBalls;
    private final double windSpeed;
    private final int spinSpeed;


    Difficulty(String difficulty, int difficultyIndex, int highScoreForEachShoot, int friezeTime, int numberOfBalls, double windSpeed, int spinSpeed) {
        this.difficulty = difficulty;
        this.difficultyIndex = difficultyIndex;
        this.highScoreForEachShoot = highScoreForEachShoot;
        this.friezeTime = friezeTime;
        this.numberOfBalls = numberOfBalls;
        this.windSpeed = windSpeed;
        this.spinSpeed = spinSpeed;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getDifficultyIndex() {
        return difficultyIndex;
    }
    public static void setUserDifficulty(User user,int difficultyIndex) {
        if (difficultyIndex == 1) {
            user.setDifficulty(Difficulty.EASY);
        } else if (difficultyIndex == 2) {
            user.setDifficulty(Difficulty.MEDIUM);
        } else if (difficultyIndex == 3){
            user.setDifficulty(Difficulty.HARD);
        }
    }
    public static void setUserDifficulty(User user,String difficulty) {
        if (difficulty.equals("easy")) {
            user.setDifficulty(Difficulty.EASY);
        } else if (difficulty.equals("medium")) {
            user.setDifficulty(Difficulty.MEDIUM);
        } else if (difficulty.equals("hard")){
            user.setDifficulty(Difficulty.HARD);
        }
    }

    public int getHighScoreForEachShoot() {
        return highScoreForEachShoot;
    }

    public int getFriezeTime() {
        return friezeTime;
    }

    public int getNumberOfBalls() {
        return numberOfBalls;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public int getSpinSpeed() {
        return spinSpeed;
    }

    public static int findBallsWithDifficulty(String difficulty) {
        if (difficulty.equals("easy")) {
            return EASY.getNumberOfBalls();
        } else if (difficulty.equals("medium")) {
            return MEDIUM.getNumberOfBalls();
        } else if (difficulty.equals("hard")){
            return HARD.getNumberOfBalls();
        }
        return 0;
    }

}
