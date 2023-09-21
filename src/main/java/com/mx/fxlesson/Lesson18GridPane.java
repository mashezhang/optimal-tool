package com.mx.fxlesson;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Lesson18GridPane extends Application {
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

        GridPane gp = new GridPane();
        gp.setStyle("-fx-background-color: pink");
        // add(node,columnIndex,rowIndex)
        gp.add(b1,0,0);
//        gp.add(b2,1,0);
        gp.add(b3,2,0);
        gp.add(b4,3,0);
        gp.add(b5,0,1);
        gp.add(b6,1,1);
        gp.add(b7,2,2);
        gp.add(b8,3,4);

//        gp.setConstraints(b2,1,0);
//        gp.getChildren().add(b2);

        gp.setColumnIndex(b2,1);
        gp.setRowIndex(b2,0);
        gp.getChildren().add(b2);

//        gp.setPadding(new Insets(10));
//        gp.setMargin(b1,new Insets(10));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        ColumnConstraints cw = new ColumnConstraints(100);
        gp.getColumnConstraints().addAll(cw,cw,cw,cw);// 设置单元格列宽
        gp.getRowConstraints().add(new RowConstraints(50));// 设置1行的单元格宽
        gp.getRowConstraints().add(new RowConstraints(100));// 设置2行的单元格宽

        Scene scene = new Scene(gp);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
