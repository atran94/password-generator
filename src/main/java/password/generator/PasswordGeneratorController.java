package password.generator;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.text.Text;

import java.io.IOException;

public class PasswordGeneratorController {
    //
    private final Settings settings = Settings.getInstance();

    @FXML
    private Text passwordText;

    @FXML
    private CheckBox cbUseAlpha, cbUseNumeric, cbUseSpecial;

    @FXML
    private Spinner passwordLengthSpinner;

    @FXML
    protected void onGeneratePasswordButtonClick() {
        // These input variables will be replaced by the JavaFX GUI that I will build
        // in the 2nd and 3rd milestones.
        boolean useAllAlphaChars = cbUseAlpha.isSelected();
        boolean useNumericChars = cbUseNumeric.isSelected();
        boolean useSpecialChars = cbUseSpecial.isSelected();
        int passwordLength = (int) passwordLengthSpinner.getValue();

        // initialize the password generator object
        PasswordGenerator passwordGenerator = new PasswordGenerator(
                useAllAlphaChars,
                useNumericChars,
                useSpecialChars,
                passwordLength
        );

        // generate the password from the initialized passwordGenerator object values
        String password = passwordGenerator.generate();
        passwordText.setText(password);

        // Save the setting state
        settings.setUseAllAlpha(useAllAlphaChars);
        settings.setUseNumeric(useNumericChars);
        settings.setUseSpecial(useSpecialChars);
        settings.setLength(passwordLength);
        settings.setPassword(password);

        // Save the state to json
        try {
            DataSaver.saveData(settings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onCopyButtonClick() {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(passwordText.getText());
        clipboard.setContent(content);

    }
}