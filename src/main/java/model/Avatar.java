package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.net.URL;

public class Avatar extends Circle {
//    private final Image avatar;
//    private final int avatarIndex;

    public Avatar(URL url) {
        super();
        this.setFill(new ImagePattern(new Image(String.valueOf(url))));
    }
}
