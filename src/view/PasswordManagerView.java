package view;

import control.PasswordManagerControl;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
        Scene scene = new Scene(this.pane, sceneWidth, sceneHeight);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Password-Manager");
        primaryStage.setResizable(false);
        primaryStage.show();

        // Initialising components:
            this.initComponents();
            this.initListener();
    }

    // GUI Attributes:
    private double sceneHeight = 340;
    private  double sceneWidth = 560;
    private Pane pane = new Pane();
    private Label lblLogin = new Label("Login to your Account");
    private TextField txtFieldUsername = new TextField("Username");
    private TextField txtFieldPassword = new TextField("Password");
    private Button bSignUp = new Button("Sign Up");
    private Button bLogin = new Button("Login");
    private HBox hButtons = new HBox(bSignUp, bLogin);
    private VBox vLoginComponents = new VBox(txtFieldUsername, txtFieldPassword, hButtons);



    // Methods:
    private void initComponents() {
        // Labels:
        lblLogin.setFont(new Font("Arial", 24));
        lblLogin.setLayoutX((sceneWidth/2 - 70) - 40);
        lblLogin.setLayoutY(sceneHeight/2 - 85);
        pane.getChildren().addAll(lblLogin);

        // Text-fields:

        // Text-areas:

        // Buttons:
        bSignUp.setPrefWidth(72);
        bLogin.setPrefWidth(72);

        // Boxes:
        hButtons.setSpacing(5);
        vLoginComponents.setLayoutX(sceneWidth/2 - 70);
        vLoginComponents.setLayoutY(sceneHeight/2 - 50);
        vLoginComponents.setSpacing(5);
        pane.getChildren().addAll(vLoginComponents);

    }

    private void initListener() {
        return;
    }
}
