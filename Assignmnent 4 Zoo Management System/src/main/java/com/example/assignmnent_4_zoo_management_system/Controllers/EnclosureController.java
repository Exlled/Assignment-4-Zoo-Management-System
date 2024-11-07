package com.example.assignmnent_4_zoo_management_system.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


public class EnclosureController {
    @FXML
    Label enclosureTItleLabel;
    @FXML
    ListView<String> enclosureListView;
    @FXML
    Button addbutton;
    @FXML
    Button saveButton;
    @FXML
    Button deleteButton;

    @FXML
    protected void initialize() {
      //  enclosureListView.setItems();
    }
}
