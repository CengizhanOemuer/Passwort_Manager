package gui.Login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import business.Login.LoginModel;
import util.InformationWindowShower;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class LoginView {

    // Attributes:
    private LoginModel loginModel;
    private LoginControl loginControl;

    // Constructors:
    public LoginView(LoginControl loginControl, Stage primaryStage, LoginModel loginModel) {
        this.loginModel = loginModel;
        this.loginControl = loginControl;
        this.primaryStage = primaryStage;

        // Initialising the window:
        Scene scene = new Scene(this.root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Password-Manager/Login");
        primaryStage.setResizable(false);
        /* INPUT STYLESHEET - later */
        primaryStage.show();

        // Initialising components of Login-Window:
        this.initComponents();
        this.initListener();
    }

    // GUI Attributes:
    /* ---------------------------------------------- */
    /* Window */
    private final Stage primaryStage;
    private final Pane root = new Pane();
    private final double SCENE_HEIGHT = 340;
    private final double SCENE_WIDTH = 560;
    /* Window */
    /* ---------------------------------------------- */
    /* Fonts */
    private final Font TITLE_FONT = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20.0);
    /* Fonts */
    /* ---------------------------------------------- */
    /* Labels for V-Box */
    private Label lblLogin;
    /* Labels for V-Box */
    /* ---------------------------------------------- */
    /* Text-fields for V-Box */
    private TextField txtFieldUsername;
    private TextField txtFieldPassword;
    /* Text-fields for V-Box */
    /* ---------------------------------------------- */
    /* Buttons for H-Box */
    private Button btnSignUp;
    private Button btnLogin;
    /* Buttons for H-Box */
    /* ---------------------------------------------- */
    /* -H-Box for buttons- */
    private HBox hBoxButtons;
    /* -H-Box for buttons- */
    /* ---------------------------------------------- */
    /* -V-Box- */
    private VBox vBoxLogin;
    /* -V-Box- */

    // Methods:
    private void initComponents() {
        // V-Box:
        vBoxLogin = new VBox();
        vBoxLogin.setBackground(Background.fill(Color.WHITE));
        vBoxLogin.setBorder(Border.stroke(Color.BLACK));
        vBoxLogin.setSpacing(10);
        vBoxLogin.setPadding(new Insets(10, 15, 10, 15));
        vBoxLogin.setPrefWidth(SCENE_WIDTH - 300);
        vBoxLogin.setPrefHeight(SCENE_HEIGHT - 75);
        vBoxLogin.setLayoutX(150);
        vBoxLogin.setLayoutY(37);
        // H-Box:
        hBoxButtons = new HBox();
        hBoxButtons.setSpacing(5);
        // Labels:
        lblLogin = new Label("Login");
        lblLogin.setPadding(new Insets(10, 75, 10, 75));
        lblLogin.setFont(TITLE_FONT);
        // Text-fields:
        txtFieldUsername = new TextField();
        txtFieldPassword = new TextField();
        txtFieldUsername.setPromptText("Username");
        txtFieldPassword.setPromptText("Password");
        // Buttons:
        btnSignUp = new Button("Sign Up");
        btnLogin = new Button("Login");
        btnSignUp.setPrefWidth(111);
        btnLogin.setPrefWidth(111);
        // ---
        hBoxButtons.getChildren().addAll(btnSignUp, btnLogin);
        vBoxLogin.getChildren().addAll(lblLogin, txtFieldUsername, txtFieldPassword, hBoxButtons);
        root.getChildren().addAll(vBoxLogin);

    }

    private void initListener() {
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // loginControl.login(primaryStage);
                try {
                    loginControl.tryLogin(txtFieldUsername.getText(), txtFieldPassword.getText(), primaryStage);
                } catch (
                        InvalidAlgorithmParameterException | InvalidKeyException | BadPaddingException |
                        InvalidKeySpecException | NoSuchAlgorithmException | IllegalBlockSizeException |
                        NoSuchPaddingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        btnSignUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loginControl.openSignUpWindow(primaryStage);
            }
        });
    }

    // Methods:

    // Information Window: --> on successful login!
    public void showInformationWindow(String message) {
        new InformationWindowShower(Alert.AlertType.INFORMATION, "-Information", message).showInformationWindow();
    }
    // Error Window: --> on failed login!
    public void showErrorWindow(String errorType,String message) {
        new InformationWindowShower(Alert.AlertType.ERROR, errorType + "-Error", message).showInformationWindow();
    }
}
