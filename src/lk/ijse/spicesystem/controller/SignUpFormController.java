package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;

public class SignUpFormController {
    public AnchorPane pane;
    public JFXTextField txtEmployeeId;
    public JFXTextField txtUserName;
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public JFXTextField txtOtp;
    public Label lblLoginBefore;
    public Label lblLoginAfter;

    public void initialize(){
        lblLoginBefore.setVisible(true);
        lblLoginAfter.setVisible(false);
    }

    public void btnSendOtpOnAction(ActionEvent actionEvent) {
    }

    public void lblLogInOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, pane);
    }

    public void btnSignUpOnAction(ActionEvent actionEvent) {
    }

    public void lblLoginOnMouseEntered(MouseEvent mouseEvent) {
        lblLoginBefore.setVisible(false);
        lblLoginAfter.setVisible(true);
    }

    public void lblLoginOnMouseExit(MouseEvent mouseEvent) {
        lblLoginBefore.setVisible(true);
        lblLoginAfter.setVisible(false);
    }

    public void closeOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void txtEmployeeIdOnAction(ActionEvent actionEvent) {
        txtUserName.requestFocus();
    }

    public void txtUsernameOnAction(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }

    public void txtEmailOnAction(ActionEvent actionEvent) {
        txtOtp.requestFocus();
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) {
        txtEmail.requestFocus();
    }

    public void txtOtpOnAction(ActionEvent actionEvent) {
        btnSendOtpOnAction(actionEvent);
    }
}
