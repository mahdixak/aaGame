package view;

import controller.GameSettingsController;
import controller.RegistrationAndLoginController;
import controller.SinglePlayerController;
import controller.UserProfileController;

public class Controllers {
    public static RegistrationAndLoginController registrationAndLoginController = new RegistrationAndLoginController();
    public static UserProfileController userProfileController = new UserProfileController();
    public static SinglePlayerController singlePlayerController = new SinglePlayerController();
    public static GameSettingsController gameSettingsController = new GameSettingsController();
}
