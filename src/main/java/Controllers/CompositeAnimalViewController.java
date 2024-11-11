package Controllers;

import Models.Animal;
import Models.CompositeAnimalCollection;
import Models.Enclosure;
import com.example.assignmnent_4_zoo_management_system.ZooApplication;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CompositeAnimalViewController {
    @FXML
    private Text collectionTitleText;
    @FXML
    private ListView<Enclosure> enclosuresListView;
    @FXML
    private Button displayButton;
    @FXML
    private Button exitButton;

    private CompositeAnimalCollection currentCollection;

    // Method to set the collection and populate the ListView
    public void setCollection(CompositeAnimalCollection collection) {
        this.currentCollection = collection;

        if (collection != null) {
            System.out.println("Setting collection with name: " + collection.getName());
            collectionTitleText.setText(collection.getName());

            // Populate the ListView
            enclosuresListView.setItems(FXCollections.observableArrayList(collection.getEnclosures()));

            // Debug: Print out the enclosures
            for (Enclosure enclosure : collection.getEnclosures()) {
                System.out.println("Enclosure added: " + enclosure.getName());
            }
        } else {
            System.out.println("No collection provided.");
        }

        this.currentCollection = collection;
        collectionTitleText.setText(collection.getName());

        // Populate the ListView with enclosures from the collection
        List<Enclosure> enclosures = collection.getEnclosures(); // Assuming getEnclosures() exists
        enclosuresListView.setItems(FXCollections.observableArrayList(enclosures));

    }

    // Handle "Display" button click
    @FXML
    private void onDisplayButtonClick() {
        Enclosure selectedEnclosure = enclosuresListView.getSelectionModel().getSelectedItem();
        if (selectedEnclosure != null) {
            try {
                // Open EnclosureView in a new modal window
                FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("enclosure-view.fxml"));
                Parent view = fxmlLoader.load();
                EnclosureViewController enclosureViewController = fxmlLoader.getController();
                enclosureViewController.setEnclosure(selectedEnclosure);

                Stage stage = new Stage();
                stage.setTitle(selectedEnclosure.getName()); // Set the window title to the enclosure name
                stage.setScene(new Scene(view));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Alert if no enclosure is selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select an enclosure to display.");
            alert.showAndWait();
        }
    }

    // Handle "Exit" button click
    @FXML
    private void onExitButtonClick(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}


