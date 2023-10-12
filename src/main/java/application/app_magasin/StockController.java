package application.app_magasin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StockController {

    @FXML
    private Button inventaireButton;

    @FXML
    private Button tvButton;

    @FXML
    private Button smButton;

    @FXML
    private Button gaButton;

    @FXML
    private TableView<?> tableView;

    @FXML
    private Button NouveauProdButton;

    @FXML
    private void initialize() {
        inventaireButton.setOnAction(this::handleButtonClick);
        tvButton.setOnAction(this::handleButtonClick);
        smButton.setOnAction(this::handleButtonClick);
        gaButton.setOnAction(this::handleButtonClick);
    }

    private void handleButtonClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        // Change the background color of the clicked button
        clickedButton.setStyle("-fx-background-color: #FF0000; ");

        // You can also reset the background color of other buttons here
        if (clickedButton != inventaireButton) {
            inventaireButton.setStyle("-fx-background-color: #47204E; ");
        }
        if (clickedButton != tvButton) {
            tvButton.setStyle("-fx-background-color: #47204E; ");
        }
        if (clickedButton != smButton) {
            smButton.setStyle("-fx-background-color: #47204E; ");
        }
        if (clickedButton != gaButton) {
            gaButton.setStyle("-fx-background-color: #47204E; ");
        }

        // Handle other actions you want to perform when a button is clicked
        if (clickedButton == inventaireButton) {
            // Show/hide the TableView when the "Inventaire de stock" button is clicked

        } else if (clickedButton == tvButton) {
            // Handle TV button click
        } else if (clickedButton == smButton) {
            // Handle SM button c lick
        } else if (clickedButton == gaButton) {
            // Handle GA button click
        }
    }

    @FXML
    private void handleNouveauProduit() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Nouveau_Produit.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Ajouter un Produit");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
