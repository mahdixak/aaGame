package view.enums.status;

public enum RegisterationAndLoginStatus {
    INVALID_USERNAME_FORMAT("your username format is not valid!"),
    USERNAME_EXISTS("this username is already used by another user!"),
    EMPTY_USERNAME_FIELD("you most fill the username field!"),
    USERNAME_CHECKED_SUCCESSFULLY("username checked successfully!"),
    INVALID_PASSWORD_FORMAT("your password format is not valid!"),
    EMPTY_PASSWORD_FIELD("you most fill the password field!"),
    PASSWORD_CHECKED_SUCCESSFULLY("password checked successfully!"),
    INVALID_PASSWORD_NO_DIGITS("your password most contain digit(s)!"),
    INVALID_PASSWORD_T0O_SHORT("your password is too short!"),
    USER_CREATED_SUCCESSFULLY("user created successfully!");

    private final String status;

    RegisterationAndLoginStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
