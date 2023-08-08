module com.example.prova {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.prova to javafx.fxml;
    exports com.example.prova;
}