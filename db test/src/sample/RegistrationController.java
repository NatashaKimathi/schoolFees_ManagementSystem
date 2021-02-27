package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;


public class RegistrationController implements Initializable {

    @FXML
    private Button closebutton;
    @FXML
    private  Label registrationmessagelabel;
    @FXML
    private PasswordField passwordtextfield;
    @FXML
    private PasswordField confirmpasswordtextfield;
    @FXML
    private  Label confirmpasswordlabel;
    @FXML
    private  TextField firstnametextfield;
    @FXML
    private  TextField lastnametextfield;
    @FXML
    private  TextField usernametextfield;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerButtonOnAction(ActionEvent event) {

        //ENSURE NO FIELDS ARE LEFT BLANK
        if (!passwordtextfield.getText().isEmpty() && !confirmpasswordtextfield.getText().isEmpty() && !firstnametextfield.getText().isEmpty()
                && !lastnametextfield.getText().isEmpty() && !usernametextfield.getText().isEmpty()){

            //ENSURE PASSWORD AND CONFIRM PASSWORD MATCH
            if (passwordtextfield.getText().equals(confirmpasswordtextfield.getText())) {
                //IF PASSWORDS MATCH THEN WE PROCEED TO REGISTER USER TO THE DB
                registerUser();
                confirmpasswordlabel.setText("");

            }else{
                registrationmessagelabel.setText("");
                confirmpasswordlabel.setText("PasswordS do not match");
            }

        }else {
            registrationmessagelabel.setText("Please fill in all fields");

        }
    }

    public void registerUser() {

        databaseConnection connectNow = new databaseConnection();
        Connection connectDb = connectNow.getConnection();

        String firstName = firstnametextfield.getText();
        String lastName = lastnametextfield.getText();
        String userName = usernametextfield.getText();
        String password = passwordtextfield.getText();

        //HASH THE GIVEN PASSWORD
        String hashedPassword = hashPassword(password);

        String insertFields = "INSERT INTO users(firstname, lastname, username, password) VALUES ('";
        String insertValues = firstName + " ','"+ lastName + " ','" + userName + " ','" + hashedPassword + "')";
        String insertToRegister = insertFields + insertValues;

        try {

            Statement statement = connectDb.createStatement();
            statement.executeUpdate(insertToRegister);
            registrationmessagelabel.setText("User has been registered successfully");

        }catch (Exception e){
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
