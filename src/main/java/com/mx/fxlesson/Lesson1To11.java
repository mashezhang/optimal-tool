package com.mx.fxlesson;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Lesson1To11 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    /**
     * stage>scene>node
     * 1、stage 窗口大小property 标题title 置顶OnTop 模式Style 模态Modality
     * 2、node 位置Layout 缩放Pref 样式Style 事件Event 监听器Listener
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");

        Group root = new Group();
        ObservableList<Node> nodes = root.getChildren();
        nodes.addAll(b1, b2, b3);
        nodes.addListener((ListChangeListener<Node>) c -> {
            System.out.println(c.getList().size());
        });
        AtomicInteger index = new AtomicInteger(0);
        nodes.forEach(i -> {
            ((Button) i).setPrefWidth(100);
            ((Button) i).setPrefHeight(50);
            ((Button) i).setLayoutY(index.getAndIncrement() * 100);
        });

        AtomicInteger bi = new AtomicInteger(0);
        b1.setOnAction((e) -> {
            // 节点点击事件
            Button b = new Button("bb" + bi.get());
            b.setPrefWidth(100);
            b.setPrefHeight(50);
            b.setLayoutX(100);
            b.setLayoutY(bi.getAndIncrement() * 10);
            nodes.add(b);
        });

        b2.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            // 监听鼠标点击事件
            if (Objects.equals(MouseButton.PRIMARY.name(), e.getButton().name())) {
                switch (e.getClickCount()) {
                    case 1:
                        break;
                    case 2:
                        System.out.println("点击 " + e.getClickCount());
                        break;
                    default:

                }
            }
        });

        b3.setOnKeyPressed(e -> {
            // 键盘事件
            System.out.println(e.getText());
        });

        Scene scene = new Scene(root);
        // Scene上绑定快捷键1 灵活非节点绑定
        KeyCombination kc1 = new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN);
        scene.getAccelerators().put(kc1, Lesson1To11::play);
        // Scene上绑定快捷键2 与节点点击事件绑定
        KeyCombination kc2 = new KeyCodeCombination(KeyCode.A, KeyCombination.ALT_DOWN, KeyCombination.SHORTCUT_DOWN);
        Mnemonic m = new Mnemonic(b1, kc2);
        scene.addMnemonic(m);

        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void play() {
        System.out.println("执行");
    }
}
