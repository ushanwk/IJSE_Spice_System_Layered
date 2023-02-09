package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.spicesystem.bo.BOFactory;
import lk.ijse.spicesystem.bo.custom.ShopBO;
import lk.ijse.spicesystem.dto.ShopDTO;
import lk.ijse.spicesystem.entity.Shop;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;
import org.controlsfx.control.Notifications;

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
    ShopBO shopBO = (ShopBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SHOP);

    public void initialize(){
        imgDotOne.setVisible(true);
        imgDotTwo.setVisible(false);
        imgDotThree.setVisible(false);

        try {
            cmbShopId.setItems(shopBO.getAllId());
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
            ShopDTO shop = shopBO.search(id);

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
            boolean isDeleted = shopBO.delete(String.valueOf(cmbShopId.getValue()));

            if(isDeleted){
                Image image = new Image("/lk/ijse/spicesystem/asset/correct.png");
                Notifications notifications = Notifications.create();
                notifications.graphic(new ImageView(image));
                notifications.text("Deleted Suuccesful");
                notifications.title("Spice System");
                notifications.hideAfter(Duration.seconds(3));
                notifications.show();
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
