package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button studentButton;

    @FXML
    private Button studentRegisterbutton;

    @FXML
    private Button feesPayment;

    @FXML
    private Button classList;

    @FXML
    private Button feesArreas;

    @FXML
    private Button finance;

    @FXML
    private Button paymentList;

    @FXML
    private Pane pane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    public void clickList(ActionEvent event){
        if(event.getSource() == studentRegisterbutton){
            studentRegisterbutton.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),CornerRadii.EMPTY,Insets.EMPTY)));
        }
        else
            if(event.getSource()== studentButton){

        }
        else
            if(event.getSource()== feesPayment){

        }
        else
            if(event.getSource()== classList){

        }
        else
            if(event.getSource()== feesArreas){

        }
        else
            if(event.getSource()== finance){

        }
        else
            if(event.getSource()== paymentList){

        }
         else
             if(event.getSource()== pane){

        }
    }

}
