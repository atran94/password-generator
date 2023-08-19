module password.generator {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens password.generator to javafx.fxml;
    exports password.generator;
}