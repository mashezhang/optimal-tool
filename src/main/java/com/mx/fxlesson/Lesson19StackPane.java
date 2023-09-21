package com.mx.fxlesson;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class Lesson19StackPane extends Application {
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

        StackPane sp = new StackPane();
        sp.setStyle("-fx-background-color: pink");
        sp.getChildren().addAll(b1,b2,b3,b4,b5);
        sp.setAlignment(Pos.TOP_LEFT);
        sp.setPadding(new Insets(10));
        sp.setMargin(b1,new Insets(10));

        sp.getChildren().forEach(node -> {
            Button b = (Button) node;
            node.setOnMouseClicked(mouseEvent -> b.setVisible(false));
        });

        Scene scene = new Scene(sp);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
