module ucf.assignments.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
//    requires org.junit.jupiter.api;


    opens ucf.assignments.app to javafx.fxml;
    exports ucf.assignments.app;
}