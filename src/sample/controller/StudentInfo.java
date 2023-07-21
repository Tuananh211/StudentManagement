package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
public class StudentInfo implements Initializable {
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
    @FXML
    Label fatherlbe;
    @FXML
    Label motherlbe;
    @FXML
    Label yearlbe;
    @FXML
    Label semeslbe;
    @FXML
    Label addlbe;
    @FXML
    Label resultlbe;
    public void onChange(ActionEvent actionEvent) {
        Parent root = null;
        try {
            URL url = new File("src/sample/view/StudentChangepass.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onBacklogin(ActionEvent actionEvent) {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String id = loginController.loginStudent.getId();
        String name=loginController.loginStudent.getName();
        String department = loginController.loginStudent.getDepartment();
        String phone= loginController.loginStudent.getPhone();
        String email=loginController.loginStudent.getEmail();
        String father=loginController.loginStudent.getFather();
        String mother=loginController.loginStudent.getMother();
        int year=loginController.loginStudent.getYear();
        int semester =loginController.loginStudent.getSemester();
        String address=loginController.loginStudent.getAddress();
        float result =loginController.loginStudent.getResult();
        idlbe.setText(id);
        namelbe.setText(name);
        delbe.setText(department);
        phonelbe.setText(phone);
        emaillbe.setText(email);
        fatherlbe.setText(father);
        motherlbe.setText(mother);
        yearlbe.setText(String.valueOf(year));
        semeslbe.setText(String.valueOf(semester));
        addlbe.setText(address);
        resultlbe.setText(String.valueOf(result));
    }
}
