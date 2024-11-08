package com.example.assignmnent_4_zoo_management_system.Controllers;

import com.example.assignmnent_4_zoo_management_system.Model.BigCat;
import com.example.assignmnent_4_zoo_management_system.Model.Enclosure;
import com.example.assignmnent_4_zoo_management_system.Model.Lion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AnimalController {
    @FXML
    Button addButton;
    @FXML
    Button deleteButton;
    @FXML
    Button editButton;
    @FXML
    Button saveButton;
    @FXML
    Button backButton;
    @FXML
    Label titleLabel;
    @FXML
    ListView<Lion> listViewForAnimals;

    //actions for back button
    @FXML
    protected void onBackButtonClick() {

    }
    @FXML
    protected void onAddButtonClick() {

    }
    @FXML
    protected void onDeleteButtonClick() {

    }
    @FXML
    protected void onEditButtonClick() {

    }
    @FXML
    protected void onSaveButtonClick() {
    }
    @FXML
    protected void initialize() {
        titleLabel.setText(BigCat.class.getName() + "Management");

        Enclosure lions = new Enclosure();
        lions.setName("Lions");

        // Add some lions to the enclosure
        lions.addAnimal(new Lion("Simba", 3, 36, 5));
        lions.addAnimal(new Lion("Mufasa", 8, 41, 3));
        lions.addAnimal(new Lion("Nala", 3, 30, 3));

        // Create an ObservableList from the list of animals
        ObservableList<Lion> lionList = FXCollections.observableArrayList(lions.getAnimals());

        // Set the ObservableList to the ListView
        listViewForAnimals.setItems(lionList);
    }

}
