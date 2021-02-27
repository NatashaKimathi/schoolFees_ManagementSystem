package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button cancelbutton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField unamefield;
    @FXML
    private TextField passwordfield;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void loginButtonOnAction(ActionEvent event){

        if (!unamefield.getText().isEmpty() && !passwordfield.getText().isEmpty()){
            validateLogin();

        }else {
            loginMessageLabel.setText("Please enter username and password");

        }

    }

    public void cancelButtonOnAction(){
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin(){
        databaseConnection connectNow = new databaseConnection();
        Connection connectDb = connectNow.getConnection();

        String hashedPassword = hashPassword(passwordfield.getText());

        String verifyLogin = "SELECT count(1) FROM users WHERE username = '" + unamefield.getText() + "'AND password ='"
                + hashedPassword + "'";

        try {
            Statement statement = connectDb.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    //createAccountForm();
                    createLayout();

                }else{
                    loginMessageLabel.setText("Invalid login. Please try again");
                }

            }

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void createAccountForm(){

        try {

            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 520, 515));
            registerStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void createLayout(){

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/teacher_fxml/truUi.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.DECORATED);
            registerStage.setScene(new Scene(root, 1367, 704));
            registerStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


    //    FUNCTION TO HASH PASSWORD FOR SECURITY
    public String hashPassword(String password) {
        String result = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(password.getBytes(StandardCharsets.UTF_8));

            byte[] resultByteArray =  messageDigest.digest();

            StringBuilder stringBuilder = new StringBuilder();

            for (byte b: resultByteArray) {
                stringBuilder.append(String.format("%02x",b));
            }

            result = stringBuilder.toString();

        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
            e.getCause();
        }
        return result;
    }

}
