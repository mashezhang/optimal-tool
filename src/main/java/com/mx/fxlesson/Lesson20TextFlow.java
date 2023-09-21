package com.mx.fxlesson;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Lesson20TextFlow extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text t1 = new Text("大风起兮云飞扬，安得猛士兮守四方");
        Text t2 = new Text("卧龙凤雏");
        Text t3 = new Text("blbl");

        t1.setFont(Font.font(20));
        t2.setFill(Paint.valueOf("#f47920")); // 字体色
        t3.setFont(Font.font("Helvetica", FontPosture.ITALIC, 30));

        TextFlow txp1 = new TextFlow();
        TextFlow txp2 = new TextFlow();
        txp1.setStyle("-fx-background-color: pink");
        txp2.setStyle("-fx-background-color: rgb(128,128,128)");
        txp1.setPadding(new Insets(10)); // 内边距
        txp2.setPadding(new Insets(10));
        txp1.setTextAlignment(TextAlignment.CENTER); // 对齐
        txp2.setTextAlignment(TextAlignment.CENTER);
        txp1.setLineSpacing(20); // 行间距
        txp2.setLineSpacing(20);
        txp1.getChildren().addAll(t1, t2);
        txp2.getChildren().addAll(t3);
        txp1.setEffect(new GaussianBlur());// 特效：高斯模糊

        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: #ff1");
        ap.setTopAnchor(txp2, 100.0);
        ap.setLeftAnchor(txp2, 100.0);
        ap.getChildren().addAll(txp1, txp2);
        ap.widthProperty().addListener((observableValue, number, t11) -> {
            txp2.setPrefWidth(t11.doubleValue()-100); // 绝对布局左
        });

        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
