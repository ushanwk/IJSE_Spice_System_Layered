package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
//import lk.ijse.spicesystem.modelBefore.EmployeeModel;
import javafx.util.Duration;
import lk.ijse.spicesystem.bo.BOFactory;
import lk.ijse.spicesystem.bo.custom.EmployeeBO;
import lk.ijse.spicesystem.dto.EmployeeDTO;
import lk.ijse.spicesystem.entity.Employee;
//import lk.ijse.spicesystem.modelBefore.EmployeeModel;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateEmployeeFormController {
    public JFXComboBox cmbEmpId;
    public JFXTextField txtFName;
    public JFXTextField txtSName;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtJobRole;
    public JFXTextField txtSalaryPerDay;
    public AnchorPane dashboardPane;

    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    public void initialize(){
        try {
            cmbEmpId.setItems(employeeBO.getAllId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void cmbEmpId(ActionEvent actionEvent) {
        try {
            Employee employee = employeeBO.search(String.valueOf(cmbEmpId.getValue()));

            txtFName.setText(employee.getFirstName());
            txtSName.setText(employee.getLastName());
            txtSalaryPerDay.setText(String.valueOf(employee.getSalaryPerDay()));
            txtJobRole.setText(employee.getJobRole());
            txtAddress.setText(employee.getAddress());
            txtEmail.setText(employee.getEmail());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        EmployeeDTO employee = new EmployeeDTO(String.valueOf(cmbEmpId.getValue()), txtFName.getText(), txtSName.getText(), txtEmail.getText(), Double.valueOf(txtSalaryPerDay.getText()), txtAddress.getText(), txtJobRole.getText());

        try {
            boolean isUpsated = employeeBO.update(employee);

            if(isUpsated){
                Image image = new Image("/lk/ijse/spicesystem/asset/correct.png");
                Notifications notifications = Notifications.create();
                notifications.graphic(new ImageView(image));
                notifications.text("Update Suuccesful");
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
}
