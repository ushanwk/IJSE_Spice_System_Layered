package lk.ijse.spicesystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;

public class SupplierDashboardFormController {
    public AnchorPane dashboardPane;

    public void btnAddCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADDSUPPLIER, dashboardPane);
    }

    public void btnSearchCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SEARCHSUPPLIER, dashboardPane);
    }

    public void btnUpdateCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.UPDATESUPPLIER, dashboardPane);
    }

    public void btnDeleteCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DELETESUPPLIER, dashboardPane);
    }
}
