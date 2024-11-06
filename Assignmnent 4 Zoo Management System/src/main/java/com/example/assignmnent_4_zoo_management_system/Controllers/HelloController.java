package com.example.assignmnent_4_zoo_management_system.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label aTitleLabel;
    @FXML
    private Button backButton;
    @FXML
    private Button viewButton;
    @FXML
    private ListView<String> compositeAnimalListView;

    @FXML
    protected void onBackButtonClick() {
        Stage stage = (Stage) aTitleLabel.getScene().getWindow();
        stage.close();

    }
}