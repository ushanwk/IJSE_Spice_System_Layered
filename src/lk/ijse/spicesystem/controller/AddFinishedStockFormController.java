package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import lk.ijse.spicesystem.db.DBConnection;
import lk.ijse.spicesystem.model.FinishedStockModel;
import lk.ijse.spicesystem.to.FinishedStock;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;
import org.controlsfx.control.Notifications;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddFinishedStockFormController {

    public Label lblFinishedStockId;
    public JFXComboBox cmbProductionItem;
    public Label lblProductionId;
    public JFXComboBox cmbProductionStockId;
    public Label lblQtyOnHand;
    public JFXComboBox cmbFinishedItem;
    public Label lblBarcode;
    public JFXTextField txtAmount;
    public AnchorPane dashboardPane;

    public void initialize(){

        txtAmount.clear();
        lblBarcode.setText("");
        lblQtyOnHand.setText("");
        lblProductionId.setText("");
        lblFinishedStockId.setText("");
        lblProductionId.setText("");

        try {
            lblFinishedStockId.setText(FinishedStockModel.nextFinishedStockId());
            cmbProductionItem.setItems(FinishedStockModel.getProductionItem());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void cmbProductionItemOnAction(ActionEvent actionEvent) {

        try {
            lblProductionId.setText(FinishedStockModel.getProductionId(String.valueOf(cmbProductionItem.getValue())));
            cmbProductionStockId.setItems(FinishedStockModel.getProductionStockId(lblProductionId.getText()));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void cmbProductionStockIdOnAction(ActionEvent actionEvent) {

        try {
            lblQtyOnHand.setText(String.valueOf(FinishedStockModel.getQtyOnHand(String.valueOf(cmbProductionStockId.getValue()))));
            cmbFinishedItem.setItems(FinishedStockModel.getFinishedItem(String.valueOf(cmbProductionItem.getValue())));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void cmbFinishedItemOnAction(ActionEvent actionEvent) {

        try {
            lblBarcode.setText(FinishedStockModel.getBarcode(String.valueOf(cmbFinishedItem.getValue())));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnSubmitOnAction(ActionEvent actionEvent) {

        FinishedStock finishedStock = new FinishedStock(lblFinishedStockId.getText(), lblBarcode.getText(), Integer.valueOf(txtAmount.getText()), String.valueOf(cmbProductionStockId.getValue()), Integer.valueOf(txtAmount.getText()));


        try {

            DBConnection.getInstance().getConnection().setAutoCommit(false);

            boolean isUpdateProduction = FinishedStockModel.updateProductionTable(lblProductionId.getText(), Integer.valueOf(txtAmount.getText()));

            if(isUpdateProduction){

                boolean isUpdateProductionStock = FinishedStockModel.updateProductionStockTable(String.valueOf(cmbProductionStockId.getValue()), Integer.valueOf(txtAmount.getText()));

                if(isUpdateProductionStock){

                    boolean isUpdateFinishedItem = FinishedStockModel.updateFinishedItemTable(lblBarcode.getText(), Integer.valueOf(txtAmount.getText()));

                    if(isUpdateFinishedItem){

                        boolean isUpdateFinishedStock = FinishedStockModel.updateFinishedStock(finishedStock);

                        if(isUpdateFinishedStock){

                            DBConnection.getInstance().getConnection().commit();

                            Image image = new Image("/lk/ijse/spicesystem/asset/correct.png");
                            Notifications notifications = Notifications.create();
                            notifications.graphic(new ImageView(image));
                            notifications.text("Added Suuccesful");
                            notifications.title("Spice System");
                            notifications.hideAfter(Duration.seconds(3));
                            notifications.show();

                            initialize();

                        }
                    }

                }
            }

            DBConnection.getInstance().getConnection().rollback();
            System.out.println("Not Done");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                DBConnection.getInstance().getConnection().setAutoCommit(true);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void btnBackOnAction(ActionEvent actionEvent) {

    }

    public void txtAmountOnKeyReleased(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("^[0-9]{1,5}$");
        Matcher matcher = pattern.matcher(txtAmount.getText());

        boolean isMatch = matcher.matches();

        if(!isMatch){
            txtAmount.setFocusColor(javafx.scene.paint.Paint.valueOf("#F506FF"));
        }else{
            txtAmount.setFocusColor(Paint.valueOf("#07d5e0"));
        }
    }
}
