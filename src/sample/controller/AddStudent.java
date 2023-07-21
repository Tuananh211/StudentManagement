package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import sample.model.Student;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class AddStudent {
    @FXML
    TextField idtxt;
   @FXML
   TextField nametxt;
   @FXML
   TextField detxt;
   @FXML
   TextField phonetxt;
   @FXML
   TextField emailtxt;
   @FXML
   TextField fathertxt;
   @FXML
   TextField momtxt;
   @FXML
   TextField yeartxt;
   @FXML
   TextField setxt;
   @FXML
   TextField addtxt;
   @FXML
   TextField resulttxt;
    public void onCrearStudent(ActionEvent actionEvent) {
        String id = idtxt.getText();
        String name = nametxt.getText();
        String department =detxt.getText();
        String phone = phonetxt.getText();
        String email= emailtxt.getText();
        String father= fathertxt.getText();
        String mother= momtxt.getText();
        String year= yeartxt.getText();
        String semester= setxt.getText();
        String address= addtxt.getText();
        String result = resulttxt.getText();
        ConnectController controller = new ConnectController();
        if(controller.checkStudent(id,name,department,phone,email,father,mother,year,semester,address,result)){
            Student student = new Student(id,name,department,phone,email,father,mother,Integer.parseInt(year),Integer.parseInt(semester),address,Float.parseFloat(result));
            List<Student> listStudent= controller.getListStudent();
            if(!listStudent.contains(student)){
                controller.addStudent(student);
                idtxt.setText("");
                nametxt.setText("");
                detxt.setText("");
                phonetxt.setText("");
                emailtxt.setText("");
                fathertxt.setText("");
                momtxt.setText("");
                yeartxt.setText("");
                setxt.setText("");
                addtxt.setText("");
                resulttxt.setText("");
            }
            else {
                idtxt.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setContentText("Sinh viên này đã tồn tại");
                alert.show();
                return;
            }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setContentText("Hãy điền đầy đủ thông tin");
                alert.show();
            }

    }

    public void onBackAdmin(ActionEvent actionEvent) {
        Parent root = null;
        try {
            URL url = new File("src/sample/view/admin.fxml").toURI().toURL();
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
