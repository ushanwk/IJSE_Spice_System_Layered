package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.spicesystem.bo.BOFactory;
import lk.ijse.spicesystem.bo.custom.ShopBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dto.ShopDTO;
import lk.ijse.spicesystem.entity.Shop;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;
import org.controlsfx.control.Notifications;

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

    ShopBO shopBO = (ShopBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SHOP);

    public void initialize(){
        txtShopName.requestFocus();
        imgDotTwo.setVisible(false);

        try {
            lblShopId.setText(shopBO.nextId());
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

        ShopDTO shopDTO = new ShopDTO(lblShopId.getText(), txtShopName.getText(), txtAddress.getText(), txtEmail.getText(), Integer.valueOf(txtTelephone.getText()),
                txtOwnerNAme.getText(), txtOwneNic.getText(), Integer.valueOf(txtOwnerTelephone.getText()));

        try {
            boolean isAddes = shopBO.add(shopDTO);

            if(isAddes){
                Image image = new Image("/lk/ijse/spicesystem/asset/correct.png");
                Notifications notifications = Notifications.create();
                notifications.graphic(new ImageView(image));
                notifications.text("Added Suuccesful");
                notifications.title("Spice System");
                notifications.hideAfter(Duration.seconds(3));
                notifications.show();
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CUSTOMERDASHBOARD, dashboardPane);
    }
}
