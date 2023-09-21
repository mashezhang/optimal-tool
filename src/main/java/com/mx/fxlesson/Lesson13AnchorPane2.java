package com.mx.fxlesson;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Lesson13AnchorPane2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("button1");
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");

        AnchorPane ap1 = new AnchorPane();
        AnchorPane ap2 = new AnchorPane();

        ap2.getChildren().add(b1);
        ap2.setBottomAnchor(b1, 100.0);
        ap2.setRightAnchor(b1, 100.0);


        ap1.setStyle("-fx-background-color: #8552a1;");
        ap2.setStyle("-fx-background-color: green;");
        ap1.getChildren().add(ap2);
        Scene scene = new Scene(ap1);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("标题");
        primaryStage.show();

        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                ap1.setBottomAnchor(ap2, ap1.getHeight() / 2);
            }
        });
        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                ap1.setRightAnchor(ap2, ap1.getWidth() / 2);
            }
        });
//        ap1.setTopAnchor(ap2, 0.0);
//        ap1.setLeftAnchor(ap2, 0.0);
//        ap1.setBottomAnchor(ap2, ap1.getHeight() / 2);
//        ap1.setRightAnchor(ap2, ap1.getWidth() / 2);

        ap2.setPrefHeight(200);
        ap2.setPrefWidth(200);
    }
}
