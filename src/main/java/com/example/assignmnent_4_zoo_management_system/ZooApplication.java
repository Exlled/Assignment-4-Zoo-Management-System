package com.example.assignmnent_4_zoo_management_system;

import Controllers.CompositeAnimalViewController;
import Models.Animal;
import Models.CompositeAnimalCollection;
import Models.Enclosure;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ZooApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("enclosure-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 340, 340);
        stage.setTitle("Enclosure View");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}