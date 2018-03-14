package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXListView;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.ResourceBundle;

public class GailanController implements Initializable{

    @FXML
    public ImageView color_picker1;
    @FXML
    public JFXDrawer drawer1;
    @FXML
    public Pane network_pane;
    @FXML
    public JFXListView selectedData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList("黑龙江中医药","哈医大一附院","哈工大校医院","哈医大二附院");
        selectedData.setItems(list);

        selectedData.setCellFactory(tv -> new PicCell());

    }

    @FXML
    void colorPicker(MouseEvent event) {
        if (drawer1.isShown()) {
            drawer1.close();
        } else {
            drawer1.open();
        }
    }

}
class PicCell extends ListCell<String> {
    @Override
    protected void updateItem(String item, boolean empty){
        super.updateItem(item, empty);
        if (!empty) {
            Circle circle = new Circle(20);
            circle.setFill(new ImagePattern(new Image(Main.class.getResourceAsStream(item+".jpg"))));
            setGraphic(circle);
            setText(item);
        }else{
            setGraphic(null);
        }
    }
}