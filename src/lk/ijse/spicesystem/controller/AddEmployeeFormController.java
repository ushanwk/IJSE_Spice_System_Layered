package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import lk.ijse.spicesystem.model.EmployeeModel;
import lk.ijse.spicesystem.to.Employee;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;
import org.controlsfx.control.Notifications;

import javax.print.attribute.standard.MediaSize;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddEmployeeFormController {
    public Label lblEmpId;
    public JFXTextField txtFName;
    public JFXTextField txtLName;
    public JFXTextField txtEmail;
    public JFXTextField txtSalaryPerDay;
    public JFXTextField txtJobRole;
    public JFXTextField txtAddress;
    public AnchorPane dashboardPane;

    public void initialize(){
        txtAddress.clear();
        txtEmail.clear();
        txtFName.clear();
        txtLName.clear();
        txtJobRole.clear();
        txtSalaryPerDay.clear();


        try {
            lblEmpId.setText(EmployeeModel.nextEmployeeId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSubmitOnAction(ActionEvent actionEvent) {

        Employee employee = new Employee(lblEmpId.getText(), txtFName.getText(), txtLName.getText(), txtEmail.getText(), Double.valueOf(txtSalaryPerDay.getText()), txtAddress.getText(), txtJobRole.getText());

        try {
            boolean isAdded = EmployeeModel.addEmployeeDetail(employee);

            if(isAdded){

                Image image = new Image("/lk/ijse/spicesystem/asset/correct.png");
                Notifications notifications = Notifications.create();
                notifications.graphic(new ImageView(image));
                notifications.text("Added Suuccesful");
                notifications.title("Spice System");
                notifications.hideAfter(Duration.seconds(3));
                notifications.show();

                initialize();

            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EMPLOYEEDASHBOARD, dashboardPane);
    }

    public void txtFnameOnKeyReleased(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher = pattern.matcher(txtFName.getText());

        boolean isMatch = matcher.matches();

        if(!isMatch){
            txtFName.setFocusColor(javafx.scene.paint.Paint.valueOf("#F506FF"));
        }else{
            txtFName.setFocusColor(Paint.valueOf("#07d5e0"));
        }
    }

    public void txtLnameOnKeyReleased(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher = pattern.matcher(txtLName.getText());

        boolean isMatch = matcher.matches();

        if(!isMatch){
            txtLName.setFocusColor(javafx.scene.paint.Paint.valueOf("#F506FF"));
        }else{
            txtLName.setFocusColor(Paint.valueOf("#07D5E0"));
        }
    }
}
