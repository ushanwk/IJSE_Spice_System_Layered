package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginFormController {
    public Label txtSignUp;
    public AnchorPane pane;
    public JFXTextField txtUsername;
    public JFXPasswordField txtPassword;
    public Label txtSignUpAfter;
    public Group imgErrorMessageUsername;
    public Group imgErrorMessagePassword;
    public Text txtInvalid;

    static String userName = null;
    public Group imgErrorMessageUsernameWrong;

    public void initialize() {
        txtSignUpAfter.setVisible(false);

        imgErrorMessageUsernameWrong.setVisible(false);

        imgErrorMessageUsername.setVisible(false);
        imgErrorMessagePassword.setVisible(false);

        txtInvalid.setVisible(false);
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if(txtUsername.getText() .equals("CEO")  && txtPassword.getText() .equals("1234")){
            userName = "CEO";
            Navigation.navigate(Routes.CEO, pane);
        }else if(txtUsername.getText() .equals("HumanResource") && txtPassword.getText() .equals("1234")){
            userName = "HumanResource";
            Navigation.navigate(Routes.HR, pane);
        }else if(txtUsername.getText() .equals("Finance") && txtPassword.getText() .equals("1234")){
            userName = "Finance";
            Navigation.navigate(Routes.FINANCEMANAGER, pane);
        }else if(txtUsername.getText() .equals("Salesmen") && txtPassword.getText() .equals("1234")){
            userName = "Salesmen";
            Navigation.navigate(Routes.SALESMEN, pane);
        }else if(txtUsername.getText() .equals("Stock") && txtPassword.getText() .equals("1234")) {
            userName = "Stock";
            Navigation.navigate(Routes.STOCKMANAGER, pane);
        }else if(txtUsername.getText() .equals("") && txtPassword.getText() .equals("")){
            imgErrorMessageUsername.setVisible(true);
            imgErrorMessagePassword.setVisible(true);
        }else{
            txtUsername.clear();
            txtPassword.clear();
            txtUsername.requestFocus();
            txtInvalid.setVisible(true);

        }
    }

    public void lblSignUpOnClicked(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.SIGNUP, pane);
    }

    public void lblSignUpOnMouseEntered(MouseEvent mouseEvent) {
        txtSignUpAfter.setVisible(true);
    }

    public void lblSignUpOnMouseExited(MouseEvent mouseEvent) {
        txtSignUpAfter.setVisible(false);
    }

    public void txtUsernameOnAction(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) throws IOException {
        imgErrorMessageUsername.setVisible(false);
        imgErrorMessagePassword.setVisible(false);

        btnLoginOnAction(actionEvent);
    }

    public void txtUsernameOnMouseClicked(MouseEvent mouseEvent) {
        imgErrorMessageUsername.setVisible(false);
        imgErrorMessagePassword.setVisible(false);

        txtInvalid.setVisible(false);
    }

    public void txtPasswordOnMouseClicked(MouseEvent mouseEvent) {
        imgErrorMessageUsername.setVisible(false);
        imgErrorMessagePassword.setVisible(false);

        txtInvalid.setVisible(false);
    }

    public void txtUsernameOnKeyReleased(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("^[a-zA-Z1-9]*$");
        Matcher matcher = pattern.matcher(txtUsername.getText());

        boolean isMatch = matcher.matches();

        if(!isMatch){
            txtUsername.setFocusColor(Paint.valueOf("#F506FF"));
            imgErrorMessageUsernameWrong.setVisible(true);
        }else{
            txtUsername.setFocusColor(Paint.valueOf("#008cf7"));
            imgErrorMessageUsernameWrong.setVisible(false);
        }
    }

    public void txtPasswordOnKeyPressed(KeyEvent keyEvent) {
    }

    public void txtPasswordOnKeyRelesed(KeyEvent keyEvent) {

    }
}
