package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.spicesystem.model.SupplierModel;
import lk.ijse.spicesystem.to.Supplier;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteSupplierFormController {
    public JFXComboBox cmbSupplierId;
    public Label lblSupplierName;
    public Label lblSupplierAddress;
    public Label lblSupplierEmail;
    public Label lblSupplierTelephone;
    public AnchorPane dashboardPane;


    public void initialize(){
        try {
            cmbSupplierId.setItems(SupplierModel.getAllSupId());
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
            Supplier supplier = SupplierModel.searchSupplier(id);

            lblSupplierName.setText(supplier.getSupplierName());
            lblSupplierAddress.setText(supplier.getAddress());
            lblSupplierTelephone.setText(String.valueOf(supplier.getTelephone()));
            lblSupplierEmail.setText(supplier.getEmail());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = String.valueOf(cmbSupplierId.getValue());

        try {
            boolean isDeleted = SupplierModel.deleteSupplier(id);

            if(isDeleted){

                Image image = new Image("/lk/ijse/spicesystem/asset/correct.png");
                Notifications notifications = Notifications.create();
                notifications.graphic(new ImageView(image));
                notifications.text("Deleted Suuccesful");
                notifications.title("Spice System");
                notifications.hideAfter(Duration.seconds(3));
                notifications.show();

                lblSupplierAddress.setText("");
                lblSupplierEmail.setText("");
                lblSupplierName.setText("");
                lblSupplierTelephone.setText("");

                initialize();

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
