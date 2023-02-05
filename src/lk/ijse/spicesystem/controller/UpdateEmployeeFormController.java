package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.model.EmployeeModel;
import lk.ijse.spicesystem.to.Employee;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

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

    public void initialize(){
        try {
            cmbEmpId.setItems(EmployeeModel.getAllEmpId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void cmbEmpId(ActionEvent actionEvent) {
        try {
            Employee employee = EmployeeModel.searchEmployee(String.valueOf(cmbEmpId.getValue()));

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
        Employee employee = new Employee(String.valueOf(cmbEmpId.getValue()), txtFName.getText(), txtSName.getText(), txtEmail.getText(), Double.valueOf(txtSalaryPerDay.getText()), txtAddress.getText(), txtJobRole.getText());

        try {
            boolean isUpsated = EmployeeModel.updateEmployee(employee);

            if(isUpsated){
                System.out.println("Done");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EMPLOYEEDASHBOARD, dashboardPane);
    }
}
