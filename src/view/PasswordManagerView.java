package view;

import control.PasswordManagerControl;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.PasswordManagerModel;

public class PasswordManagerView {

    // MVC-Pattern Attributes:
    private PasswordManagerModel passwordManagerModel;
    private PasswordManagerControl passwordManagerControl;

    // MVC-Pattern Constructor:
    public PasswordManagerView(PasswordManagerControl passwordManagerControl, Stage primaryStage, PasswordManagerModel passwordManagerModel) {

        this.passwordManagerModel = passwordManagerModel;
        this.passwordManagerControl = passwordManagerControl;

        // Initialising the window:
        Scene scene = new Scene(this.pane, 560, 340);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Password-Manager");
        primaryStage.show();

        // Initialising components:
            this.initComponents();
            this.initListener();
    }

    // GUI Attributes:
    private Pane pane = new Pane();
    private Label lblTest = new Label("This is a test!");

    // Methods:
    private void initComponents() {
        // Labels:
        lblTest.setLayoutX(20);
        lblTest.setLayoutY(40);
        pane.getChildren().addAll(lblTest);

        // Text-fields:

        // Text-areas:

        // Buttons:

    }

    private void initListener() {
        return;
    }
}
