module com.example.testefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testefx to javafx.fxml;
    exports com.example.testefx;
}