import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Window settings:
        primaryStage.setTitle("Password-Manager");

        //
        StackPane root = new StackPane();
        root.getChildren().addAll();
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}