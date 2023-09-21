package com.mx.fxlesson;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class Lesson12TextFiled extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TextField text = new TextField();
        text.setLayoutX(100);
        text.setLayoutY(100);
        text.setPrefHeight(24);
        text.setPrefWidth(200);

        Tooltip tip = new Tooltip("提示");
        text.setTooltip(tip);
        text.setPromptText("输入7字以下");// 无默认值时生效
        text.setFocusTraversable(false);
        // 输入字
        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("输入的字符:"+newValue);
                if(newValue!= null && newValue.length()>7){
                    text.setText(oldValue);
                }
            }
        });
        // 选择字
        text.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("选择的字符:"+newValue);
            }
        });
        // 鼠标单机事件
//        text.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                System.out.println("asd");
//            }
//        });
        text.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getClickCount());
            }
        });
        // --------------------
        // 密码输入(同文本输入)
        PasswordField ptext = new PasswordField();
        ptext.setLayoutX(400);
        ptext.setLayoutY(100);
        ptext.setPrefHeight(24);
        ptext.setPrefWidth(200);
        ptext.setPromptText("输入密码");
        ptext.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });
        // -------------------
        // 标签
        Label label = new Label();
        label.setLayoutX(0);
        label.setLayoutY(100);
        label.setText("输入文本：");
        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(MouseButton.PRIMARY.name().equals(event.getButton().name()) && event.getClickCount() ==2 ){
                    System.out.println("鼠标左键双击");
                }
            }
        });

        // -------------------
        Group root = new Group();
        // 文本
        root.getChildren().add(text);
        // 密码
        root.getChildren().add(ptext);
        // 标签
        root.getChildren().add(label);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("标题");
        primaryStage.show();
    }
}
