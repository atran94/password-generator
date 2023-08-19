package password.generator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class PasswordGeneratorApplication extends Application {
    private final Settings settings = Settings.getInstance();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PasswordGeneratorApplication.class.getResource("/password-generator-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("Password Generator");
        stage.setScene(scene);
        stage.show();

        //load setting data from gson
        DataSaver.loadData(settings);

        // Get view references
        CheckBox cbUseAllAlpha = (CheckBox) scene.lookup("#cbUseAlpha");
        CheckBox cbUseNumeric = (CheckBox) scene.lookup("#cbUseNumeric");
        CheckBox cbUseSpecial = (CheckBox) scene.lookup("#cbUseSpecial");
        Spinner spLength = (Spinner) scene.lookup("#passwordLengthSpinner");
        Text password = (Text) scene.lookup("#passwordText");

        cbUseAllAlpha.setSelected(settings.isUseAllAlpha());
        cbUseNumeric.setSelected(settings.isUseNumeric());
        cbUseSpecial.setSelected(settings.isUseSpecial());
        spLength.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(8, 25, settings.getLength(), 1));

        password.setText(settings.getPassword());
    }
}