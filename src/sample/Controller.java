package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXTabPane;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.NUMBER_OF_BRANCH_GENERATIONS;
import static sample.Main.SCENE_HEIGHT;
import static sample.Main.SCENE_WIDTH;

public class Controller implements Initializable{

    @FXML
    public JFXTabPane total_center_pane;
    @FXML
    public Tab gailan_tab;
    @FXML
    public Tab func_tab;
    @FXML
    public Tab manage_data_tab;
    @FXML
    public Tab personal_info_tab;

    private static double TAB_SIZE = 80;
    public static boolean isOnline = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        total_center_pane.setPadding(new Insets(30,50,30,50));
        total_center_pane.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, null,new BorderWidths(3))));
        
        gailan_tab.setGraphic(new ImageView(new Image(Main.class.getResourceAsStream("1.png"), TAB_SIZE, TAB_SIZE, false, true)));
        func_tab.setGraphic(new ImageView(new Image(Main.class.getResourceAsStream("2.png"), TAB_SIZE, TAB_SIZE, false, true)));
        manage_data_tab.setGraphic(new ImageView(new Image(Main.class.getResourceAsStream("3.png"), TAB_SIZE, TAB_SIZE, false, true)));
        personal_info_tab.setGraphic(new ImageView(new Image(Main.class.getResourceAsStream("4.png"), TAB_SIZE, TAB_SIZE, false, true)));

        selectGailan();

        Pane func_pane = new Pane();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("gongneng.fxml"));
            func_pane.getChildren().addAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        func_tab.setContent(func_pane);

//
//        double bianchang = 100;
//        TopBtn gailan = new TopBtn(bianchang, "1.png");
//        TopBtn selectFunc = new TopBtn(bianchang, "2.png");
//        TopBtn manageData = new TopBtn(bianchang, "3.png");
//        TopBtn personalInfo = new TopBtn(bianchang, "4.png");
//
//        top_hbox.getChildren().addAll(gailan, selectFunc, manageData, personalInfo);
//        top_hbox.setStyle("-fx-background-color: aquamarine");
//
//        try {
//            left_pane.getChildren().clear();
//            Parent root = FXMLLoader.load(getClass().getResource("gailan.fxml"));
//            left_pane.getChildren().addAll(root);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        gailan.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                try {
//                    left_pane.getChildren().clear();
//                    Parent root = FXMLLoader.load(getClass().getResource("gailan.fxml"));
//                    left_pane.getChildren().addAll(root);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        selectFunc.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                try {
//                    left_pane.getChildren().clear();
//                    Parent root = FXMLLoader.load(getClass().getResource("gongneng.fxml"));
//                    left_pane.getChildren().addAll(root);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

    }

    private void selectGailan() {
        if(!isOnline) {
            gailan_tab.setContent(loginAni());
            isOnline = true;
        }
        else {
            Pane gailan_pane = new Pane();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("gailan.fxml"));
                gailan_pane.getChildren().addAll(root);

            } catch (IOException e) {
                e.printStackTrace();
            }
            gailan_tab.setContent(gailan_pane);
        }
    }

    private Pane loginAni() {
        Group rootContent = new Group();
        Group treeContent = new Group();
        rootContent.getChildren().add(treeContent = new Group()); // tree layout
        rootContent.getTransforms().addAll(new Translate(SCENE_WIDTH / 2, SCENE_HEIGHT *2/5),new Rotate(225));
        JFXButton startBtn = new JFXButton("start");
        startBtn.setLayoutX(SCENE_WIDTH / 2);
        startBtn.setLayoutY(SCENE_HEIGHT *2/5);

        Animator animator = new Animator(new TreeGenerator(treeContent, NUMBER_OF_BRANCH_GENERATIONS), startBtn);
        animator.run();

        startBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                selectGailan();
            }
        });

        Pane pane = new Pane();
        pane.getChildren().add(rootContent);
        pane.getChildren().add(startBtn);
        return  pane;
    }

}


