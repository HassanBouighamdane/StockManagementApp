package application.app_magasin;

import application.app_magasin.MainClasses.*;
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
    private TableColumn<EntreeData, String> depot;

    @FXML
    private TableColumn<EntreeData, String> produit;

    @FXML
    private TableColumn<EntreeData, Integer> QuantiteIN;

    @FXML
    private TableColumn<EntreeData, Integer> QparCtnIN;

    @FXML
    private TableColumn<EntreeData, Double> prixAchat;


    @FXML
    private TableColumn<EntreeData, Fournisseur> Fournisseur;
    @FXML
    private TableColumn<EntreeData,Double> MontantTotal;

    private ObservableList<EntreeData> data;





    public void initialize() {
        // Initialize the TableView and bind it to the data
        initializeTableView();
        // Load data from the database
        loadEntreeData();
    }

    private void initializeTableView() {
        DateIN.setCellValueFactory(new PropertyValueFactory<>("date"));
        depot.setCellValueFactory(new PropertyValueFactory<>("depot"));
        MontantTotal.setCellValueFactory(new PropertyValueFactory<>("MontantTotal"));
        produit.setCellValueFactory(new PropertyValueFactory<>("produit"));
        QuantiteIN.setCellValueFactory(new PropertyValueFactory<>("quantiteIN"));
        QparCtnIN.setCellValueFactory(new PropertyValueFactory<>("qparCtnIN"));
        prixAchat.setCellValueFactory(new PropertyValueFactory<>("prixAchat"));
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


                Date date = Date.valueOf(resultSet.getString("date"));

                String produitID = resultSet.getString("id_prod");
                int QuantiteIN = resultSet.getInt("Quantite");
                int QparCtnIN = resultSet.getInt("QparCtn");
                double prixAchat = resultSet.getDouble("Prix_Achat");
                String depotId=resultSet.getString("id_depot");
                int fournisseurId = resultSet.getInt("id_four");

                double MontantTotal=QuantiteIN*prixAchat;

                // Fetch supplier information using the Fournisseur class
                Fournisseur fournisseur = getFournisseurById(fournisseurId);
                Produit produit=getProduitByID(produitID);
                Depot depot =getDepotById(depotId);


                data.add(new EntreeData(date, fournisseur,depot ,QparCtnIN, QuantiteIN, prixAchat, produit,MontantTotal));
            }

            tableView.setItems(data);

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private Depot getDepotById(String depotId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Depot depot=null;

        try {
            // Establish a database connection
            DBConnection dbConnection = new DBConnection();
            connection = dbConnection.getConnection();

            // Prepare a SQL query to fetch Fournisseur by ID
            String query = "SELECT * FROM depot WHERE Id_depot = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, depotId);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if a result was found
            if (resultSet.next()) {
                // Create a Fournisseur object from the retrieved data
                String name = resultSet.getString("name");


                depot = new Depot(depotId,name);
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
        return depot;
    }

    private Produit getProduitByID(String produitID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Produit produit=null;
        try {
            // Establish a database connection
            DBConnection dbConnection = new DBConnection();
            connection = dbConnection.getConnection();
            // Prepare a SQL query to fetch Fournisseur by ID
            String query = "SELECT * FROM produit WHERE id_produit = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, produitID);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if a result was found
            if (resultSet.next()) {
                String designation = resultSet.getString("designation");
                int id_four=resultSet.getInt("id_four");
                int id_cat=resultSet.getInt("id_cat");
                
                Categorie categorie =getCategorieBYID(id_cat);
                Fournisseur fournisseur=getFournisseurById(id_four);
                produit = new Produit(produitID,categorie,designation,fournisseur);
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
        return produit;
    }

    private Categorie getCategorieBYID(int idCat) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Categorie categorie=null;


        try {
            // Establish a database connection
            DBConnection dbConnection = new DBConnection();
            connection = dbConnection.getConnection();

            // Prepare a SQL query to fetch Fournisseur by ID
            String query = "SELECT * FROM categorie WHERE id_cat = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idCat);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if a result was found
            if (resultSet.next()) {
                // Create a Fournisseur object from the retrieved data
                int id_cat=resultSet.getInt("id_cat");
                String name = resultSet.getString("name");

                categorie = new Categorie(id_cat,name);
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
        return categorie;
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
            String query = "SELECT * FROM Fournisseur WHERE id_fournisseur = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, fournisseurId);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if a result was found
            if (resultSet.next()) {
                // Create a Fournisseur object from the retrieved data
                String name = resultSet.getString("name");
                String telephone = resultSet.getString("Phone");

                fournisseur = new Fournisseur(name,  telephone);
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
