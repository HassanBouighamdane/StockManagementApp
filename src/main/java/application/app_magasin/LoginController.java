package application.app_magasin;

import application.app_magasin.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    @FXML
    public Button loginButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField utilisateurTF;
    @FXML
    private PasswordField passwordPF;


    public void loginButtonAction(ActionEvent e){

        if(utilisateurTF.getText().isBlank()==false && passwordPF.getText().isBlank()==false){
            validateLogin();
        }
        else{
            loginMessageLabel.setText("Entrer utilisateur et mot de passe");
        }
    }
    public  void cancelButtonAction(ActionEvent e){
        Stage stage =(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }



    public void validateLogin(){
        DBConnection connect=new DBConnection();
        Connection connectDB=connect.getConnection();

        String verifyLogin="Select count(1) from utilisateur where username='"+utilisateurTF.getText()+"' and password='"+passwordPF.getText()+"'";
        try {
            Statement statement=connectDB.createStatement();
            ResultSet queryResult=statement.executeQuery(verifyLogin);
            while(queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
                    Parent homePage = loader.load();
                    Scene scene = new Scene(homePage);

                    // Get the current stage and set the new scene
                    Stage stage = (Stage) utilisateurTF.getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                }else {
                    loginMessageLabel.setText("Invalid utilisateur ou mot de passe");

                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}