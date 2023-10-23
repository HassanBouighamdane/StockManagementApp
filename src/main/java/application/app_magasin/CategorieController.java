package application.app_magasin;

import application.app_magasin.MainClasses.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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




    private void BDCategorie() {
        try {
            gridPane.getChildren().clear();

            // Create a single database connection for the entire method
            DBConnection connect = new DBConnection();
            Connection connectDB = connect.getConnection();

            String query = "SELECT * FROM categorie;";

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);

            int row = 0;
            int col = 0;

            while (queryResult.next()) {
                String nom_cat = queryResult.getString("nom_cat");
                //String imagePath = queryResult.getString("ImageCat"); // Assuming the image path column is "ImageCat"

                // Load the FXML layout for the button
                FXMLLoader loader = new FXMLLoader(getClass().getResource("categorie_button.fxml"));
                Button button = loader.load();
                //CategorieButtonController buttonController = loader.getController();

                // Set the text of the button
                button.setText(nom_cat);

                Insets buttonMargins = new Insets(5, 5, 5, 5);
                GridPane.setMargin(button, buttonMargins);



               /* // Load the image if the imagePath is not null or empty
                if (imagePath != null && !imagePath.isEmpty()) {
                    Image image = new Image(imagePath);
                    buttonController.setCategoryImage(image);
                }
                */
                gridPane.add(button, col, row);

                // Move to the next cell in the GridPane
                col++;
                if (col == 5) { // Assuming you want 3 columns per row, adjust as needed
                    col = 0;
                    row++;
                }
            }

            // Close the resources
            queryResult.close();
            statement.close();
            connectDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void handlerinsertCategorieDB() {
        DBConnection connect = new DBConnection();
        Connection connectDB = connect.getConnection();
        String nomCat=NomCat_Textfield.getText();
        Stage stage = (Stage) AnnulezButton.getScene().getWindow();





        try {
            if(nomCat.length()==0){MessageAjouterCatLabel.setText("Ajouter un nom");}

            else{
                String query = "INSERT INTO categorie (nom_cat) VALUES ('" + nomCat + "')";

                Statement statement = connectDB.createStatement();
                statement.executeUpdate(query);
                statement.close();
                connectDB.close();
                stage.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleCategoryButtonClick() {
        // Call the method to retrieve and display data from the 'categorie' table
        BDCategorie();
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
