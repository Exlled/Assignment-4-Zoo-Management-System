module com.example.assignmnent_4_zoo_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.assignmnent_4_zoo_management_system to javafx.fxml;
    exports com.example.assignmnent_4_zoo_management_system;
    exports com.example.assignmnent_4_zoo_management_system.Controllers;
    opens com.example.assignmnent_4_zoo_management_system.Controllers to javafx.fxml;
}