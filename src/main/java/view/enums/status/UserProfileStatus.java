package view.enums.status;

public enum UserProfileStatus {
    ACCOUNT_DELETED_SUCCESSFULLY(""),
    INCORRECT_PASSWORD("your password is incorrect!"),
    DUPLICATE_NEW_USERNAME("your new username is equal to your current username!"),
    USERNAME_EXISTS("another account with this username exists!"),
    NEW_USERNAME_FIELD_IS_EMPTY("you most fill the new username field!"),
    PASSWORD_FIELD_IS_EMPTY("you most fill the password field!"),
    ALL_ELEMENTS_ARE_VALID("all fields completed successfully"),
    USERNAME_FIELD_IS_EMPTY("you most fill the username field!"),
    NEW_PASSWORD_FIELD_IS_EMPTY("you most fill the new password field!"),
    INVALID_USERNAME("user with this username not found!"),
    NEW_PASSWORD_AND_CURRENT_PASSWORD_ARE_EQUAL("your new password is equal to your current password!");
    private final String status;

    UserProfileStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
