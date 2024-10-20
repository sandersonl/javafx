package com.example.testefx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CheckBoxExample extends Application {

    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        window.setTitle("CheckBox Example");

        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Tuna");
        box2.setSelected(true);

        button = new Button("Order now");
        button.setOnAction(e -> handleOptions(box1, box2));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(box1, box2, button);


        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(CheckBox box1, CheckBox box2){
        StringBuilder message = new StringBuilder("Users orders:\n");

        if(box1.isSelected()){
            message.append("Bacon\n");
        }

        if(box2.isSelected()){
            message.append("Tuna\n");
        }

        if(!box1.isSelected() && !box2.isSelected()){
            message.append("User not selected none\n");
        }

        System.out.println(message);
    }
}