module com.example.assignmnent_4_zoo_management_system {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignmnent_4_zoo_management_system to javafx.fxml;
    exports com.example.assignmnent_4_zoo_management_system;
}