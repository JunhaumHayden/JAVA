module App {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;
    // requires com.fasterxml.jackson.databind;
    opens edu.ifsc to javafx.fxml;
    opens edu.ifsc.controller to javafx.fxml;
    exports edu.ifsc;
}