package com.example.assignmnent_4_zoo_management_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.text.html.ListView;
import java.awt.*;
import java.util.Optional;

/*public class EnclosureViewController {
    @FXML
    private Text enclosureNameText;

    @FXML
    private ListView<String> enclosureAnimalsListView;

    @FXML
    private Button addButton;

    @FXML
    private Button displayButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button backButton;

    private ObservableList<String> animalList;

    private Enclosure currentEnclosure;

    public void initialize() {
        enclosureNameText.setText(enclosureName);

        enclosureAnimalsListView.setItems(animalList);
    }

    public void setEnclosure(Enclosure enclosure) {
        this.currentEnclosure = enclosure;
        enclosureNameText.setText(enclosure.getName()); // Set enclosure name dynamically
        enclosureAnimalsListView.setItems(FXCollections.observableArrayList(enclosure.getAnimals()));
    }


    @FXML
    protected void onAddButtonClick(ActionEvent pEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("animal-view.fxml"));
            Parent view = fxmlLoader.load();
            AnimalViewController animalController = fxmlLoader.getController();
            animalController.setAnimal(null);
            Scene scene = new Scene(view, 500, 500);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(getSlectedEnclsoure().getName());
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());
            stage.showAndWait();

            // Refresh ListView after adding
            enclosureAnimalsListView.setItems(FXCollections.observableArrayList(currentEnclosure.getAnimals()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    protected void onDisplayButtonClick(ActionEvent pEvent) {
        Animal selectedAnimal = enclosureAnimalsListView.getSelectionModel().getSelectedItem();
        if (selectedAnimal == null) {
            showAlert("No Selection", "Please select an animal from the list.");
            return;
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("animal-view.fxml"));
            Parent view = fxmlLoader.load();
            AnimalViewController animalController = fxmlLoader.getController();
            animalController.setAnimal(selectedAnimal); // Open with details of selected animal
            Scene nextScene = new Scene(view, 500, 500);
            Stage nextStage = new Stage();
            nextStage.setScene(nextScene);
            nextStage.setTitle(pEnclosure.getName());
            nextStage.initModality(Modality.WINDOW_MODAL);
            nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
            nextStage.showAndWait();

            enclosureAnimalsListView.refresh();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    protected void onDeleteButtonClick(ActionEvent pEvent) {
        Animal selectedAnimal = enclosureAnimalsListView.getSelectionModel().getSelectedIndex();

        if (selectedAnimal == null) {
            showAlert("No Selection", "Please select an animal to delete.");
            return;
        }
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Deletion");
        confirmAlert.setHeaderText("Are you sure you want to delete " + selectedAnimal.getName() + "?");
        confirmAlert.setContentText("This action cannot be undone.");

        Optional<ButtonType> result = confirmAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Remove the animal from the enclosure
            currentEnclosure.removeAnimal(selectedAnimal);

            // Refresh the ListView
            enclosureAnimalsListView.setItems(FXCollections.observableArrayList(currentEnclosure.getAnimals()));

            showAlert("Success", selectedAnimal.getName() + " has been deleted.");
        }
    }

    @FXML
    protected void onBackButtonClick() {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}*/