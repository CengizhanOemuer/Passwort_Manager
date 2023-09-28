package gui.PasswordManager;

import business.PasswordManager.PasswordManagerModel;
import javafx.stage.Stage;

public class PasswordManagerControl {
    // MVC-Pattern Attributes:
    private PasswordManagerModel passwordManagerModel;
    private PasswordManagerView passwordManagerView;

    // MVC-Pattern Constructor:
    public PasswordManagerControl(Stage primaryStage) {
        this.passwordManagerModel = new PasswordManagerModel();
        this.passwordManagerView = new PasswordManagerView(this, primaryStage, passwordManagerModel);
    }
}
