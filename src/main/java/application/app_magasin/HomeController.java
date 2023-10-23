package application.app_magasin;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HomeController implements Initializable {


    @FXML
    private MenuButton languageButton;

    @FXML
    private AnchorPane anchorPaneCenter;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button LogoutButton;

    @FXML
    private Button stockButton;
    @FXML
    private Button EntreeButton;
    @FXML
    private Button SortieButton;
    @FXML
    private Button transactionButton;
    @FXML
    private Button categorieButton;
    @FXML
    private Button fournisseurButton;
    @FXML
    private Button home;

    @FXML
    private Button stockHomeButton;
    @FXML
    private Button EntreeHomeButton;
    @FXML
    private Button SortieHomeButton;
    @FXML
    private Button transactionHomeButton;
    @FXML
    private Button categorieHomeButton;
    @FXML
    private Button fournisseurHomeButton;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
// Initialize the action handlers for the buttons

    }
    public void handleButtonClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        // Change the background color of the clicked button
        clickedButton.setStyle("-fx-background-color: #FF0000; ");

        if (clickedButton != stockButton) {
            stockButton.setStyle("-fx-background-color: #47204E; ");
        }
        if (clickedButton != EntreeButton) {
            EntreeButton.setStyle("-fx-background-color: #47204E; ");
        }
        if (clickedButton != SortieButton) {
            SortieButton.setStyle("-fx-background-color: #47204E; ");
        }
        if (clickedButton != categorieButton) {
            categorieButton.setStyle("-fx-background-color: #47204E; ");
        }
        if (clickedButton != transactionButton) {
            transactionButton.setStyle("-fx-background-color: #47204E; ");
        }
        if (clickedButton != fournisseurButton) {
            fournisseurButton.setStyle("-fx-background-color: #47204E; ");
        }
        if (clickedButton != home) {
            home.setStyle("-fx-background-color: #47204E; ");
        }

    }

    public void frenchLangauge(ActionEvent actionEvent) {
        languageButton.setText("FR");
    }
    public void arabicLangauge(ActionEvent actionEvent) {
        languageButton.setText("AR");
    }


    public void home(MouseEvent mouseEvent) {
        borderPane.setCenter(anchorPaneCenter);
    }


    public void stock(MouseEvent mouseEvent) {
        loadPage("Stock");
    }

    public void categorie(MouseEvent mouseEvent) {loadPage("Categorie");}

    public void entrees(MouseEvent mouseEvent){
        loadPage("Entrees");
    }

    public void sorties(MouseEvent mouseEvent){
        loadPage("Sorties");
    }
    public void transaction(MouseEvent mouseEvent) {
        loadPage("Transaction");
    }
    public void fournisseur(MouseEvent mouseEvent) { loadPage("Fournisseur");
    }

    public void logout(ActionEvent e) {
        Stage stage =(Stage) LogoutButton.getScene().getWindow();
        stage.close();

    }

    private void loadPage(String page)  {
        Parent root=null;

        try {
            root= FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        borderPane.setCenter(root);
    }


}
