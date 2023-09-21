package com.mx.fxlesson;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lesson15Style extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("button1");
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");

        Button b5 = new Button(" b3.setManaged(false)");
        Button b6 = new Button("b3.setVisible(false)");
        Button b7 = new Button("b3.setOpacity(0)");
        b5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                b3.setManaged(mouseEvent.getClickCount() == 2);
            }
        });
        b6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                b3.setVisible(mouseEvent.getClickCount() == 2);
            }
        });
        b7.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                b3.setOpacity(mouseEvent.getClickCount()>10?1:0.1*mouseEvent.getClickCount());
            }
        });


        HBox hbox = new HBox();
        VBox vbox = new VBox();
        VBox layoutBox = new VBox();
        hbox.getChildren().addAll(b1, b2, b3, b4);
        vbox.getChildren().addAll(b5, b6, b7);
        layoutBox.getChildren().addAll(hbox, vbox);

        AnchorPane ap = new AnchorPane();
        ap.getChildren().add(layoutBox);
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("标题");
        primaryStage.show();
    }
}
