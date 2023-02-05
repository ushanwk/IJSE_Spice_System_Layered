package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.model.ShopModel;
import lk.ijse.spicesystem.to.Shop;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class AddShopFormController {
    public ImageView imgDotOne;
    public ImageView imgDotTwo;
    public Label lblShopId;
    public JFXTextField txtShopName;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;
    public JFXTextField txtTelephone;
    public JFXTextField txtOwnerNAme;
    public JFXTextField txtOwnerTelephone;
    public JFXTextField txtOwneNic;
    public AnchorPane dashboardPane;

    public void initialize(){
        txtShopName.requestFocus();
        imgDotTwo.setVisible(false);

        try {
            lblShopId.setText(ShopModel.nextShopId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        };

    }

    public void btnAgentOnAction(ActionEvent actionEvent) {
        imgDotOne.setVisible(true);
        imgDotTwo.setVisible(false);
    }

    public void txtShopNameOnMouseClicked(MouseEvent mouseEvent) {
        imgDotOne.setVisible(true);
        imgDotTwo.setVisible(false);
    }

    public void txtAddresOnMouseClicked(MouseEvent mouseEvent) {
        imgDotOne.setVisible(true);
        imgDotTwo.setVisible(false);
    }

    public void txtEmailOnMouseClicked(MouseEvent mouseEvent) {
        imgDotOne.setVisible(true);
        imgDotTwo.setVisible(false);
    }

    public void txtTelephoneOnMouseClicked(MouseEvent mouseEvent) {
        imgDotOne.setVisible(true);
        imgDotTwo.setVisible(false);
    }

    public void txtOwnerNameOnMouseClicked(MouseEvent mouseEvent) {
        imgDotOne.setVisible(false);
        imgDotTwo.setVisible(true);
    }

    public void txtOwnerTelephoneOnMouseClicked(MouseEvent mouseEvent) {
        imgDotOne.setVisible(false);
        imgDotTwo.setVisible(true);
    }

    public void txtOwnerNicOnMouseClicked(MouseEvent mouseEvent) {
        imgDotOne.setVisible(false);
        imgDotTwo.setVisible(true);
    }

    public void btnSubmitOnAction(ActionEvent actionEvent) {

        Shop shop = new Shop(lblShopId.getText(), txtShopName.getText(), txtAddress.getText(), txtEmail.getText(), Integer.valueOf(txtTelephone.getText()),
                txtOwnerNAme.getText(), txtOwneNic.getText(), Integer.valueOf(txtOwnerTelephone.getText()));

        try {
            boolean isAddes = ShopModel.addShopDetail(shop);

            if(isAddes){
                System.out.println("Done");
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CUSTOMERDASHBOARD, dashboardPane);
    }
}
