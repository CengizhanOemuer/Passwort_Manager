package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class InformationWindowShower {
    // Attributes:
    private AlertType alertType;
    private String title;
    private String message;

    // Constructor:
    public InformationWindowShower(AlertType alertType, String title, String message) {
        this.alertType = alertType;
        this.title = title;
        this.message = message;
        if (message == null || message.isEmpty()) {
            this.message = "Message not found (404)";
        }
    }

    // Methods:
    public void showInformationWindow() {
        Alert alert = new Alert(this.alertType);
        alert.setTitle(this.title);
        alert.setContentText(this.message);
        alert.showAndWait();
    }

}
