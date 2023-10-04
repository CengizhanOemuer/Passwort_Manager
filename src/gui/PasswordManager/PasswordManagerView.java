package gui.PasswordManager;

import business.PasswordManager.PasswordManagerModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
        primaryStage.setTitle("Password-Manager");

        // Initialising components:
        this.initComponents();
        this.initListener();
    }

    // GUI-Attributes:

    // ---------------------- window, scene & fonts ---------------------- //
    private Pane pane = new Pane();
    private double sceneHeight = 600;
    private double sceneWidth = 800;
    private Font titleFont = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 24);
    private Font textFont = Font.font("Arial",FontWeight.NORMAL, 14);
    // ---------------------- window, scene & fonts ---------------------- //

    // ---------------------- standard elements ---------------------- //
    private Text txtQuestion = new Text("What do u want to do?");
    private Text txtPasswordCreation = new Text("Create your Password");
    private RadioButton rBtnCreateNewPassword = new RadioButton("Create new Password!");
    private RadioButton rBtnLoadAllSavedPasswords = new RadioButton("Load passwords!");
    ToggleGroup toggleGroup = new ToggleGroup();
    private VBox vBox = new VBox(rBtnCreateNewPassword, rBtnLoadAllSavedPasswords);
    private TableView tableView = new TableView();
    private TableColumn<String, String> columnWebsite = new TableColumn<>("Website");
    private TableColumn<String, String> columnUsername = new TableColumn<>("Username");
    private TableColumn<String, String> columnPassword = new TableColumn<>("Password");
    // ---------------------- standard elements ---------------------- //

    // ---------------------- create new password  ---------------------- //
    private Text txtLength = new Text("Length of password");
    private TextField txtFieldWebsite = new TextField();
    private TextField txtFieldUsername = new TextField();
    private TextField txtFieldLength = new TextField();
    private TextField txtFieldGeneratedPassword = new TextField("");

    private CheckBox checkBoxIncludeUpper = new CheckBox("Include uppercase letters");
    private CheckBox checkBoxIncludeLower = new CheckBox("Include lowercase letters");
    private CheckBox checkBoxIncludeNumbers = new CheckBox("Include numbers");
    private CheckBox checkBoxIncludeSpecialCharacters = new CheckBox("Include special characters");
    private Button btnCreatePassword = new Button("Create password!");
    private Button btnSavePassword = new Button("Save");
    HBox hBoxInputLength = new HBox(txtLength, txtFieldLength);
    HBox hboxBtns = new HBox(btnCreatePassword, btnSavePassword);
    VBox vBoxForNewPassword = new VBox(txtPasswordCreation, txtFieldWebsite, txtFieldUsername, hBoxInputLength, checkBoxIncludeUpper, checkBoxIncludeLower, checkBoxIncludeNumbers, checkBoxIncludeSpecialCharacters, txtFieldGeneratedPassword, hboxBtns);
    // ---------------------- create new password  ---------------------- //

    // Methods:
    private void initComponents() {
        // Labels:
        txtQuestion.setLayoutX(60);
        txtQuestion.setLayoutY(60);
        txtQuestion.setFont(titleFont);
        pane.getChildren().addAll(txtQuestion);

        // Radio-Buttons 1:
        rBtnCreateNewPassword.setToggleGroup(toggleGroup);
        rBtnLoadAllSavedPasswords.setToggleGroup(toggleGroup);
        rBtnCreateNewPassword.setFont(textFont);
        rBtnLoadAllSavedPasswords.setFont(textFont);

        // VBoxes:
        vBox.setLayoutX(70);
        vBox.setLayoutY(80);
        vBox.setSpacing(10);
        pane.getChildren().addAll(vBox);


        // Columns:
        columnWebsite.setCellValueFactory(new PropertyValueFactory<>("Website"));
        columnWebsite.setPrefWidth((sceneWidth/2) / 3 - 5);
        columnUsername.setCellValueFactory(new PropertyValueFactory<>("Username"));
        columnUsername.setPrefWidth((sceneWidth/2) / 3 - 5);
        columnPassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
        columnPassword.setPrefWidth((sceneWidth/2) / 3 - 5);

        // TableView:
        tableView.getColumns().addAll(columnWebsite, columnUsername, columnPassword);
        tableView.setLayoutX(sceneWidth/2);
        tableView.setLayoutY(30);
        tableView.setPrefHeight(sceneHeight-60);
        tableView.setPrefWidth(sceneWidth/2 - 30);
        pane.getChildren().addAll(tableView);
    }
    private void initListener() {
        rBtnCreateNewPassword.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Initialising texts:
                txtPasswordCreation.setFont(titleFont);
                txtLength.setFont(textFont);
                // Initialising text-fields for input:
                txtFieldWebsite.setPromptText("Website");
                txtFieldWebsite.setMaxWidth(225);
                txtFieldUsername.setPromptText("Username");
                txtFieldUsername.setMaxWidth(225);
                txtFieldLength.setPromptText("Integer");
                txtFieldLength.setMaxWidth(60);
                // Initialising text-fields for output:
                txtFieldGeneratedPassword.setEditable(false);
                // Initialising checkboxes:
                checkBoxIncludeUpper.setFont(textFont);
                checkBoxIncludeLower.setFont(textFont);
                checkBoxIncludeNumbers.setFont(textFont);
                checkBoxIncludeSpecialCharacters.setFont(textFont);
                // Initialising buttons:
                btnCreatePassword.setFont(textFont);
                btnSavePassword.setFont(textFont);
                btnSavePassword.setPrefWidth(130);
                // Initialising hBoxes:
                hBoxInputLength.setSpacing(5);
                hboxBtns.setSpacing(5);
                // Initialising vBox:
                vBoxForNewPassword.setLayoutX(60);
                vBoxForNewPassword.setLayoutY(140);
                vBoxForNewPassword.setSpacing(10);
                pane.getChildren().addAll(vBoxForNewPassword);
            }
        });
        rBtnLoadAllSavedPasswords.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pane.getChildren().removeAll(vBoxForNewPassword);
            }
        });
        btnCreatePassword.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!(txtFieldLength.getText().length() == 0)) {
                    txtFieldGeneratedPassword.setText(passwordManagerControl.generatePassword(Integer.parseInt(txtFieldLength.getText()), checkBoxIncludeUpper.isSelected(), checkBoxIncludeLower.isSelected(), checkBoxIncludeNumbers.isSelected(), checkBoxIncludeSpecialCharacters.isSelected()));
                }
            }
        });
    }
}

