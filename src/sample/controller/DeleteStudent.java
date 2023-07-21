package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteStudent implements Initializable {
    @FXML
    ChoiceBox<String> listID;
    List<String> item=null;
    ConnectController controller = new ConnectController();

    public void onDelete(ActionEvent actionEvent) {
        String id = listID.getValue();
        controller.deleteStudent(id);
    }

    public void onBackAdmin(ActionEvent actionEvent) {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        item = controller.getListID();
        for (String s : item
        ) {
            listID.getItems().add(s);
        }
    }
}
