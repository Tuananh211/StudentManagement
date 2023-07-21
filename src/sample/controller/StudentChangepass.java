package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentChangepass implements Initializable {
    @FXML
    TextField idtxt;
    @FXML
    TextField oldtxt;
    @FXML
    TextField newtxt;
    @FXML
    TextField confirmtxt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idtxt.setText(loginController.loginStudent.getId());
    }

    public void onChangePass(ActionEvent actionEvent) {
        String pass=loginController.loginStudent.getPass();
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
        controller.updatePassStudent(id,newpass);
        oldtxt.setText("");
        newtxt.setText("");
        confirmtxt.setText("");
    }

    public void onBack(ActionEvent actionEvent) {
        Parent root = null;
        try {
            URL url = new File("src/sample/view/Studentinfo.fxml").toURI().toURL();
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
