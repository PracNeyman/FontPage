package sample;

import com.jfoenix.controls.JFXDrawer;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    public HBox top_hbox;
    @FXML
    public Pane center_pane;
    @FXML
    public Pane left_pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        double bianchang = 100;
        TopBtn gailan = new TopBtn(bianchang, "1.png");
        TopBtn selectFunc = new TopBtn(bianchang, "2.png");
        TopBtn manageData = new TopBtn(bianchang, "3.png");
        TopBtn personalInfo = new TopBtn(bianchang, "4.png");

        top_hbox.getChildren().addAll(gailan, selectFunc, manageData, personalInfo);
        top_hbox.setStyle("-fx-background-color: aquamarine");

        try {
            left_pane.getChildren().clear();
            Parent root = FXMLLoader.load(getClass().getResource("gailan.fxml"));
            left_pane.getChildren().addAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

        gailan.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    left_pane.getChildren().clear();
                    Parent root = FXMLLoader.load(getClass().getResource("gailan.fxml"));
                    left_pane.getChildren().addAll(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        selectFunc.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    left_pane.getChildren().clear();
                    Parent root = FXMLLoader.load(getClass().getResource("gongneng.fxml"));
                    left_pane.getChildren().addAll(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}


