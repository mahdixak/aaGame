package model;

import java.net.URL;
import java.util.ArrayList;

public enum Avatar {
    avatar1(Avatar.class.getResource("/images/avatars/avatar1.png").toExternalForm()),
    avatar2(Avatar.class.getResource("/images/avatars/avatar2.png").toExternalForm()),
    avatar3(Avatar.class.getResource("/images/avatars/avatar3.png").toExternalForm()),
    avatar4(Avatar.class.getResource("/images/avatars/avatar4.png").toExternalForm()),
    avatar5(Avatar.class.getResource("/images/avatars/avatar5.png").toExternalForm()),
    avatar6(Avatar.class.getResource("/images/avatars/avatar6.png").toExternalForm()),
    avatar7(Avatar.class.getResource("/images/avatars/avatar7.png").toExternalForm()),
    avatar8(Avatar.class.getResource("/images/avatars/avatar8.png").toExternalForm()),
    avatar9(Avatar.class.getResource("/images/avatars/avatar9.png").toExternalForm()),
    avatar10(Avatar.class.getResource("/images/avatars/avatar10.png").toExternalForm()),
    avatar11(Avatar.class.getResource("/images/avatars/avatar11.png").toExternalForm()),
    avatar12(Avatar.class.getResource("/images/avatars/avatar12.png").toExternalForm()),
    uploadedAvatar(Avatar.class.getResource("").toExternalForm()),
    ;

    private String avatarUrl;

    public static void setUserAvatar(User user, String avatar) {
        for (Avatar temp:Avatar.getAllAvatars()) {
            if (temp.getAvatarUrl().equals(avatar)) {
                user.setAvatar(temp);
                return;
            }
        }
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    private static ArrayList<Avatar> getAllAvatars() {
        ArrayList<Avatar> allAvatars = new ArrayList<>();
        allAvatars.add(avatar1);
        allAvatars.add(avatar2);
        allAvatars.add(avatar3);
        allAvatars.add(avatar4);
        allAvatars.add(avatar5);
        allAvatars.add(avatar6);
        allAvatars.add(avatar7);
        allAvatars.add(avatar8);
        allAvatars.add(avatar9);
        allAvatars.add(avatar10);
        allAvatars.add(avatar11);
        allAvatars.add(avatar12);
        return allAvatars;
    }

    Avatar(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setUploadedAvatar(String address) {
        Avatar.uploadedAvatar.setAvatarUrl(address);
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
