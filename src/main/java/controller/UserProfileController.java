package controller;

import model.User;
import view.enums.status.UserProfileStatus;

public class UserProfileController {


    public UserProfileStatus deletingAccountCheck(String username,String password) {
        User user = User.findUserWithUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                deleteAccount(user);
                return UserProfileStatus.ACCOUNT_DELETED_SUCCESSFULLY;
            }
            return UserProfileStatus.INCORRECT_PASSWORD;
        }
        return UserProfileStatus.USERNAME_DOES_NOT_EXISTS;
    }

    private void deleteAccount(User user) {
        User deletedUser = User.findUserWithUsername(user.getUsername());
        deletedUser.setUsername("");
        deletedUser.setPassword("");
        User.allUsers().remove(deletedUser);
    }
}
