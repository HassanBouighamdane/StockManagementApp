package application.app_magasin;

import application.app_magasin.MainClasses.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategorieController  {

    @FXML
    private Button AjouterCategoorieButton;

    @FXML
    private Button Afficher;
    @FXML
    private Button SupprimerCategoorieButton;

    @FXML
    private Button AnnulezButton;
    @FXML
    private ImageView categoryImage;

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField NomCat_Textfield;

    @FXML
    private Label MessageAjouterCatLabel;

    private Connection establishConnection() throws SQLException {
        Connection connection = DBConnection.getConnection();
        return connection;
    }

    @FXML
    private void initialize() {
        // When the controller is initialized, retrieve and display category data
        retrieveAndDisplayCategories();
    }

    private void retrieveAndDisplayCategories() {
        try {
            Connection connection = establishConnection();

            if (connection != null) {
                // Create a SQL statement
                Statement statement = connection.createStatement();

                // Execute a query to retrieve categories from the database
                ResultSet resultSet = statement.executeQuery("SELECT id_cat, name FROM categorie");

                int row = 0; // Start with the first row
                while (resultSet.next()) {
                    int idCat = resultSet.getInt("id_cat");
                    String name = resultSet.getString("name");

                    // Create a custom control (VBox) for each category
                    VBox categoryBox = new VBox();
                    categoryBox.setSpacing(10);

                    // Create a label to display the category name
                    Label nameLabel = new Label(name);

                    // Add the label to the VBox
                    categoryBox.getChildren().add(nameLabel);

                    // Add the VBox to the GridPane
                    gridPane.add(categoryBox, 0, row);

                    row++; // Move to the next row
                }

                // Close the database resources
                resultSet.close();
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleAnnulezButtonClick() {
        // Close the stage to return to the main scene
        Stage stage = (Stage) AnnulezButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleAjouterButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("categorie_Ajout.fxml"));
            Parent root = loader.load();


            Stage stage = new Stage();
            stage.setTitle("Ajouter une Categorie");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
