package lk.ijse.spicesystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;

public class FinanceManagerPanelDashboardFormController {
    public ImageView imgSalesProfitSelectedBorder;
    public ImageView imgCostsSelectedBorder;
    public ImageView imgNetProfitSelectedBorder;
    public ImageView imgSalesProfitSelectedRec;
    public ImageView imgCostsSelectedRec;
    public ImageView imgNetProfitSelectedRec;
    public AnchorPane pane;

    public void initialize(){
        imgSalesProfitSelectedBorder.setVisible(false);
        imgCostsSelectedBorder.setVisible(false);
        imgNetProfitSelectedBorder.setVisible(false);

        imgSalesProfitSelectedRec.setVisible(false);
        imgCostsSelectedRec.setVisible(false);
        imgNetProfitSelectedRec.setVisible(false);

        if(FinanceManagerPanelFormController.option == 1){
         imgSalesProfitSelectedRec.setVisible(true);
        }else if(FinanceManagerPanelFormController.option == 2){
            imgCostsSelectedRec.setVisible(true);
        }else{
            imgNetProfitSelectedRec.setVisible(true);
        }
    }

    public void btnSlaesProftOnMouseEntered(MouseEvent mouseEvent) {
        imgSalesProfitSelectedBorder.setVisible(true);
    }

    public void btnCostsOnMouseEntered(MouseEvent mouseEvent) {
        imgCostsSelectedBorder.setVisible(true);
    }

    public void btnNetProfitOnMouseEntered(MouseEvent mouseEvent) {
        imgNetProfitSelectedBorder.setVisible(true);
    }

    public void btnSlaesProftOnMouseExited(MouseEvent mouseEvent) {
        imgSalesProfitSelectedBorder.setVisible(false);
    }

    public void btnCostsOnMouseExited(MouseEvent mouseEvent) {
        imgCostsSelectedBorder.setVisible(false);
    }

    public void btnNetProfitOnMouseExited(MouseEvent mouseEvent) {
        imgNetProfitSelectedBorder.setVisible(false);
    }

    public void btnSalesProfitOnMouseClicked(MouseEvent mouseEvent) {
        imgSalesProfitSelectedRec.setVisible(true);
        imgCostsSelectedRec.setVisible(false);
        imgNetProfitSelectedRec.setVisible(false);
    }

    public void btnCostsOnMouseClicked(MouseEvent mouseEvent) {
        imgSalesProfitSelectedRec.setVisible(false);
        imgCostsSelectedRec.setVisible(true);
        imgNetProfitSelectedRec.setVisible(false);
    }

    public void btnNetProfitsOnMouseClicked(MouseEvent mouseEvent) {
        imgSalesProfitSelectedRec.setVisible(false);
        imgCostsSelectedRec.setVisible(false);
        imgNetProfitSelectedRec.setVisible(true);
    }

    public void btnBackOnACtion(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.FINANCEMANAGER, pane);
    }
}
