package Controllers;

import Models.Animal;
import Models.Enclosure;
import com.example.assignmnent_4_zoo_management_system.ZooApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class EnclosureViewController {
    @FXML
    private Text enclosureNameText;

    @FXML
    private ListView<Animal> enclosureAnimalsListView;

    @FXML
    private Button addButton;

    @FXML
    private Button displayButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button backButton;

    private ObservableList<Animal> animalList;

    private Enclosure enclosure;


    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
        enclosureNameText.setText(enclosure.getName()); // Set enclosure name dynamically

        // Load animals into the ListView
        animalList = FXCollections.observableArrayList(enclosure.getAnimals());
        enclosureAnimalsListView.setItems(animalList);
    }


    @FXML
    protected void onAddButtonClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("animal-view.fxml"));
            Parent view = fxmlLoader.load();
            AnimalViewController animalController = fxmlLoader.getController();
            animalController.setAnimal(null);
            Scene scene = new Scene(view, 500, 500);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(enclosure.getName());
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());
            stage.showAndWait();

            // Refresh the animal list after adding a new animal
            refreshAnimalList();

        } catch (IOException e) {
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
            nextStage.setTitle(enclosure.getName());
            nextStage.initModality(Modality.WINDOW_MODAL);
            nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
            nextStage.showAndWait();

            // Refresh the animal list after editing an animal
            refreshAnimalList();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    protected void onDeleteButtonClick(ActionEvent pEvent) {
        Animal selectedAnimal = enclosureAnimalsListView.getSelectionModel().getSelectedItem();

        if (selectedAnimal != null) {
            // Confirm the deletion with an alert
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Delete");
            alert.setHeaderText("Are you sure you want to delete " + selectedAnimal.getName() + "?");
            alert.setContentText("This action cannot be undone.");

            if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
                removeAnimal(selectedAnimal); // Call the removeAnimal method
            }
        } else {
            // Show an alert if no animal is selected
            Alert noSelectionAlert = new Alert(Alert.AlertType.WARNING);
            noSelectionAlert.setTitle("No Selection");
            noSelectionAlert.setHeaderText("No Animal Selected");
            noSelectionAlert.setContentText("Please select an animal to delete.");
            noSelectionAlert.showAndWait();
        }
    }

    @FXML
    protected void onBackButtonClick(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Refreshes the animal list in the ListView.
     */
    private void refreshAnimalList() {
        animalList.setAll(enclosure.getAnimals());
    }

    private void removeAnimal(Animal animal) {
        if (animal != null && enclosure.getAnimals().contains(animal)) {
            enclosure.getAnimals().remove(animal); // Remove from enclosure
            animalList.remove(animal); // Update the ObservableList to refresh the ListView
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}