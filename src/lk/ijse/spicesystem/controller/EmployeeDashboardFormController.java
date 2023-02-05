package lk.ijse.spicesystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;

public class EmployeeDashboardFormController {
    public AnchorPane dashboardPane;

    public void btnAddCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADDEMPLOYEE, dashboardPane);
    }

    public void btnSearchCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SEARCHEMPLOYEE, dashboardPane);
    }

    public void btnUpdateCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.UPDATEEMPLOYEE, dashboardPane);
    }

    public void btnDeleteCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DELETEEMPLOYEE, dashboardPane);
    }
}
