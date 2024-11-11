package Controllers;

import Models.Animal;
import Models.Enclosure;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnimalViewController {
        @FXML
        private TextField nameTextField;

        @FXML
        private TextField sexTextField;

        @FXML
        private TextField ageTextField;

        @FXML
        private TextField weightTextField;

        @FXML
        private Button saveButton;

        @FXML
        private Button closeButton;

        private Enclosure currentEnclosure;
        private Animal currentAnimal;
        private boolean isEditMode = false;

        public void setEnclosure(Enclosure enclosure) {
            this.currentEnclosure = enclosure;
            clearFields();
        }

        public void setAnimal(Animal animal) {
            this.currentAnimal = animal;
            isEditMode = true;

            if (animal != null) {
                nameTextField.setText(animal.getName());
                sexTextField.setText(animal.getSex());
                ageTextField.setText(String.valueOf(animal.getAge()));
                weightTextField.setText(String.valueOf(animal.getWeight()));
            }
        }

        private void clearFields() {
            nameTextField.clear();
            sexTextField.clear();
            ageTextField.clear();
            weightTextField.clear();
        }


        @FXML
        protected void onSaveButtonClick(ActionEvent event) {
            String name = nameTextField.getText().trim();
            String sex = sexTextField.getText().trim();
            String ageText = ageTextField.getText().trim();
            String weightText = weightTextField.getText().trim();

            // Validate the inputs
            if (name.isEmpty() || sex.isEmpty() || ageText.isEmpty() || weightText.isEmpty()) {
                showAlert("Validation Error", "Please fill in all fields.");
                return;
            }

            int age;
            double weight;
            try {
                age = Integer.parseInt(ageText);
                weight = Double.parseDouble(weightText);
            } catch (NumberFormatException e) {
                showAlert("Validation Error", "Age must be an integer and weight must be a decimal number.");
                return;
            }

            if (isEditMode && currentAnimal != null) {
                // Update existing animal details
                currentAnimal.setName(name);
                currentAnimal.setSex(sex);
                currentAnimal.setAge(age);
                currentAnimal.setWeight(weight);
            } else {
                // Add a new animal to the enclosure
                Animal newAnimal = new Animal(name, age, sex, weight);
                currentEnclosure.addAnimal(newAnimal);
            }

            // Close the window after saving
            closeWindow(event);
        }

        @FXML
        protected void onCloseButtonClick(ActionEvent event) {
            closeWindow(event);
        }

        private void closeWindow(ActionEvent event) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }

        private void showAlert(String title, String content) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(title);
            alert.setContentText(content);
            alert.showAndWait();
        }
}
