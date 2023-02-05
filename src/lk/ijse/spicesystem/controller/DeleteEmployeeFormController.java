package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.spicesystem.model.EmployeeModel;
import lk.ijse.spicesystem.to.Employee;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteEmployeeFormController {
    public JFXComboBox cmbEmployeeId;
    public Label lblFirstName;
    public Label lblSecondName;
    public Label lblEmail;
    public Label lblSalaryPerDay;
    public Label lblAddress;
    public Label lblJobRole;
    public AnchorPane dashboardPane;

    public void initialize(){
        try {
            cmbEmployeeId.setItems(EmployeeModel.getAllEmpId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void cmbEmployeeIdOnAction(ActionEvent actionEvent) {

        try {
            Employee employee = EmployeeModel.searchEmployee(String.valueOf(cmbEmployeeId.getValue()));

            lblFirstName.setText(employee.getFirstName());
            lblSecondName.setText(employee.getLastName());
            lblAddress.setText(employee.getAddress());
            lblEmail.setText(employee.getEmail());
            lblSalaryPerDay.setText(String.valueOf(employee.getSalaryPerDay()));
            lblJobRole.setText(employee.getJobRole());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EMPLOYEEDASHBOARD, dashboardPane);
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted = EmployeeModel.deleteEmployee(String.valueOf(cmbEmployeeId.getValue()));

            if(isDeleted){

                Image image = new Image("/lk/ijse/spicesystem/asset/correct.png");
                Notifications notifications = Notifications.create();
                notifications.graphic(new ImageView(image));
                notifications.text("Deleted Suuccesful");
                notifications.title("Spice System");
                notifications.hideAfter(Duration.seconds(3));
                notifications.show();

                lblAddress.setText("");
                lblEmail.setText("");
                lblFirstName.setText("");
                lblJobRole.setText("");
                lblSalaryPerDay.setText("");
                lblSecondName.setText("");

                initialize();

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
