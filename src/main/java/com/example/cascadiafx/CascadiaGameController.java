package com.example.cascadiafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CascadiaGameController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}