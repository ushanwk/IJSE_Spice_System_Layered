package lk.ijse.spicesystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;

public class StockManagerPanelDashboardFormController {
    public ImageView imgRawStoresSelected;
    public ImageView imgProductionStoresSelected;
    public ImageView imgFinishedStoresSelected;
    public ImageView imgSuppliersSelected;
    public ImageView imgBatchesSelected;
    public ImageView imgRawStoresBorder;
    public ImageView imgProductionStoresBorder;
    public ImageView imgFinishedStoresBorder;
    public ImageView imgSuppliersBorder;
    public ImageView imgBatchesBorder;
    public AnchorPane dashboardPane;
    public AnchorPane pane;

    public void initialize(){
        imgRawStoresBorder.setVisible(false);
        imgProductionStoresBorder.setVisible(false);
        imgFinishedStoresBorder.setVisible(false);
        imgSuppliersBorder.setVisible(false);
        imgBatchesBorder.setVisible(false);

        imgRawStoresSelected.setVisible(false);
        imgProductionStoresSelected.setVisible(false);
        imgFinishedStoresSelected.setVisible(false);
        imgSuppliersSelected.setVisible(false);
        imgBatchesSelected.setVisible(false);

        if(StockManagerPanelFormController.option == 1){
            imgRawStoresSelected.setVisible(true);
        }else if(StockManagerPanelFormController.option == 2){
            imgProductionStoresSelected.setVisible(true);
        }else if(StockManagerPanelFormController.option == 3){
            imgFinishedStoresSelected.setVisible(true);
        }else if(StockManagerPanelFormController.option == 4){
            imgSuppliersSelected.setVisible(true);
        }else{
            imgBatchesSelected.setVisible(true);
        }
    }

    public void btnRawStoresOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        imgRawStoresSelected.setVisible(true);
        imgProductionStoresSelected.setVisible(false);
        imgFinishedStoresSelected.setVisible(false);
        imgSuppliersSelected.setVisible(false);
        imgBatchesSelected.setVisible(false);

        Navigation.navigate(Routes.ADDRAWSTOCK, dashboardPane);
    }

    public void btnProductionStoresOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        imgRawStoresSelected.setVisible(false);
        imgProductionStoresSelected.setVisible(true);
        imgFinishedStoresSelected.setVisible(false);
        imgSuppliersSelected.setVisible(false);
        imgBatchesSelected.setVisible(false);

        Navigation.navigate(Routes.ADDPRODUCTIONSTOCK, dashboardPane);
    }

    public void btnFinishedStoresOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        imgRawStoresSelected.setVisible(false);
        imgProductionStoresSelected.setVisible(false);
        imgFinishedStoresSelected.setVisible(true);
        imgSuppliersSelected.setVisible(false);
        imgBatchesSelected.setVisible(false);

        Navigation.navigate(Routes.ADDFINISHEDSTOCK, dashboardPane);
    }

    public void btnSuppliersOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        imgRawStoresSelected.setVisible(false);
        imgProductionStoresSelected.setVisible(false);
        imgFinishedStoresSelected.setVisible(false);
        imgSuppliersSelected.setVisible(true);
        imgBatchesSelected.setVisible(false);

        Navigation.navigate(Routes.SUPPLIERDASHBOARD, dashboardPane);
    }

    public void btnBatchesOnMouseClicked(MouseEvent mouseEvent) {
        imgRawStoresSelected.setVisible(false);
        imgProductionStoresSelected.setVisible(false);
        imgFinishedStoresSelected.setVisible(false);
        imgSuppliersSelected.setVisible(false);
        imgBatchesSelected.setVisible(true);
    }

    public void btnRawStoresOnMouseEntered(MouseEvent mouseEvent) {
        imgRawStoresBorder.setVisible(true);
    }

    public void btnRawStoresOnMouseExited(MouseEvent mouseEvent) {
        imgRawStoresBorder.setVisible(false);
    }

    public void btnProductionStoresOnMouseEntered(MouseEvent mouseEvent) {
        imgProductionStoresBorder.setVisible(true);
    }

    public void btnProductionStoresOnMouseExited(MouseEvent mouseEvent) {
        imgProductionStoresBorder.setVisible(false);
    }

    public void btnFinishedStoresOnMouseEntered(MouseEvent mouseEvent) {
        imgFinishedStoresBorder.setVisible(true);
    }

    public void btnFinishedStoresOnMouseExited(MouseEvent mouseEvent) {
        imgFinishedStoresBorder.setVisible(false);
    }

    public void btnSuppliersOnMouseEntered(MouseEvent mouseEvent) {
        imgSuppliersBorder.setVisible(true);
    }

    public void btnSuppliersOnMouseExited(MouseEvent mouseEvent) {
        imgSuppliersBorder.setVisible(false);
    }

    public void btnBatchesOnMouseEntered(MouseEvent mouseEvent) {
        imgBatchesBorder.setVisible(true);
    }

    public void btnBatchesOnMouseExited(MouseEvent mouseEvent) {
        imgBatchesBorder.setVisible(false);
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKMANAGER, pane);
    }
}
