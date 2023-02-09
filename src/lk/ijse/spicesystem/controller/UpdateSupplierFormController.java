package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
//import lk.ijse.spicesystem.modelBefore.SupplierModel;
import lk.ijse.spicesystem.bo.BOFactory;
import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.bo.custom.SupplierBO;
import lk.ijse.spicesystem.dto.SupplierDTO;
import lk.ijse.spicesystem.entity.Supplier;
//import lk.ijse.spicesystem.modelBefore.SupplierModel;
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

    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);

    public void initialize(){
        try {
            cmbSupplierId.setItems(supplierBO.getAllId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

        SupplierDTO supplier = new SupplierDTO(
                String.valueOf(cmbSupplierId.getValue()),
                txtSupplierName.getText(),
                txtAddress.getText(),
                txtSupplierEmail.getText(),
                Integer.valueOf(txtSupplierTelephone.getText())
        );

        try {
            boolean isUpdated = supplierBO.update(supplier);

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
            Supplier supplier = supplierBO.search(id);

            txtSupplierName.setText(supplier.getSupplierName());
            txtSupplierEmail.setText(supplier.getEmail());
            txtAddress.setText(supplier.getAddress());
            txtSupplierTelephone.setText(String.valueOf(supplier.getTelephone()));

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
