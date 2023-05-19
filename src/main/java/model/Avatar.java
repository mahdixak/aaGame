package model;

import javafx.scene.image.Image;
import javafx.scene.shape.Circle;

public class Avatar extends Circle {
    private final Image avatar;
//    private final int avatarIndex;

    public Avatar(double v, Image avatar) {
        super(v);
        this.avatar = avatar;

    }
}
