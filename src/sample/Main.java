package sample;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    static final int SCENE_WIDTH =1440;
    static final int SCENE_HEIGHT = 900;
    static final int NUMBER_OF_BRANCH_GENERATIONS = 6;
    private Group rootContent;
    private Group treeContent;
    private Pane backPane;

    @Override
    public void start(Stage primaryStage) throws Exception{

        JFXButton loginBtn = new JFXButton("开始");
        loginBtn.setPrefWidth(300);
        loginBtn.setPrefHeight(100);
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

//                //启动连接页面
//                primaryStage.setScene(new AppScene(primaryStage));
//                primaryStage.show();
//                new Animator(new TreeGenerator(treeContent, NUMBER_OF_BRANCH_GENERATIONS)).run();

                openFrontPage(primaryStage);


            }
        });
        HBox welcomeHBox = new HBox();

        for (int i = 0;i < 3; i++) {
            Image image = new Image(getClass().getResourceAsStream("welcome"+(i+1)+".jpg"), SCENE_WIDTH, SCENE_HEIGHT, false, true);
            ImageView imageView = new ImageView(image);
            if (i==2){
                StackPane stackPane = new StackPane();
                stackPane.getChildren().addAll(imageView, loginBtn);
                welcomeHBox.getChildren().add(stackPane);
            }
            else
                welcomeHBox.getChildren().add(imageView);
        }

        welcomeHBox.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                double deltaY = event.getDeltaY();
                System.out.println(welcomeHBox.getLayoutX());
                if (welcomeHBox.getLayoutX() ==0 || welcomeHBox.getLayoutX() == -1*SCENE_WIDTH || welcomeHBox.getLayoutX() == -2*SCENE_WIDTH)  {
                    if (deltaY > 0 && welcomeHBox.getLayoutX()!=0) {
                        welcomeHBox.setLayoutX(welcomeHBox.getLayoutX() + SCENE_WIDTH);
                    } else if (deltaY < 0 && welcomeHBox.getLayoutX()!=-2*SCENE_WIDTH){
                        welcomeHBox.setLayoutX(welcomeHBox.getLayoutX() - SCENE_WIDTH);
                    }
                }
            }
        });

        primaryStage.setScene(new Scene(welcomeHBox, SCENE_WIDTH,SCENE_HEIGHT));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    class AppScene extends Scene {

        public AppScene(Stage primaryStage) {

            super(backPane = new Pane(), SCENE_WIDTH, SCENE_HEIGHT, Color.TRANSPARENT);
            backPane.getStylesheets().add(Main.class.getResource("base.css").toExternalForm());
            rootContent = new Group();
            Pane pane = new Pane();
            pane.getChildren().add(rootContent);
            backPane.getChildren().add(pane);
            final double[] preX = new double[1];
            final double[] preY = new double[1];
            final double[] paneX = new double[1];
            final double[] paneY = new double[1];
            pane.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    preX[0] = event.getSceneX();
                    preY[0] = event.getSceneY();
                    paneX[0] = pane.getLayoutX();
                    paneY[0] = pane.getLayoutY();
                    System.out.println(preX[0]);
                    System.out.println(preY[0]);
                    System.out.println(paneX[0]);
                    System.out.println(paneY[0]);
                }
            });
            pane.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    pane.setLayoutX(paneX[0] + event.getSceneX() - preX[0]);
                    pane.setLayoutY(paneY[0] + event.getSceneY() - preY[0]);
                }
            });

            rootContent.getChildren().add(treeContent = new Group()); // tree layout
            rootContent.getTransforms().addAll(new Translate(SCENE_WIDTH / 2, SCENE_HEIGHT / 2),new Rotate(225));
            JFXButton jfxButton = new JFXButton("开始吧");
            jfxButton.setPrefWidth(300);
            jfxButton.setPrefHeight(100);
            rootContent.getChildren().add(jfxButton);
            jfxButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    openFrontPage(primaryStage);
                }
            });

        }
    }

    private static void openFrontPage(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Main.class.getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
        primaryStage.show();
    }
}
