package application.app_magasin;


import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    public Connection databaseLink;
    public Connection getConnection(){
        String databaseName="app_magasin";
        String databaseUser="root";
        String databasePassword="Hassan1152002";
        String url="jdbc:mysql://localhost/"+databaseName;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink=DriverManager.getConnection(url,databaseUser,databasePassword);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
}
