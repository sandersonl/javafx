package com.example.testefx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TableViewExample extends Application {

    Stage window;
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start (Stage primarystage) throws Exception {
        window = primarystage;
        window.setTitle("TableView Example");

        // setup columns
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(200);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // config inputs
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        priceInput = new TextField();
        priceInput.setPromptText("Price");

        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");

        Button  addButton = new Button("Add");
        addButton.setOnAction( e -> addButtonClicked());

        Button  deleteButton = new Button("Delete");
        deleteButton.setOnAction( e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets( 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

        // A table needs an observable list to show items
        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public void addButtonClicked(){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    public void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();
        productSelected.forEach(allProducts::remove);
    }

    // Get all the products
    public ObservableList<Product> getProduct() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.00, 20));
        products.add(new Product("BoomBox", 589.00, 40));
        products.add(new Product("DvD", 120.00, 13));
        products.add(new Product("Corn", 13.00, 37));
        products.add(new Product("Bouncy ball", 99.00, 12));
        return products;
    }

}
