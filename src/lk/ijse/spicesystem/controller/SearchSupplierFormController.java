package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
//import lk.ijse.spicesystem.modelBefore.SupplierModel;
import lk.ijse.spicesystem.bo.BOFactory;
import lk.ijse.spicesystem.bo.custom.SupplierBO;
import lk.ijse.spicesystem.entity.Supplier;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class SearchSupplierFormController {
    public JFXComboBox cmbSupplierId;
    public Label lblSupplierName;
    public Label lblSupplierAddress;
    public Label lblSupplierEmail;
    public Label lblSupplierTelephone;
    public AnchorPane dashboardPane;
    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);


    public void initialize(){
        try {
            cmbSupplierId.setItems(supplierBO.getAllId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SUPPLIERDASHBOARD, dashboardPane);
    }

    public void cmbSupplierIdOnAction(ActionEvent actionEvent) {
        String id = String.valueOf(cmbSupplierId.getValue());

        try {
            Supplier supplier = supplierBO.search(id);

            lblSupplierName.setText(supplier.getSupplierName());
            lblSupplierAddress.setText(supplier.getAddress());
            lblSupplierTelephone.setText(String.valueOf(supplier.getTelephone()));
            lblSupplierEmail.setText(supplier.getEmail());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
