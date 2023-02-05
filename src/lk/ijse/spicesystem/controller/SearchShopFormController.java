package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXComboBox;
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

public class SearchShopFormController {
    public JFXComboBox cmbShopId;
    public ImageView imgDotOne;
    public ImageView imgDotTwo;
    public Label lblShopName;
    public Label lblAddress;
    public Label lblEmail;
    public Label lblTelephone;
    public Label lblOwnerName;
    public Label lblTelephones;
    public Label lblOwnerNic;
    public Label lblOwnerTelephones;
    public AnchorPane dashboardPane;

    public void initialize(){
        imgDotOne.setVisible(true);
        imgDotTwo.setVisible(false);

        try {
            cmbShopId.setItems(ShopModel.getAllShopId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void cmbShopIdOnAction(ActionEvent actionEvent) {
        imgDotOne.setVisible(false);
        imgDotTwo.setVisible(true);

        String id = String.valueOf(cmbShopId.getValue());

        try {
            Shop shop = ShopModel.searchShop(id);

            lblShopName.setText(shop.getShopName());
            lblAddress.setText(shop.getAddress());
            lblEmail.setText(shop.getEmail());
            lblTelephone.setText(String.valueOf(shop.getShopTelephone()));
            lblOwnerName.setText(shop.getOwnerName());
            lblOwnerNic.setText(shop.getOwnerNic());
            lblOwnerTelephones.setText(String.valueOf(shop.getOwnerTelephone()));

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CUSTOMERDASHBOARD, dashboardPane);
    }

    public void cmbShopIdOnMouseClick(MouseEvent mouseEvent) {
        imgDotOne.setVisible(true);
        imgDotTwo.setVisible(false);
    }
}
