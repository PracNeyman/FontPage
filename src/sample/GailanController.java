package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class GailanController implements Initializable{

    @FXML
    public JFXButton figure_mod_btn;
    @FXML
    public JFXButton list_mod_btn;
    @FXML
    public JFXButton own_info_btn;
    @FXML
    public ImageView color_picker1;
    @FXML
    public JFXDrawer drawer1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    void colorPicker(MouseEvent event) {
        if (drawer1.isShown()) {
            drawer1.close();
        } else {
            drawer1.open();
        }
    }

    @FXML
    public void figureMod(MouseEvent mouseEvent) {
    }

    @FXML
    public void listMod(MouseEvent mouseEvent) {
    }

    @FXML
    public void ownInfo(MouseEvent mouseEvent) {
    }
}
