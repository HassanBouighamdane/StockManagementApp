package application.app_magasin;

import application.app_magasin.MainClasses.DBConnection;
import application.app_magasin.MainClasses.EntreeData;
import application.app_magasin.MainClasses.Fournisseur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class EntreesController {


    @FXML
    private TableView<EntreeData> tableView;

    @FXML
    private TableColumn<EntreeData, Date> DateIN; // Specify the correct types for TableColumn

    @FXML
    private TableColumn<EntreeData, String> referenceIN;

    @FXML
    private TableColumn<EntreeData, String> produit;

    @FXML
    private TableColumn<EntreeData, Integer> QuantiteIN;

    @FXML
    private TableColumn<EntreeData, Integer> QparCtnIN;

    @FXML
    private TableColumn<EntreeData, Double> prixAchat;

    @FXML
    private TableColumn<EntreeData, Double> MontantIN;

    @FXML
    private TableColumn<EntreeData, Fournisseur> Fournisseur;

    private ObservableList<EntreeData> data;



    public void initialize() {
        // Initialize the TableView and bind it to the data
        initializeTableView();
        // Load data from the database
        loadEntreeData();
    }

    private void initializeTableView() {
        DateIN.setCellValueFactory(new PropertyValueFactory<>("date"));
        referenceIN.setCellValueFactory(new PropertyValueFactory<>("referenceIN"));
        produit.setCellValueFactory(new PropertyValueFactory<>("produit"));
        QuantiteIN.setCellValueFactory(new PropertyValueFactory<>("quantiteIN"));
        QparCtnIN.setCellValueFactory(new PropertyValueFactory<>("qparCtnIN"));
        prixAchat.setCellValueFactory(new PropertyValueFactory<>("prixAchat"));
        MontantIN.setCellValueFactory(new PropertyValueFactory<>("montantIN"));
        Fournisseur.setCellValueFactory(new PropertyValueFactory<>("fournisseur"));
    }

    private void loadEntreeData() {
        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Entree");

            data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                Date date = resultSet.getDate("Date");
                String referenceIN = resultSet.getString("id_entree");
                String produit = resultSet.getString("Produit");
                int QuantiteIN = resultSet.getInt("Quantite");
                int QparCtnIN = resultSet.getInt("QparCtn");
                double prixAchat = resultSet.getDouble("Prix_Achat");
                double montantIN = resultSet.getDouble("Montant_Total");
                int fournisseurId = resultSet.getInt("id_fournisseur");

                // Fetch supplier information using the Fournisseur class
                Fournisseur fournisseur = getFournisseurById(fournisseurId);

                data.add(new EntreeData(date, fournisseur, montantIN, QparCtnIN, QuantiteIN, prixAchat, produit, referenceIN));
            }

            tableView.setItems(data);

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Fournisseur getFournisseurById(int fournisseurId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Fournisseur fournisseur = null;

        try {
            // Establish a database connection
            DBConnection dbConnection = new DBConnection();
            connection = dbConnection.getConnection();

            // Prepare a SQL query to fetch Fournisseur by ID
            String query = "SELECT * FROM Fournisseur WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, fournisseurId);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if a result was found
            if (resultSet.next()) {
                // Create a Fournisseur object from the retrieved data
                String name = resultSet.getString("name");
                int nbr_entree = resultSet.getInt("nbr_entre");
                String telephone = resultSet.getString("Telephone");

                fournisseur = new Fournisseur(name, nbr_entree, telephone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the database resources
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return fournisseur;
    }

}
