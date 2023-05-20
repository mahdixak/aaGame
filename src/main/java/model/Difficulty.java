package model;

public enum Difficulty {
    EASY("easy",1),
    MEDIUM("medium",2),
    HARD("hard",3);

    ;
    private final String difficulty;
    private final int difficultyIndex;

    Difficulty(String difficulty, int difficultyIndex) {
        this.difficulty = difficulty;
        this.difficultyIndex = difficultyIndex;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getDifficultyIndex() {
        return difficultyIndex;
    }
    public void setUserDifficulty(User user,int difficultyIndex) {
        if (difficultyIndex == 1) {
            user.setDifficulty(Difficulty.EASY);
        } else if (difficultyIndex == 2) {
            user.setDifficulty(Difficulty.MEDIUM);
        } else if (difficultyIndex == 3){
            user.setDifficulty(Difficulty.HARD);
        }
    }
}
