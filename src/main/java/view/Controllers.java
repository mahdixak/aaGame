package view;

import controller.*;

public class Controllers {
    public static GameController gameController = new GameController();
    public static RegistrationAndLoginController registrationAndLoginController = new RegistrationAndLoginController();
    public static UserProfileController userProfileController = new UserProfileController();
    public static SinglePlayerController singlePlayerController = new SinglePlayerController();
    public static JsonController jsonController = new JsonController();
    public static String currentPlayer;
}
