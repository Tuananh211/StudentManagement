package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminController implements Initializable {
    @FXML
    Label idlbe;
    @FXML
    Label namelbe;
    @FXML
    Label delbe;
    @FXML
    Label phonelbe;
    @FXML
    Label emaillbe;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idlbe.setText(loginController.loginTeacher.getId());
        namelbe.setText(loginController.loginTeacher.getName());
        delbe.setText(loginController.loginTeacher.getDepartment());
        phonelbe.setText(loginController.loginTeacher.getPhone());
        emaillbe.setText(loginController.loginTeacher.getEmail());
    }

    public void onBackLogin(ActionEvent actionEvent) {
        Parent root = null;
        try {
            URL url = new File("src/sample/view/login.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onChangepass(ActionEvent actionEvent) {
        Parent root = null;
        try {
            URL url = new File("src/sample/view/AdminChangpass.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onEditStudent(ActionEvent actionEvent) {
        Parent root = null;
        try {
            URL url = new File("src/sample/view/editStudent.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onAddStudent(ActionEvent actionEvent) {
        Parent root = null;
        try {
            URL url = new File("src/sample/view/addStudent.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onDeleteStudent(ActionEvent actionEvent) {
        Parent root = null;
        try {
            URL url = new File("src/sample/view/deleteStudent.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
