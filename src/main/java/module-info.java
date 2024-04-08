module com.example.cascadiafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cascadiafx to javafx.fxml;
    exports com.example.cascadiafx;
}