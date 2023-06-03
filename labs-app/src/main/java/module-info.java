module com.hulk.labsapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.hulk.labsapp.view to javafx.fxml;
    exports com.hulk.labsapp.view;

    opens com.hulk.labsapp.entity to javafx.fxml;
    exports com.hulk.labsapp.entity;

    opens com.hulk.labsapp to javafx.fxml;
    exports com.hulk.labsapp;
}