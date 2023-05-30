package model;

public enum Themes {
    Dark(GameStage.class.getResource("/CSS/darkTheme.css").toExternalForm()),
    Light(GameStage.class.getResource("/CSS/lightTheme.css").toExternalForm()),
    ;

    private final String theme;

    Themes(String theme) {
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }
}
