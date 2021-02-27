package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Testdb {

    public static void main(String[] args) {
        testdb();
    }


    public static void testdb() {

        databaseConnection connectNow = new databaseConnection();
        Connection connectDb = connectNow.getConnection();


        String query = "SELECT id, firstname, lastname, username, password FROM users";

        try {
            Statement statement = connectDb.createStatement();
            ResultSet queryResult = statement.executeQuery(query);

            System.out.println("ID\t\tFirstName\tLastName\tUserName\tPassoword");
            while (queryResult.next()){
                System.out.println(queryResult.getString(1) + "\t\t" +
                        queryResult.getString(2) + "\t\t"
                        + queryResult.getString(3) + "\t\t"
                        + queryResult.getString(4) + "\t\t"
                        + queryResult.getString(5 ));


            }

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
}
