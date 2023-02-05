package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.db.DBConnection;
import lk.ijse.spicesystem.model.SalaryRecomendationModel;

import java.sql.SQLException;

public class SalaryReccomendationController {
    public JFXComboBox cmbEmployeeId;
    public Label lblEmployee;
    public Label lblSalaryPerDay;
    public JFXComboBox cmbMonth;
    public JFXComboBox cmbPaymentMethod;
    public JFXTextField txtDays;
    public Label lblCost;
    public AnchorPane dashboardPane;

    ObservableList month = FXCollections.observableArrayList();

    public void initialize(){
        month.addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

        try {
            cmbEmployeeId.setItems(SalaryRecomendationModel.getEmployeeId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void cmbEmployeeIdOnAction(ActionEvent actionEvent) {

        try {
            lblEmployee.setText(SalaryRecomendationModel.getEmployeeName(String.valueOf(cmbEmployeeId.getValue())));
            lblSalaryPerDay.setText(String.valueOf(SalaryRecomendationModel.getEmployeeSalary(String.valueOf(cmbEmployeeId.getValue()))));
            cmbMonth.setItems(month);
            cmbPaymentMethod.setItems(SalaryRecomendationModel.getPaymentMethods());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnsubmitOnAction(ActionEvent actionEvent) {

        try {
            boolean isUpdate = SalaryRecomendationModel.updatePaymentMethod(String.valueOf(cmbPaymentMethod.getValue()), Double.valueOf(lblCost.getText()));

            if(isUpdate){
                System.out.println("Done");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBConnection.getInstance().getConnection().setAutoCommit(true);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void cmbPaymentMethodOnClicked(MouseEvent mouseEvent) {
        lblCost.setText(String.valueOf(Double.valueOf(txtDays.getText())*Double.valueOf(lblSalaryPerDay.getText())));
    }
}
