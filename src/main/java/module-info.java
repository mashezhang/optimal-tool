module com.mx.fxlesson {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.mx.fxlesson to javafx.fxml;
    exports com.mx.fxlesson;
}