package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Controller {

    private void switchFml(String fml) {
        Stage stage = new Stage();
        Pane myPane = null;
        URL url = null;
        try {
            url = new File(fml).toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            myPane = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

    public void onsignup(ActionEvent actionEvent){
        Parent root = null;
        try {
            URL url = new File("src/sample/view/sign_up.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onlogin(ActionEvent actionEvent) {
        Parent root = null;
        try {
            URL url = new File("src/sample/view/login.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
