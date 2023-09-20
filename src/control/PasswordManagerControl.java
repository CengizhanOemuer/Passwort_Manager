package control;

import javafx.stage.Stage;
import model.PasswordManagerModel;
import view.PasswordManagerView;

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
