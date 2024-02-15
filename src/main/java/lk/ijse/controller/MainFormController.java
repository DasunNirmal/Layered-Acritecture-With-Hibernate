package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dto.StudentDto;

import java.sql.SQLException;

public class MainFormController {

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().grtBo(BOFactory.BOTypes.STUDENT);

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        int id = Integer.parseInt(txtID.getText());
        String name = txtName.getText();
        String address = txtAddress.getText();
        int phone_number = Integer.parseInt(txtPhoneNumber.getText());

        var dto = new StudentDto(id,name,address,phone_number);
        try {
            boolean isSaved = studentBO.save(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtID.getText();

        try {
            boolean isDeleted = studentBO.delete(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        int id = Integer.parseInt(txtID.getText());
        String name = txtName.getText();
        String address = txtAddress.getText();
        int phone_number = Integer.parseInt(txtPhoneNumber.getText());

        var dto = new StudentDto(id,name,address,phone_number);
        try {
            boolean isUpdated = studentBO.update(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void txtSearchOnAction(ActionEvent event) {
        String id = txtID.getText();

        try {
            StudentDto studentDto;
            studentDto = studentBO.searchStudents(id);
            if (studentDto != null) {
                txtID.setText(String.valueOf(studentDto.getId()));
                txtName.setText(studentDto.getName());
                txtAddress.setText(studentDto.getAddress());
                txtPhoneNumber.setText(String.valueOf(studentDto.getPhone_number()));
            } else {
                new Alert(Alert.AlertType.ERROR,"Student Doesn't exist").show();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void clearFields() {
        txtID.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtPhoneNumber.setText("");
    }
}
