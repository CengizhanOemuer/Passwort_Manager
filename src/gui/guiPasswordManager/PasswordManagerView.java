package gui.guiPasswordManager;

import business.businessPasswordManager.PasswordManagerModel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PasswordManagerView {
    // MVC-Pattern Attributes:
    private PasswordManagerModel passwordManagerModel;
    private PasswordManagerControl passwordManagerControl;

    // MVC-Pattern Constructor:
    public PasswordManagerView(PasswordManagerControl passwordManagerControl, Stage primaryStage, PasswordManagerModel passwordManagerModel) {
        this.passwordManagerModel = passwordManagerModel;
        this.passwordManagerControl = passwordManagerControl;

        // Initialising the window:
        Scene scene = new Scene(this.pane, sceneWidth, sceneHeight);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        // Initialising components:
        this.initComponents();
        this.initListener();
    }

    // GUI-Attributes:
    private Pane pane = new Pane();
    private double sceneHeight = 600;
    private double sceneWidth = 800;

    // Methods:
    private void initComponents() {

    }
    private void initListener() {

    }
}
