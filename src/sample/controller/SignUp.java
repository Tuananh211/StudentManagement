package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.model.Teacher;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SignUp {
    @FXML
    TextField idtxt;
    @FXML
    TextField passtxt;
    @FXML
    TextField nametxt;
    @FXML
    TextField phonetxt;
    @FXML
    TextField emailtxt;
    @FXML
    TextField departtxt;
    @FXML
    TextField codetxt;

    @FXML
    AnchorPane signup;
    public void onConfirm(ActionEvent actionEvent) {
        String id = idtxt.getText();
        String pass= passtxt.getText();
        String name= nametxt.getText();
        String phone= phonetxt.getText();
        String email= emailtxt.getText();
        String depart= departtxt.getText();
        String code = codetxt.getText();
        ConnectController controller = new ConnectController();

        if(controller.checkTeacher(id,pass,name,phone,email,depart,code))
        {
            Teacher teacher = new Teacher(id,pass,name,phone,email,depart,code);
            List<Teacher> listTeacher= controller.getListTeacher();
            if(!listTeacher.contains(teacher)){
                controller.addTeacher(teacher);
                idtxt.setText("");
                passtxt.setText("");
                nametxt.setText("");
                phonetxt.setText("");
                emailtxt.setText("");
                departtxt.setText("");
                codetxt.setText("");
            }
           else {
                idtxt.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERROR");
                alert.setContentText("Tài khoản này đã tồn tại");
                alert.show();
                return;
            }
           }
        else return;
    }

    public void onBack(ActionEvent actionEvent) {
        Parent root = null;
        try {
            URL url = new File("src/sample/sample.fxml").toURI().toURL();
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
