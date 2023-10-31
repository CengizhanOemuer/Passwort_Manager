package gui.PasswordManager;

import business.PasswordManager.PasswordManagerModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import util.InformationWindowShower;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class PasswordManagerView {
    // Attributes:
    private final PasswordManagerModel passwordManagerModel;
    private final PasswordManagerControl passwordManagerControl;

    // Constructor:
    public PasswordManagerView(PasswordManagerControl passwordManagerControl, Stage primaryStage, PasswordManagerModel passwordManagerModel) {
        this.passwordManagerControl = passwordManagerControl;
        this.passwordManagerModel = passwordManagerModel;
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
    private Button btnLogOut;
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
    private VBox vBoxComponents;
    private VBox vBoxCheckboxes;
    /* VBox for Password-Generator */
    /* ---------------------------------------------- */
    /* Password-Generator-Attributes */
    /* ---------------------------------------------- */
    /* Password-Table */
    /* ---------------------------------------------- */
    /* Labels */
    private Label lblPasswordTable;
    /* Labels */
    /* ---------------------------------------------- */
    /* TableViews */
    private TableView tableView = new TableView();
    /* TableViews */
    /* ---------------------------------------------- */
    /* TableColumns */
    private TableColumn<String, String> columnWebsite = new TableColumn<>("Website");
    private TableColumn<String, String> columnUsername = new TableColumn<>("Username");
    private TableColumn<String, String> columnPassword = new TableColumn<>("Password");
    /* TableColumns */
    /* ---------------------------------------------- */
    /* VBox for TableView */
    private VBox vBoxTableSide;
    /* VBox for TableView */
    /* ---------------------------------------------- */
    /* Password-Table */
    /* ---------------------------------------------- */
    // GUI-Attributes:



    // Methods:
    private void initComponents() {
        /* --------------------------------------------------------------------------------------------------- */
        // V-Boxes for Password-Generator:
        vBoxPasswordGenerator = new VBox();
        vBoxPasswordGenerator.setBackground(Background.fill(Color.WHITE));
        vBoxPasswordGenerator.setBorder(Border.stroke(Color.BLACK));
        vBoxPasswordGenerator.setSpacing(15);
        vBoxPasswordGenerator.setPadding(new Insets(10, 15, 10, 15));
        vBoxPasswordGenerator.setPrefWidth(SCENE_WIDTH/2 - 10);
        vBoxPasswordGenerator.setPrefHeight(SCENE_HEIGHT-10);
        vBoxPasswordGenerator.setLayoutX(5);
        vBoxPasswordGenerator.setLayoutY(5);

        vBoxComponents = new VBox();
        vBoxComponents.setSpacing(15);
        vBoxComponents.setPadding(new Insets(30, 0, 30, 0));
        // vBoxComponents.setBorder(Border.stroke(Color.BLACK));

        vBoxCheckboxes = new VBox();
        vBoxCheckboxes.setSpacing(15);

        // HBoxes for Password-Generator:
        hBoxSliderLabels = new HBox();
        hBoxSliderLabels.setSpacing(135);

        // Labels for Password-Generator:
        lblPasswordGenerator = new Label("Password Generator");
        lblPasswordGenerator.setPadding(new Insets(0, 60, 0, 60));
        lblPasswordGenerator.setFont(TITLE_FONT);

        lblLengthOfPassword = new Label("Length of Password:");
        lblLengthOfPassword.setFont(LABEL_FONT);

        lblLengthNumber = new Label("8");
        lblLengthNumber.setFont(LABEL_FONT);

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

        checkBoxUpper.setPadding(new Insets(0, 25, 0, 25));
        checkBoxLower.setPadding(new Insets(0, 25, 0, 25));
        checkBoxNumbers.setPadding(new Insets(0, 25, 0, 25));
        checkBoxSpecials.setPadding(new Insets(0, 25, 0, 25));

        // Text-fields for Password-Generator:
        txtFieldWebsite = new TextField();
        txtFieldUsername = new TextField();

        txtFieldWebsite.setPromptText("Website");
        txtFieldUsername.setPromptText("Username");

        // Buttons for Password-Generator:
        btnGenerate = new Button("Generate");
        btnSave = new Button("Save");
        btnLogOut = new Button("Log out");

        btnGenerate.setPrefWidth(370);
        btnSave.setPrefWidth(370);
        btnLogOut.setPrefWidth(370);

        btnGenerate.setFont(TEXT_FONT);
        btnSave.setFont(TEXT_FONT);
        btnLogOut.setFont(TEXT_FONT);
        /* --------------------------------------------------------------------------------------------------- */
        // VBox for TableView:
        vBoxTableSide = new VBox();
        vBoxTableSide.setBackground(Background.fill(Color.WHITE));
        vBoxTableSide.setBorder(Border.stroke(Color.BLACK));
        vBoxTableSide.setSpacing(15);
        vBoxTableSide.setPadding(new Insets(10, 15, 10, 15));
        vBoxTableSide.setPrefWidth(SCENE_WIDTH/2 - 10);
        vBoxTableSide.setPrefHeight(SCENE_HEIGHT-10);
        vBoxTableSide.setLayoutX(SCENE_WIDTH / 2 + 5);
        vBoxTableSide.setLayoutY(5);

        // Labels:
        lblPasswordTable = new Label("Saved Passwords");
        lblPasswordTable.setFont(TITLE_FONT);
        lblPasswordTable.setPadding(new Insets(0, 75, 0, 75));

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
        /* --------------------------------------------------------------------------------------------------- */

        // ---
        hBoxSliderLabels.getChildren().addAll(lblLengthOfPassword, lblLengthNumber);
        vBoxCheckboxes.getChildren().addAll(checkBoxUpper, checkBoxLower, checkBoxNumbers, checkBoxSpecials);
        vBoxComponents.getChildren().addAll(lblPasswordGenerator, txtAreaPassword, hBoxSliderLabels, sliderForLength, vBoxCheckboxes, btnGenerate, txtFieldWebsite, txtFieldUsername, btnSave, btnLogOut);
        vBoxPasswordGenerator.getChildren().addAll(vBoxComponents);
        vBoxTableSide.getChildren().addAll(lblPasswordTable,tableView);
        root.getChildren().addAll(vBoxPasswordGenerator, vBoxTableSide);
    }

    private void initListener() {
        sliderForLength.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldNumber, Number newNumber) {
                lblLengthNumber.setText(String.valueOf(newNumber.intValue()));
            }
        });
        btnGenerate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                txtAreaPassword.setText(
                        PasswordManagerControl.generatePassword(
                            Integer.parseInt(lblLengthNumber.getText()),
                            checkBoxUpper.isSelected(),
                            checkBoxLower.isSelected(),
                            checkBoxNumbers.isSelected(),
                            checkBoxSpecials.isSelected()
                        )
                );
            }
        });
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    PasswordManagerControl.savePasswordIntoDatabank(txtFieldWebsite.getText(), txtFieldUsername.getText(), txtAreaPassword.getText());
                } catch (
                        InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException |
                        NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | InvalidKeyException e
                ) {
                    throw new RuntimeException(e);
                }
            }
        });
        btnLogOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                PasswordManagerControl.logOut(primaryStage);
            }
        });
    }

    // Methods:

    // Information Window: --> only if something went right!
    public void showInformationWindow(String message) {
        new InformationWindowShower(Alert.AlertType.INFORMATION, "-Information", message).showInformationWindow();
    }
    // Error Window: --> only if something went wrong!
    public void showErrorWindow(String errorType,String message) {
        new InformationWindowShower(Alert.AlertType.ERROR, errorType + "-Error", message).showInformationWindow();
    }
}

