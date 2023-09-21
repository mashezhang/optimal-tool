package com.mx.fxlesson;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Lesson13AnchorPane extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("button1");
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");

        Group g1 = new Group();
        Group g2 = new Group();
        g1.getChildren().addAll(b1, b2);
        g2.getChildren().addAll(b3, b4);
        b2.setLayoutX(100);
        b4.setLayoutX(100);


        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: #8552a1;");
//        ap.setTopAnchor(b1,10.0);
//        ap.setLeftAnchor(b1,10.0);
//        ap.setRightAnchor(b1,10.0);
//        ap.setBottomAnchor(b1,10.0);
//        ap.setPadding(new Insets(10));
//        ap.getChildren().addAll(b1);
        ap.getChildren().addAll(g1, g2);
        ap.setTopAnchor(g1, 0.0);
        ap.setTopAnchor(g2, 100.0);
//        ap.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                System.out.println("asd");
//            }
//        });

        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("标题");
        primaryStage.show();
    }
}
