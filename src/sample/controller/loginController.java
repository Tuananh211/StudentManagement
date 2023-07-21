package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import sample.model.Student;
import sample.model.Teacher;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    @FXML
    ChoiceBox<String> choicebox;
    private String[] items = {"Student", "Teacher"};

    @FXML
    TextField idtxt;
    @FXML
    TextField passtxt;

    static Teacher loginTeacher;
    static Student loginStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choicebox.getItems().addAll(items);
//        choicebox.setOnAction(this::getFood);
    }

    public void onback(ActionEvent actionEvent) {
        Parent root = null;
        try {
            URL url = new File("src/sample/sample.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onLogin(ActionEvent actionEvent) {
        ConnectController controller = new ConnectController();
        String id = idtxt.getText();
        String pass = passtxt.getText();
        String kind = choicebox.getValue();
        System.out.println(kind);
        if (kind == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Bạn là giáo viên hay sinh viên");
            alert.show();
            return;
        }
        if (kind.equals("Teacher")) {
            loginTeacher = controller.login(id, pass);
            if (loginTeacher == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setContentText("Sai thông tin đăng nhập");
                alert.show();
                idtxt.setText("");
                passtxt.setText("");
            } else {
                Parent root = null;
                try {
                    URL url = new File("src/sample/view/admin.fxml").toURI().toURL();
                    root = FXMLLoader.load(url);
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            loginStudent = controller.loginStudent(id, pass);
            if (loginStudent == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setContentText("Sai thông tin đăng nhập");
                alert.show();
                idtxt.setText("");
                passtxt.setText("");
            } else {
                Parent root = null;
                try {
                    URL url = new File("src/sample/view/Studentinfo.fxml").toURI().toURL();
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

    }
}
