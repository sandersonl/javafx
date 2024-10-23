package com.example.testefx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MenuExample extends Application {

    Stage window;
    BorderPane layout;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        window.setTitle("Menu Example");

        Menu fileMenu = new Menu("_File");

        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(e -> System.out.println("Created"));
        fileMenu.getItems().add(newFile);

        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit..."));

        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));

        MenuItem paste = new MenuItem("Paste");
        paste.setDisable(true);
        editMenu.getItems().add(paste);

        Menu helpMenu = new Menu("Help");
        CheckMenuItem showLine = new CheckMenuItem("Show Line Numbers");
        CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
        autoSave.setSelected(true);

        showLine.setOnAction(e -> {
            if (showLine.isSelected())
                System.out.println("Program will now display line numbers");
            else
                System.out.println("Hiding line number");
        });
        helpMenu.getItems().addAll(showLine, autoSave);


        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }
}
