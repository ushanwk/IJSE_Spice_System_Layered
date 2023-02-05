package lk.ijse.spicesystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;

public class SalesmenPanelDashboardControllerForm {
    public ImageView imgCustomersSelected;
    public ImageView imgOrdersSelected;
    public ImageView imgFinishedStoresSelected;
    public ImageView imgCustomerSelectedBorder;
    public ImageView imgOrdersSelectedBorder;
    public ImageView imgFinishedStoressSelectedBorder;
    public AnchorPane dashboardPane;
    public AnchorPane pane;

    public void initialize() throws IOException {
        imgCustomersSelected.setVisible(false);
        imgOrdersSelected.setVisible(false);
        imgFinishedStoresSelected.setVisible(false);

        imgCustomerSelectedBorder.setVisible(false);
        imgOrdersSelectedBorder.setVisible(false);
        imgFinishedStoressSelectedBorder.setVisible(false);

        if(SalesmenPanelFormController.option == 1){
            imgCustomersSelected.setVisible(true);
        }else if(SalesmenPanelFormController.option == 2){
            imgFinishedStoresSelected.setVisible(true);
        }else{
            imgOrdersSelected.setVisible(true);
        }

    }

    public void btnCustomersOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        imgCustomersSelected.setVisible(true);
        imgOrdersSelected.setVisible(false);
        imgFinishedStoresSelected.setVisible(false);

        Navigation.navigate(Routes.CUSTOMERDASHBOARD, dashboardPane);
    }

    public void btnOrdersOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        imgCustomersSelected.setVisible(false);
        imgOrdersSelected.setVisible(true);
        imgFinishedStoresSelected.setVisible(false);

        Navigation.navigate(Routes.PLACEORDER, dashboardPane);
    }

    public void btnFinishedStoresOnMouseClicked(MouseEvent mouseEvent) {
        imgCustomersSelected.setVisible(false);
        imgOrdersSelected.setVisible(false);
        imgFinishedStoresSelected.setVisible(true);
    }

    public void btnCustomersOnMouseEntered(MouseEvent mouseEvent) {
        imgCustomerSelectedBorder.setVisible(true);
    }

    public void btnFinishedStoresOnMouseEntered(MouseEvent mouseEvent) {
        imgFinishedStoressSelectedBorder.setVisible(true);
    }

    public void btnOrdersOnMouseEntered(MouseEvent mouseEvent) {
        imgOrdersSelectedBorder.setVisible(true);
    }

    public void btnOrdersOnMouseExited(MouseEvent mouseEvent) {
        imgOrdersSelectedBorder.setVisible(false);
    }

    public void btnCustomersOnMouseExited(MouseEvent mouseEvent) {
        imgCustomerSelectedBorder.setVisible(false);
    }

    public void btnFinishedStoresOnMouseExited(MouseEvent mouseEvent) {
        imgFinishedStoressSelectedBorder.setVisible(false);
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SALESMEN, pane);
    }
}
