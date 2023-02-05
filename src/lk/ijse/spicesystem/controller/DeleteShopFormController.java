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

public class DeleteShopFormController {
    public JFXComboBox cmbShopId;
    public Label lblShopName;
    public Label lblAddress;
    public Label lblEmail;
    public Label lblTelephone;
    public Label lblOwnerName;
    public Label lblTelephones;
    public Label lblOwnerNic;
    public Label lblOwnerTelephones;
    public AnchorPane dashboardPane;
    public ImageView imgDotOne;
    public ImageView imgDotTwo;
    public ImageView imgDotThree;

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

        imgDotOne.setVisible(false);
        imgDotTwo.setVisible(true);
        imgDotThree.setVisible(false);

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

    public void btnDeleteOnAction(ActionEvent actionEvent) {

        imgDotOne.setVisible(false);
        imgDotTwo.setVisible(false);
        imgDotThree.setVisible(true);

        try {
            boolean isDeleted = ShopModel.deleteShop(String.valueOf(cmbShopId.getValue()));

            if(isDeleted){
                System.out.println("Done");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void cmbShopIdOnMouseClick(MouseEvent mouseEvent) {
        imgDotOne.setVisible(true);
        imgDotTwo.setVisible(false);
        imgDotThree.setVisible(false);
    }
}
