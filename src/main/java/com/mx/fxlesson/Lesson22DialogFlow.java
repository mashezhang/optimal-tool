package com.mx.fxlesson;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Lesson22DialogFlow extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("show dialog");
        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: #ddd");
        ap.getChildren().add(b1);
        ap.setTopAnchor(b1,100.0);
        ap.setLeftAnchor(b1,100.0);

        b1.setOnMouseClicked(e->{
            Stage stage = new Stage();
            stage.setTitle("弹出框口");
            DialogPane dp = new DialogPane();
            stage.setScene(new Scene(dp));
            dp.setHeaderText("header text");
            dp.setContentText("content text");
            dp.getButtonTypes().addAll(ButtonType.APPLY,ButtonType.CLOSE);
            Button apply = (Button)dp.lookupButton(ButtonType.APPLY);
            Button close = (Button)dp.lookupButton(ButtonType.CLOSE);
            apply.setOnMouseClicked(ae->{
                System.out.println("aaaa");
            });
            close.setOnMouseClicked(ce->{
                System.out.println("cccc");
            });


            stage.initOwner(primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.setResizable(false);

            stage.show();
        });


        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
