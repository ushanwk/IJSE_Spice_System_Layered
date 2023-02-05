package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.model.ShopModel;
import lk.ijse.spicesystem.to.Shop;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateShopFormController {
    public ImageView imgDotOne;
    public ImageView imgDotThree;
    public ImageView imgDotTwo;
    public JFXComboBox cmbShopId;
    public JFXTextField txtShopName;
    public JFXTextField txtShopAddress;
    public JFXTextField txtTelephone;
    public JFXTextField txtOwnerName;
    public JFXTextField txtOwnerTelephone;
    public JFXTextField txtOwnerNic;
    public JFXTextField txtEmail;
    public AnchorPane dashboardPane;

    public void initialize(){
        imgDotOne.setVisible(true);
        imgDotTwo.setVisible(false);
        imgDotThree.setVisible(false);

        try {
            cmbShopId.setItems(ShopModel.getAllShopId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void cmbShopIdOnAction(ActionEvent actionEvent) {

        String id = String.valueOf(cmbShopId.getValue());


        try {
            Shop shop = ShopModel.searchShop(id);

            txtShopName.setText(shop.getShopName());
            txtShopAddress.setText(shop.getAddress());
            txtEmail.setText(shop.getEmail());
            txtTelephone.setText(String.valueOf(shop.getShopTelephone()));
            txtOwnerName.setText(shop.getOwnerName());
            txtOwnerNic.setText(shop.getOwnerNic());
            txtOwnerTelephone.setText(String.valueOf(shop.getOwnerTelephone()));

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public void txtShopNameOnMouseClicked(MouseEvent mouseEvent) {
        imgDotThree.setVisible(true);
        imgDotTwo.setVisible(false);
        imgDotOne.setVisible(false);
    }

    public void txtSAddressOnMouseClicked(MouseEvent mouseEvent) {
        imgDotThree.setVisible(true);
        imgDotTwo.setVisible(false);
        imgDotOne.setVisible(false);
    }

    public void txtEmailOnMouseClicked(MouseEvent mouseEvent) {
        imgDotThree.setVisible(true);
        imgDotTwo.setVisible(false);
        imgDotOne.setVisible(false);
    }

    public void txtTelephoneOnMouseClicked(MouseEvent mouseEvent) {
        imgDotThree.setVisible(true);
        imgDotTwo.setVisible(false);
        imgDotOne.setVisible(false);
    }

    public void txtOwnerNameOnMouseClicked(MouseEvent mouseEvent) {
        imgDotThree.setVisible(true);
        imgDotTwo.setVisible(false);
        imgDotOne.setVisible(false);
    }

    public void txtOwnerTelephoneOnMouseClicked(MouseEvent mouseEvent) {
        imgDotThree.setVisible(true);
        imgDotTwo.setVisible(false);
        imgDotOne.setVisible(false);
    }

    public void txtOwnerNicOnMouseClicked(MouseEvent mouseEvent) {
        imgDotThree.setVisible(true);
        imgDotTwo.setVisible(false);
        imgDotOne.setVisible(false);
    }

    public void cmbShopIdOnMouseClicked(MouseEvent mouseEvent) {
        imgDotOne.setVisible(true);
        imgDotTwo.setVisible(false);
        imgDotThree.setVisible(false);
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        imgDotOne.setVisible(false);
        imgDotTwo.setVisible(true);
        imgDotThree.setVisible(false);

        Shop shop = new Shop(
                String.valueOf(cmbShopId.getValue()),
                txtShopName.getText(),
                txtShopAddress.getText(),
                txtEmail.getText(),
                Integer.valueOf(txtTelephone.getText()),
                txtOwnerName.getText(),
                txtOwnerNic.getText(),
                Integer.valueOf(txtOwnerTelephone.getText())
        );

        try {
            boolean isAdded = ShopModel.updateShop(shop);

            if(isAdded){
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
