package com.mx.fxlesson;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Lesson16BorderPane extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane pane1 = new AnchorPane();
        AnchorPane pane2 = new AnchorPane();
        AnchorPane pane3 = new AnchorPane();
        AnchorPane pane4 = new AnchorPane();
        AnchorPane pane5 = new AnchorPane();
        pane1.setStyle("-fx-background-color: #fffffb");
        pane2.setStyle("-fx-background-color: #fedcbd");
        pane3.setStyle("-fx-background-color: #afb4db");
        pane4.setStyle("-fx-background-color: #009ad6");
        pane5.setStyle("-fx-background-color: #50b7c1");
//        pane1.setPrefHeight(100);
//        pane2.setPrefWidth(100);
//        pane4.setPrefWidth(100);
//        pane5.setPrefHeight(100);

        BorderPane bp = new BorderPane();
        bp.setStyle("-fx-background-color: pink");
        bp.setTop(pane1);
        bp.setLeft(pane2);
        bp.setCenter(pane3);
        bp.setRight(pane4);
        bp.setBottom(pane5);
        Scene scene = new Scene(bp);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("标题");
        primaryStage.show();
    }
}
