package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class databaseConnection {
    private Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "uinfo";  //database name
        String databaseUser = "root";   //username of database
        String databasePassword = "";   //password of the database
        String url = "jdbc:mysql://localhost:3306/" + databaseName; //database link

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        //System.out.println(databaseLink);
        return databaseLink;
    }
}
