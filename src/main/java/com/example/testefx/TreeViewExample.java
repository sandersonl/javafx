package com.example.testefx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class TreeViewExample extends Application {

    Stage window;
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("TreeView Example");

        // Generic Item
        TreeItem<String> root, bucky,  megan, tereza;

        // Root main container
        root = new TreeItem<>();
        root.setExpanded(true);

        // Branch
        bucky = makeBranch("Bucky", root);
        makeBranch("son of bucky", bucky);
        makeBranch("youtube", bucky);
        makeBranch("instagram", bucky);

        tereza = makeBranch("Tereza", bucky);
        makeBranch("Tereza1", tereza);
        makeBranch("Tereza2", tereza);
        makeBranch("Tereza3", tereza);

        megan = makeBranch("Megan", root);
        makeBranch("Glitter", megan);
        makeBranch("makeup", megan);

        // Create Tree of main container root
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if( newValue != null){
                        System.out.println(newValue.getValue());
                    }
                });

        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    public TreeItem<String> makeBranch(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

}