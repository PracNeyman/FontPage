package sample;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class TopBtn extends Rectangle {
    public TopBtn(double bianchang, String picName) {
        this.setWidth(bianchang);
        this.setHeight(bianchang);
        this.setFill(new ImagePattern(new Image(Main.class.getResourceAsStream(picName))));
    }
}
