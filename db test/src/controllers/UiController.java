package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.net.URL;
import java.util.ResourceBundle;

public class UiController implements Initializable {

    @FXML
    private Button studentButton;

    @FXML
    private Button registerStudent;

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
    private BorderPane mainpane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //LOADS DIFFERENT FXML FILES UPON BUTTON CLICKS
    public void clickNavigation(ActionEvent event){

        Uiloader load = new Uiloader();

        try {

            Parent root;
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.DECORATED);

            if(event.getSource() == registerStudent){
                Pane view = load.getPage("registerStudent");
                mainpane.setCenter(view);

            } else if(event.getSource() == studentButton){
                Pane view = load.getPage("studentclasslist");
                mainpane.setCenter(view);

            } else if(event.getSource() == feesPayment){
                Pane view = load.getPage("feePayment");
                mainpane.setCenter(view);

            } else if(event.getSource() == classList){
                Pane view = load.getPage("studentclasslist");
                mainpane.setCenter(view);

            } else if(event.getSource() == feesArreas){
                Pane view = load.getPage("feesArrears");
                mainpane.setCenter(view);

            } else if(event.getSource() == finance){
                Pane view = load.getPage("feesArrears1");
                mainpane.setCenter(view);

            } else if(event.getSource() == paymentList){
                Pane view = load.getPage("paymentList");
                mainpane.setCenter(view);

            }

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

}
