package application.app_magasin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane; // Import the necessary layout class
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home.fxml"));
        Pane root = fxmlLoader.load(); // Assuming your root layout in home.fxml is a Pane

        // Create the scene and set it to the stage
        Scene scene = new Scene(root);


        stage.setFullScreen(true);

        // Set the stage properties
        stage.setTitle("Stock magasin");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
