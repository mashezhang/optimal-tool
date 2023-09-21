package com.mx.fxlesson;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lesson14HVBox extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("button1");
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");
        Button b5 = new Button("button5");
        Button b6 = new Button("button6");

        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color: #aeeeee");
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(10);// 内部节点间间距
        hbox.setMargin(b1, new Insets(10));
        hbox.setAlignment(Pos.BOTTOM_CENTER);// 对齐
        hbox.setPrefHeight(200);
        hbox.setPrefWidth(400);
        hbox.getChildren().addAll(b1, b2, b3);

        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: #7fb80e");
        vbox.setLayoutY(200);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);// 内部节点间间距
        vbox.setMargin(b4, new Insets(10));
        vbox.setAlignment(Pos.CENTER); // 对齐
        vbox.setPrefHeight(200);
        vbox.setPrefWidth(400);
        vbox.getChildren().addAll(b4, b5, b6);

        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: #ffe4c4");
        ap.getChildren().addAll(hbox, vbox);

        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("标题");
        primaryStage.show();
    }
}
