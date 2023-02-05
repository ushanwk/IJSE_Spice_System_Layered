package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.model.SupplierModel;
import lk.ijse.spicesystem.to.Supplier;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateSupplierFormController {
    public JFXComboBox cmbSupplierId;
    public JFXTextField txtSupplierName;
    public JFXTextField txtSupplierEmail;
    public JFXTextField txtSupplierTelephone;
    public JFXTextField txtAddress;
    public AnchorPane dashboardPane;

    public void initialize(){
        try {
            cmbSupplierId.setItems(SupplierModel.getAllSupId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

        Supplier supplier = new Supplier(
                String.valueOf(cmbSupplierId.getValue()),
                txtSupplierName.getText(),
                txtAddress.getText(),
                txtSupplierEmail.getText(),
                Integer.valueOf(txtSupplierTelephone.getText())
        );

        try {
            boolean isUpdated = SupplierModel.updateSupplier(supplier);

            if(isUpdated){
                System.out.println("Done");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SUPPLIERDASHBOARD, dashboardPane);
    }

    public void cmbShopIdOnAction(ActionEvent actionEvent) {
        String id = String.valueOf(cmbSupplierId.getValue());

        try {
            Supplier supplier = SupplierModel.searchSupplier(id);

            txtSupplierName.setText(supplier.getSupplierName());
            txtSupplierEmail.setText(supplier.getEmail());
            txtAddress.setText(supplier.getAddress());
            txtSupplierTelephone.setText(String.valueOf(supplier.getTelephone()));

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
