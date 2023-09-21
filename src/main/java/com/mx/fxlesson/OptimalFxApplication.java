package com.mx.fxlesson;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class OptimalFxApplication extends Application {
    String groupDataReg = "(([1-9][0-9]*)+(.[0-9]+)?[,，]?)+";
    String dataReg = "(([1-9][0-9]*)+(.[0-9]+)?)+";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField group1 = new TextField();
        TextField group2 = new TextField();
        TextField target = new TextField();
        VBox res = new VBox();

        group1.setPromptText("输入数据组（逗号隔开）");
        group2.setPromptText("输入数据组（逗号隔开）");
        target.setPromptText("输入预值");
        group1.setPrefWidth(300);
        group2.setPrefWidth(300);
        target.setPrefWidth(80);
        Button be = getButton(group1, group2, target,res);

        HBox arg = new HBox();
        arg.setSpacing(10);
        arg.setPadding(new Insets(10));
        arg.getChildren().addAll(group1, group2, target, be);

        FlowPane fp = new FlowPane();
        fp.getChildren().addAll(arg, res);
        primaryStage.setTitle("");
        primaryStage.setWidth(800);
        primaryStage.setHeight(700);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(fp));
        primaryStage.show();
    }

    private Button getButton(TextField group1, TextField group2, TextField target,VBox res) {
        Button be = new Button("预算");
        be.setCursor(Cursor.HAND);
        be.setOnMouseClicked(e -> {
            String groupData1 = getTextString(group1);
            String groupData2 = getTextString(group2);
            String targetData = getTextString(target);

            boolean isMatch1 = groupData1.matches(groupDataReg);
            boolean isMatch2 = groupData2.matches(groupDataReg);
            boolean isMatch3 = targetData.matches(dataReg);
            if (!isMatch1 || !isMatch2) {
                System.out.println("错误数据");
                return;
            }
            if (!isMatch3) {
                System.out.println("错误数据");
                return;
            }
            Object[] gd1 = split(groupData1);
            Object[] gd2 = split(groupData2);
            OptimalCount.DataDto params = new OptimalCount.DataDto(BigDecimal.valueOf(Double.valueOf(targetData)), gd1, gd2);
            List<OptimalCount.DataVo>  dataVos = new OptimalCount().optimalCount(params);
            TextArea ta = new TextArea();
            ta.setPrefHeight(600);
            ta.setText(dataVos.stream().map(item->item.toString()).collect(Collectors.joining("\n")));
            res.getChildren().add(ta);
        });
        return be;
    }

    public String getTextString(TextField group) {
        String groupData = group.getText();
        return groupData == null ? "" : groupData;
    }

    public Object[] split(String data) {
        String[] data1 = data.split(",");
        return Arrays.stream(data1).map(s -> s.split("，")).flatMap(Arrays::stream).collect(Collectors.toList()).toArray();
    }
}
