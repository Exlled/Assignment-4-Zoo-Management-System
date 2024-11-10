package com.example.assignmnent_4_zoo_management_system.Controllers;

import com.example.assignmnent_4_zoo_management_system.Model.Animal;
import com.example.assignmnent_4_zoo_management_system.Model.BigCat;
import com.example.assignmnent_4_zoo_management_system.Model.Enclosure;
import com.example.assignmnent_4_zoo_management_system.Model.Lion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
    ListView<Animal> listViewForAnimals;
    private Enclosure lions;

    //actions for back button
    @FXML
    protected void onBackButtonClick() {
        Stage stage = (Stage) editButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    protected void onAddButtonClick() {

    }
    @FXML
    protected void onDeleteButtonClick() {
        Animal selectedAnimal = listViewForAnimals.getSelectionModel().getSelectedItem();

        if (selectedAnimal != null) {
            // Confirm deletion
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this lion?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Delete Lion");
            alert.setHeaderText("Confirm Deletion");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.YES) {
                    lions.getAnimals().remove(selectedAnimal);  // Remove from the enclosure
                    listViewForAnimals.getItems().remove(selectedAnimal);  // Remove from the ListView
                }
            });
        } else {
            // Show an alert if no animal is selected
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a lion to delete.", ButtonType.OK);
            alert.setTitle("No Selection");
            alert.showAndWait();
        }
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
        ObservableList<Animal> lionList = FXCollections.observableArrayList(lions.getAnimals());

        // Set the ObservableList to the ListView
        listViewForAnimals.setItems(lionList);
    }

}
