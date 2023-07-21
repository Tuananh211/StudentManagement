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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.Student;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EditStudent implements Initializable {
    @FXML
    ChoiceBox<String> listID;
    @FXML
    TextField nametxt;
    @FXML
    TextField phonetxt;
    @FXML
    TextField detxt;
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

    ConnectController controller = new ConnectController();

    public void onUpdateStudent(ActionEvent actionEvent) {
        String id = listID.getValue();
        String name = nametxt.getText();
        String phone = phonetxt.getText();
        String department = detxt.getText();
        String email = emailtxt.getText();
        String father = fathertxt.getText();
        String mother = momtxt.getText();
        String year = yeartxt.getText();
        String semester = setxt.getText();
        String address = addtxt.getText();
        String result = resulttxt.getText();
        if (controller.checkUpdateStudent(id, name, department, phone, email, father, mother, year, semester, address, result)) {
            Student student = new Student(id, name, department, phone, email, father, mother, Integer.parseInt(year), Integer.parseInt(semester), address, Float.parseFloat(result));
            controller.updateStudent(student);
            nametxt.setText("");
            detxt.setText("");
            phonetxt.setText("");
            emailtxt.setText("");
            fathertxt.setText("");
            momtxt.setText("");
            yeartxt.setText("");
            yeartxt.setText("");
            setxt.setText("");
            addtxt.setText("");
            resulttxt.setText("");

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Hãy điền đầy đủ các thông tin");
            alert.show();
        }
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
        List<String> listsID = controller.getListID();
        for (String s : listsID
        ) {
            listID.getItems().add(s);
        }
    }

    public void onFill(ActionEvent actionEvent) {
        Student student = controller.getStudent(listID.getValue());
        nametxt.setText(student.getName());
        detxt.setText(student.getDepartment());
        phonetxt.setText(student.getPhone());
        emailtxt.setText(student.getEmail());
        fathertxt.setText(student.getFather());
        momtxt.setText(student.getMother());
        yeartxt.setText(String.valueOf(student.getYear()));
        setxt.setText(String.valueOf(student.getSemester()));
        addtxt.setText(student.getAddress());
        resulttxt.setText(String.valueOf(student.getResult()));
    }
}
