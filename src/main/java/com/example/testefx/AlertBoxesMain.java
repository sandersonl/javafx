package com.example.testefx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlertBoxesMain extends Application {

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        // Uso do alertBox e confirm box com switchscene
        window = primaryStage;
        window.setTitle("Title here");

        Button button1 = new Button("go to scene 2");
        Button button2 = new Button("go back scene 1");

        button1.setOnAction(e -> {
            boolean result = ConfirmBox.display("Title of window", "Are you sure you want next window?");
            if(result){
                window.setScene(scene2);
            }
        });

        button2.setOnAction(e -> window.setScene(scene1));

        VBox layout2 = new VBox(40);
        layout2.getChildren().add(button2);
        layout2.setAlignment(Pos.CENTER);
        scene2 = new Scene(layout2, 300, 200);

        StackPane layout = new StackPane();
        layout.getChildren().add(button1);
        scene1 = new Scene(layout, 300, 200);
        window.setScene(scene1);
        window.show();
    }
}
