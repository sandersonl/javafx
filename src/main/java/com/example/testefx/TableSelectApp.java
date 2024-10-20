package com.example.testefx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.example.testefx.Item;

public class TableSelectApp extends Application {

    TableView<Item> tblItems = new TableView<>();

    public void start(Stage stage) throws Exception {

        // Definir as colunas
        TableColumn<Item, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Item, String> colModelo = new TableColumn<>("Modelo");
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        TableColumn<Item, Float> colSerie = new TableColumn<>("Serie");
        colSerie.setCellValueFactory(new PropertyValueFactory<>("serie"));

        // Adicionar as colunas à tabela
        tblItems.getColumns().addAll(colNome, colModelo, colSerie);

        // Dados de exemplo
        ObservableList<Item> items = FXCollections.observableArrayList(
                new Item("Item1", "Modelo1", 12345.0f),
                new Item("Item2", "Modelo2", 67890.0f)
        );
        tblItems.setItems(items);

        // Layout
        VBox vbox = new VBox(tblItems);
        Scene scene = new Scene(vbox);

        // Configuração da janela
        stage.setScene(scene);
        stage.setTitle("TableView Example");
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

}
