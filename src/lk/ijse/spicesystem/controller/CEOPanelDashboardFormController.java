package lk.ijse.spicesystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;

public class CEOPanelDashboardFormController {
    public ImageView ImgSelectedFinance;
    public ImageView ImgSelectedStores;
    public ImageView ImgSelectedSuppliers;
    public ImageView ImgSelectedHR;
    public ImageView ImgSelectedUsers;
    public ImageView imgFinanceSelectedLogo;
    public ImageView imgStoresSelectedLogo;
    public ImageView imgSupplieresSelectedLogo;
    public ImageView imgHRSelectedLogo;
    public ImageView imgUsersSelectedLogo;
    public AnchorPane pane;

    public void initialize() {
        ImgSelectedFinance.setVisible(false);
        ImgSelectedStores.setVisible(false);
        ImgSelectedSuppliers.setVisible(false);
        ImgSelectedHR.setVisible(false);
        ImgSelectedUsers.setVisible(false);

        imgFinanceSelectedLogo.setVisible(false);
        imgStoresSelectedLogo.setVisible(false);
        imgSupplieresSelectedLogo.setVisible(false);
        imgHRSelectedLogo.setVisible(false);
        imgUsersSelectedLogo.setVisible(false);


        if(CEOPanelFormController.option == 1){
            imgFinanceSelectedLogo.setVisible(true);
        }else if(CEOPanelFormController.option == 2){
            imgStoresSelectedLogo.setVisible(true);
        }else if(CEOPanelFormController.option == 3){
            imgSupplieresSelectedLogo.setVisible(true);
        }else if(CEOPanelFormController.option == 4){
            imgHRSelectedLogo.setVisible(true);
        }else{
            imgUsersSelectedLogo.setVisible(true);
        }

    }

    public void btnFinanceOnMouseEntered(MouseEvent mouseEvent) {
        ImgSelectedFinance.setVisible(true);
    }

    public void btnFinanceOnMouseExited(MouseEvent mouseEvent) {
        ImgSelectedFinance.setVisible(false);
    }

    public void btnStoresOnMouseEntered(MouseEvent mouseEvent) {
        ImgSelectedStores.setVisible(true);
    }

    public void btnStoresOnMouseExited(MouseEvent mouseEvent) {
        ImgSelectedStores.setVisible(false);
    }

    public void btnSuppliersOnMouseEntered(MouseEvent mouseEvent) {
        ImgSelectedSuppliers.setVisible(true);
    }

    public void btnSuppliersOnMouseExited(MouseEvent mouseEvent) {
        ImgSelectedSuppliers.setVisible(false);
    }

    public void btnHROnMouseEntered(MouseEvent mouseEvent) {
        ImgSelectedHR.setVisible(true);
    }

    public void btnUsersOnMouseEntered(MouseEvent mouseEvent) {
        ImgSelectedUsers.setVisible(true);
    }

    public void btnUsersOnMouseExited(MouseEvent mouseEvent) {
        ImgSelectedUsers.setVisible(false);
    }

    public void btnHROnMouseExited(MouseEvent mouseEvent) {
        ImgSelectedHR.setVisible(false);
    }


    public void btnFinanceOnMouseClicked(MouseEvent mouseEvent) {
        imgFinanceSelectedLogo.setVisible(true);
        imgStoresSelectedLogo.setVisible(false);
        imgSupplieresSelectedLogo.setVisible(false);
        imgHRSelectedLogo.setVisible(false);
        imgUsersSelectedLogo.setVisible(false);

    }

    public void btnStoresOnMouseClicked(MouseEvent mouseEvent) {
        imgFinanceSelectedLogo.setVisible(false);
        imgStoresSelectedLogo.setVisible(true);
        imgSupplieresSelectedLogo.setVisible(false);
        imgHRSelectedLogo.setVisible(false);
        imgUsersSelectedLogo.setVisible(false);
    }

    public void btnSuppliersOnMouseClicked(MouseEvent mouseEvent) {
        imgFinanceSelectedLogo.setVisible(false);
        imgStoresSelectedLogo.setVisible(false);
        imgSupplieresSelectedLogo.setVisible(true);
        imgHRSelectedLogo.setVisible(false);
        imgUsersSelectedLogo.setVisible(false);
    }

    public void btnHROnMouseClicked(MouseEvent mouseEvent) {
        imgFinanceSelectedLogo.setVisible(false);
        imgStoresSelectedLogo.setVisible(false);
        imgSupplieresSelectedLogo.setVisible(false);
        imgHRSelectedLogo.setVisible(true);
        imgUsersSelectedLogo.setVisible(false);
    }

    public void btnUsersOnMouseClicked(MouseEvent mouseEvent) {
        imgFinanceSelectedLogo.setVisible(false);
        imgStoresSelectedLogo.setVisible(false);
        imgSupplieresSelectedLogo.setVisible(false);
        imgHRSelectedLogo.setVisible(false);
        imgUsersSelectedLogo.setVisible(true);
    }

    public void btnBacOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CEO, pane);
    }
}
