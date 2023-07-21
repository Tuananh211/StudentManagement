package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminChangpassController implements Initializable {
    @FXML
    TextField idtxt;
    @FXML
    TextField oldtxt;
    @FXML
    TextField newtxt;
    @FXML
    TextField confirmtxt;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idtxt.setText(loginController.loginTeacher.getId());
    }

    public void onChangePass(ActionEvent actionEvent) {
        String pass=loginController.loginTeacher.getPass();
        String id = idtxt.getText();
        String oldpass = oldtxt.getText();
        String newpass= newtxt.getText();
        String confirmpass = confirmtxt.getText();
        if(oldpass==null|| oldpass.equals("")||!oldpass.equals(pass)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Mật khẩu chưa chính xác");
            alert.show();
            oldtxt.setText("");
            return;
        }
        if (newpass == null|| newpass.equals("")||newpass.equals(pass)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Hãy nhập mật khẩu mới khác với mật khẩu cũ");
            alert.show();
            return;
        }
        if(confirmpass.equals("")|| confirmpass== null||!confirmpass.equals(newpass)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Hãy xác nhận lại mật khẩu mới");
            alert.show();
            return;
        }
        ConnectController controller = new ConnectController();
        controller.updatePassTeacher(id,newpass);
        oldtxt.setText("");
        newtxt.setText("");
        confirmtxt.setText("");
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
