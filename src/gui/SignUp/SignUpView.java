package gui.SignUp;

import business.SignUp.SignUpModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import util.InformationWindowShower;

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
    /* ---------------------------------------------- */
    /* Window */
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
    private Label lblSignUp;
    /* Labels for V-Box */
    /* ---------------------------------------------- */
    /* Text-fields for V-Box */
    private TextField txtFieldInputUsername;
    private TextField txtFieldInputPassword;
    private TextField txtFieldInputPasswordAgain;
    /* Text-fields for V-Box */
    /* ---------------------------------------------- */
    /* Buttons for V-Box */
    private Button btnSignUp;
    /* Buttons for V-Box */
    /* ---------------------------------------------- */
    /* -V-Box- */
    private VBox vBoxSignUp;
    /* -V-Box- */
    /* ---------------------------------------------- */

    // Initialising-Components-Method:
    private void initComponents() {
        // V-Box:
        vBoxSignUp = new VBox();
        vBoxSignUp.setBackground(Background.fill(Color.WHITE));
        vBoxSignUp.setBorder(Border.stroke(Color.BLACK));
        vBoxSignUp.setSpacing(10);
        vBoxSignUp.setPadding(new Insets(10, 15, 10, 15));
        vBoxSignUp.setPrefWidth(SCENE_WIDTH - 300);
        vBoxSignUp.setPrefHeight(SCENE_HEIGHT - 75);
        vBoxSignUp.setLayoutX(150);
        vBoxSignUp.setLayoutY(37);
        // Label:
        lblSignUp = new Label("Sign Up");
        lblSignUp.setPadding(new Insets(10, 75, 10, 75));
        lblSignUp.setFont(TITLE_FONT);
        // Text-fields:
        txtFieldInputUsername = new TextField();
        txtFieldInputPassword = new TextField();
        txtFieldInputPasswordAgain = new TextField();
        txtFieldInputUsername.setPromptText("Username");
        txtFieldInputUsername.setMaxWidth(230);
        txtFieldInputPassword.setPromptText("Password");
        txtFieldInputPassword.setMaxWidth(230);
        txtFieldInputPasswordAgain.setPromptText("Repeat password");
        txtFieldInputPasswordAgain.setMaxWidth(230);
        // Buttons:
        btnSignUp = new Button("Sign Up");
        btnSignUp.setPrefWidth(230);
        // ---
        vBoxSignUp.getChildren().addAll(lblSignUp, txtFieldInputUsername, txtFieldInputPassword, txtFieldInputPasswordAgain, btnSignUp);
        root.getChildren().addAll(vBoxSignUp);
    }

    // Initialising-Listeners-Method:
    public void initListener() {
        btnSignUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                signUpControl.trySignUp(txtFieldInputUsername.getText(), txtFieldInputPassword.getText(), txtFieldInputPasswordAgain.getText());
            }
        });
    }

    // Methods:
    public void showInformationWindow(String message) {
        new InformationWindowShower(Alert.AlertType.INFORMATION, "-Information", message).showInformationWindow();
    }
    public void showErrorWindow(String errorType,String message) {
        new InformationWindowShower(Alert.AlertType.ERROR, errorType + "-Error", message).showInformationWindow();
    }
}
