package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import javax.print.attribute.standard.MultipleDocumentHandling;
import java.net.URL;


public class Uiloader {

    private Pane view;

    public Pane getPage(String filename) {
        try {
            URL fileurl = MultipleDocumentHandling.class.getResource("/teacher_fxml/" + filename +".fxml");
            if (fileurl == null) {
                throw new java.io.FileNotFoundException("FXML file not found");
            }

            view = new FXMLLoader().load(fileurl);

        }catch(Exception e){
            System.out.println("No page" + filename + "please check fxmlloader");
            e.printStackTrace();
            e.getCause();

        }
        return view;
    }
}
