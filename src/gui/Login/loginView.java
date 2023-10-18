package gui.Login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import business.Login.loginModel;

public class loginView {

    // MVC-Pattern Attributes:
    private loginModel loginModel;
    private loginControl loginControl;

    // MVC-Pattern Constructor:
    public loginView(loginControl loginControl, Stage primaryStage, loginModel loginModel) {

        this.loginModel = loginModel;
        this.loginControl = loginControl;
        this.primaryStage = primaryStage;

        // Initialising the window:
        Scene scene = new Scene(this.pane, sceneWidth, sceneHeight);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Password-Manager/Login");
        primaryStage.setResizable(false);
        scene.getStylesheets().add("style.css");
        primaryStage.show();

        // Initialising components:
        this.initComponents();
        this.initListener();
    }

    // GUI Attributes:
    Stage primaryStage;
    private double sceneHeight = 340;
    private  double sceneWidth = 560;
    private Pane pane = new Pane();
    private Label lblLogin = new Label("Login to your Account");
    private TextField txtFieldUsername = new TextField();
    private TextField txtFieldPassword = new TextField();
    private Button btnSignUp = new Button("Sign Up");
    private Button btnLogin = new Button("Login");
    private HBox hButtons = new HBox(btnSignUp, btnLogin);
    private VBox vLoginComponents = new VBox(txtFieldUsername, txtFieldPassword, hButtons);



    // Methods:
    private void initComponents() {
        // Labels:
        lblLogin.setFont(new Font("Arial", 24));
        lblLogin.setLayoutX((sceneWidth/2 - 70) - 40);
        lblLogin.setLayoutY(sceneHeight/2 - 85);
        pane.getChildren().addAll(lblLogin);

        // Text-fields:
        txtFieldUsername.setPromptText("Username");
        txtFieldPassword.setPromptText("Password");

        // Text-areas:

        // Buttons:
        btnSignUp.setPrefWidth(72);
        btnLogin.setPrefWidth(72);

        // Boxes:
        hButtons.setSpacing(5);
        vLoginComponents.setLayoutX(sceneWidth/2 - 70);
        vLoginComponents.setLayoutY(sceneHeight/2 - 50);
        vLoginComponents.setSpacing(5);
        pane.getChildren().addAll(vLoginComponents);

    }

    private void initListener() {
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loginControl.login(primaryStage);
            }
        });
        btnSignUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loginControl.openSignUpWindow(primaryStage);
            }
        });
    }
}
