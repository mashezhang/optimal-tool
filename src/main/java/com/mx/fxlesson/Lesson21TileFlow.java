package com.mx.fxlesson;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 * 效果同FlowPane类似 外边距效果不一样
 */
public class Lesson21TileFlow extends Application {
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
        Button b7 = new Button("button7");
        Button b8 = new Button("button8");


        TilePane tp = new TilePane();
        tp.setStyle("-fx-background-color: #ff1");
        tp.getChildren().addAll(b1, b2, b3, b4, b5, b6, b7, b8);
        tp.setHgap(10);
        tp.setVgap(10);
        tp.setPadding(new Insets(10));
        tp.setMargin(b1,new Insets(50));

        Scene scene = new Scene(tp);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
