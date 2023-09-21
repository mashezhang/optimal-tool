package com.mx.fxlesson;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Lesson17FlowPane extends Application {
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

        FlowPane fp = new FlowPane();
        fp.setStyle("-fx-background-color: pink");
        fp.getChildren().addAll(b1,b2,b3,b4,b5,b6,b7,b8);
        fp.setHgap(10); // 行内边距
        fp.setVgap(10); // 列内边距
        fp.setPadding(new Insets(10));
        fp.setMargin(b1 ,new Insets(50));
//        fp.setAlignment(Pos.CENTER);
//        fp.setOrientation(Orientation.VERTICAL);

        Scene scene = new Scene(fp);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
