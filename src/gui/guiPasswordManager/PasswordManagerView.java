package gui.guiPasswordManager;

import business.businessPasswordManager.PasswordManagerModel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.scene.AccessibleAttribute.FONT;

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
    private Text txtCreateNewPassword = new Text("Create a new Password!");
    private Font titleFont = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 24);
    private TextField txtFieldWebsite = new TextField();
    private TextField txtFieldUsername = new TextField();
    private TextField txtFieldPassword = new TextField();
    private HBox hBox = new HBox();
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


        // HBoxes:


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
