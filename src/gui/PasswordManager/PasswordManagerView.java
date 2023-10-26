package gui.PasswordManager;

import business.PasswordManager.PasswordManagerModel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PasswordManagerView {
    // Attributes:
    private final PasswordManagerModel passwordManagerModel;
    private final PasswordManagerControl passwordManagerControl;

    // Constructor:
    public PasswordManagerView(PasswordManagerControl passwordManagerControl, Stage primaryStage, PasswordManagerModel passwordManagerModel) {
        this.passwordManagerModel = passwordManagerModel;
        this.passwordManagerControl = passwordManagerControl;
        this.primaryStage = primaryStage;

        // Initialising the window:
        Scene scene = new Scene(this.root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Password-Manager");

        // Initialising components:
        this.initComponents();
        this.initListener();
    }

    // GUI-Attributes:
    /* ---------------------------------------------- */
    /* Window */
    private final Stage primaryStage;
    private final Pane root = new Pane();
    private final double SCENE_HEIGHT = 600;
    private final double SCENE_WIDTH = 800;

    /* Window */
    /* ---------------------------------------------- */
    /* Fonts */
    private final Font TITLE_FONT = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 24);
    private final Font LABEL_FONT = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20);
    private final Font TEXT_FONT = Font.font("Arial", FontWeight.NORMAL, 14);
    /* Fonts */
    /* ---------------------------------------------- */
    /* Password-Generator-Attributes */
    /* ---------------------------------------------- */
    /* Labels for vBox of Password-Generator */
    private Label lblPasswordGenerator;
    private Label lblLengthOfPassword;
    private Label lblLengthNumber;
    /* Labels for vBox of Password-Generator */
    /* ---------------------------------------------- */
    /* Text Areas for vBox of Password-Generator */
    private TextArea txtAreaPassword;
    /* Text Areas for vBox of Password-Generator */
    /* ---------------------------------------------- */
    /* Text fields for vBox of Password-Generator */
    private TextField txtFieldWebsite;
    private TextField txtFieldUsername;
    /* Text fields for vBox of Password-Generator */
    /* ---------------------------------------------- */
    /* Checkboxes for Password-Generator */
    private CheckBox checkBoxUpper;
    private CheckBox checkBoxLower;
    private CheckBox checkBoxNumbers;
    private CheckBox checkBoxSpecials;

    /* Checkboxes for Password-Generator */
    /* ---------------------------------------------- */
    /* Buttons for Password-Generator */
    private Button btnGenerate;
    private Button btnSave;
    /* Buttons for Password-Generator */
    /* ---------------------------------------------- */
    /* Slider for Password-Generator */
    private Slider sliderForLength;
    /* Slider for Password-Generator */
    /* ---------------------------------------------- */
    /* HBoxes for Password-Generator */
    private HBox hBoxSliderLabels;
    /* HBoxes for Password-Generator */
    /* ---------------------------------------------- */
    /* VBoxes for Password-Generator */
    private VBox vBoxPasswordGenerator;
    private VBox vBoxSettingsComponents;
    private VBox vBoxCheckboxes;
    /* VBox for Password-Generator */
    /* ---------------------------------------------- */
    /* Password-Generator-Attributes */
    /* ---------------------------------------------- */
    // GUI-Attributes:

    private TableView tableView = new TableView();
    private TableColumn<String, String> columnWebsite = new TableColumn<>("Website");
    private TableColumn<String, String> columnUsername = new TableColumn<>("Username");
    private TableColumn<String, String> columnPassword = new TableColumn<>("Password");

    // Methods:
    private void initComponents() {
        // V-Boxes for Password-Generator:
        vBoxPasswordGenerator = new VBox();
        vBoxPasswordGenerator.setBackground(Background.fill(Color.WHITE));
        vBoxPasswordGenerator.setBorder(Border.stroke(Color.BLACK));
        vBoxPasswordGenerator.setSpacing(10);
        vBoxPasswordGenerator.setPadding(new Insets(10, 15, 10, 15));
        vBoxPasswordGenerator.setPrefWidth(SCENE_WIDTH/2 - 10);
        vBoxPasswordGenerator.setPrefHeight(SCENE_HEIGHT-10);
        vBoxPasswordGenerator.setLayoutX(5);
        vBoxPasswordGenerator.setLayoutY(5);

        vBoxSettingsComponents = new VBox();
        vBoxSettingsComponents.setSpacing(10);

        vBoxCheckboxes = new VBox();
        vBoxCheckboxes.setSpacing(5);

        // HBoxes for Password-Generator:
        hBoxSliderLabels = new HBox();
        hBoxSliderLabels.setSpacing(25);

        // Labels for Password-Generator:
        lblPasswordGenerator = new Label("Password Generator");
        lblPasswordGenerator.setPadding(new Insets(0, 60, 0, 60));
        lblPasswordGenerator.setFont(TITLE_FONT);

        lblLengthOfPassword = new Label("Length of Password:");
        lblLengthOfPassword.setFont(TEXT_FONT);

        lblLengthNumber = new Label("8");
        lblLengthNumber.setFont(TEXT_FONT);

        // Text Area for Password-Generator:
        txtAreaPassword = new TextArea();
        txtAreaPassword.setMaxHeight(20);
        txtAreaPassword.setEditable(false);
        txtAreaPassword.setPromptText("Pa$$w0rd");

        // Slider for Password-Generator:
        sliderForLength = new Slider(8, 32, 8);
        sliderForLength.setMajorTickUnit(1);
        sliderForLength.setShowTickMarks(true);
        sliderForLength.setShowTickLabels(true);
        sliderForLength.setSnapToTicks(true);

        // Checkboxes for Password-Generator:
        checkBoxUpper = new CheckBox("Include upper");
        checkBoxLower = new CheckBox("Include lower");
        checkBoxNumbers = new CheckBox("Include numbers");
        checkBoxSpecials = new CheckBox("Include specials");

        checkBoxUpper.setFont(TEXT_FONT);
        checkBoxLower.setFont(TEXT_FONT);
        checkBoxNumbers.setFont(TEXT_FONT);
        checkBoxSpecials.setFont(TEXT_FONT);

        // Text-fields for Password-Generator:
        txtFieldWebsite = new TextField();
        txtFieldUsername = new TextField();

        txtFieldWebsite.setPromptText("Website");
        txtFieldUsername.setPromptText("Username");

        // Buttons for Password-Generator:
        btnGenerate = new Button("Generate");
        btnSave = new Button("Save");

        /*
        // Columns:
        columnWebsite.setCellValueFactory(new PropertyValueFactory<>("Website"));
        columnWebsite.setPrefWidth((SCENE_WIDTH / 2) / 3 - 5);
        columnUsername.setCellValueFactory(new PropertyValueFactory<>("Username"));
        columnUsername.setPrefWidth((SCENE_WIDTH / 2) / 3 - 5);
        columnPassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
        columnPassword.setPrefWidth((SCENE_WIDTH / 2) / 3 - 5);


        // TableView:
        tableView.getColumns().addAll(columnWebsite, columnUsername, columnPassword);
        tableView.setLayoutX(SCENE_WIDTH / 2);
        tableView.setLayoutY(30);
        tableView.setPrefHeight(SCENE_HEIGHT - 60);
        tableView.setPrefWidth(SCENE_WIDTH / 2 - 30);
         */

        // ---
        vBoxCheckboxes.getChildren().addAll(checkBoxUpper, checkBoxLower, checkBoxNumbers, checkBoxSpecials);
        hBoxSliderLabels.getChildren().addAll(lblLengthOfPassword, lblLengthNumber);

        vBoxSettingsComponents.getChildren().addAll(hBoxSliderLabels, sliderForLength, vBoxCheckboxes, btnGenerate, txtFieldWebsite, txtFieldUsername, btnSave);

        vBoxPasswordGenerator.getChildren().addAll(lblPasswordGenerator, txtAreaPassword, vBoxSettingsComponents);

        root.getChildren().addAll(vBoxPasswordGenerator);
    }

    private void initListener() {

    }
}

