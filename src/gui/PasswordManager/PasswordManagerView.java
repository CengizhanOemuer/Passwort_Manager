package gui.PasswordManager;

import business.PasswordManager.PasswordManagerModel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private Pane pane = new Pane();
    private double sceneHeight = 600;
    private double sceneWidth = 800;
    private Text txtCreateNewPassword = new Text("What do u want to do?");
    private Font titleFont = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 24);
    private RadioButton rBtnCreateNewPassword = new RadioButton("Create new Password!");
    private RadioButton rBtnLoadAllSavedPasswords = new RadioButton("Load passwords!");
    ToggleGroup toggleGroup = new ToggleGroup();
    private VBox vBox = new VBox(rBtnCreateNewPassword, rBtnLoadAllSavedPasswords);
    private TextField txtFieldWebsite = new TextField();
    private TextField txtFieldUsername = new TextField();
    private TextField txtFieldPassword = new TextField();
    private TableView tableView = new TableView();
    private TableColumn<String, String> columnWebsite = new TableColumn<>("Website");
    private TableColumn<String, String> columnUsername = new TableColumn<>("Username");
    private TableColumn<String, String> columnPassword = new TableColumn<>("Password");

    // Methods:
    private void initComponents() {
        // Labels:
        txtCreateNewPassword.setLayoutX(60);
        txtCreateNewPassword.setLayoutY(60);
        txtCreateNewPassword.setFont(titleFont);
        pane.getChildren().addAll(txtCreateNewPassword);

        // Text-fields:

        // Radio-Buttons 1:
        rBtnCreateNewPassword.setToggleGroup(toggleGroup);
        rBtnLoadAllSavedPasswords.setToggleGroup(toggleGroup);

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

    }
}
