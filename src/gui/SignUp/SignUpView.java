package gui.SignUp;

import business.SignUp.SignUpModel;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SignUpView {
    // Attributes:
    private SignUpModel signUpModel;
    private SignUpControl signUpControl;
    // Constructors:
    public SignUpView(SignUpControl signUpControl, Stage primaryStage, SignUpModel signUpModel) {
        this.signUpModel = signUpModel;
        this.signUpControl = signUpControl;

        // Initialising the window:
        Scene scene = new Scene(this.root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Password-Manager/SignUp");
        primaryStage.setResizable(false);
        /* INPUT STYLESHEET HERE - later */

        // Initialising components of SignUp-Window:
        this.initComponents();
        this.initListener();
    }
    // GUI-Attributes:
    private Pane root = new Pane();
    private final int SCENE_HEIGHT = 340;
    private final int SCENE_WIDTH = 560;
    private Label lblTest = new Label("Test");

    // Initialising-Components-Method:
    private void initComponents() {
        // Add components here:

        // ---
        root.getChildren().addAll(lblTest);
    }

    // Initialising-Listeners-Method:
    public void initListener() {

    }
}
