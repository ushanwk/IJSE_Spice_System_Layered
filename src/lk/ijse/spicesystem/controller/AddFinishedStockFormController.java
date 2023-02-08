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
import lk.ijse.spicesystem.bo.BOFactory;
import lk.ijse.spicesystem.bo.custom.FinishedItemBO;
import lk.ijse.spicesystem.bo.custom.FinishedStockBO;
import lk.ijse.spicesystem.bo.custom.ProductionBO;
import lk.ijse.spicesystem.bo.custom.ProductionStockBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.db.DBConnection;
import lk.ijse.spicesystem.dto.FinishedStockDTO;
import lk.ijse.spicesystem.modelBefore.FinishedStockModel;
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

    FinishedStockBO finishedStockBO = (FinishedStockBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.FINISHEDSTOCK);
    ProductionBO productionBO = (ProductionBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PRODUCTION);
    ProductionStockBO productionStockBO = (ProductionStockBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PRODUCTIONSTOCK);
    FinishedItemBO finishedItemBO = (FinishedItemBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.FINISHEDITEM);

    public void initialize(){

        txtAmount.clear();
        lblBarcode.setText("");
        lblQtyOnHand.setText("");
        lblProductionId.setText("");
        lblFinishedStockId.setText("");
        lblProductionId.setText("");

        try {
            lblFinishedStockId.setText(finishedStockBO.nextId());
            cmbProductionItem.setItems(productionBO.getProductionItem());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void cmbProductionItemOnAction(ActionEvent actionEvent) {

        try {
            lblProductionId.setText(productionBO.getProductionId(String.valueOf(cmbProductionItem.getValue())));
            cmbProductionStockId.setItems(productionStockBO.getProductionStockId(lblProductionId.getText()));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void cmbProductionStockIdOnAction(ActionEvent actionEvent) {

        try {
            lblQtyOnHand.setText(String.valueOf(FinishedStockModel.getQtyOnHand(String.valueOf(cmbProductionStockId.getValue()))));
            cmbFinishedItem.setItems(finishedItemBO.getFinishedItem(String.valueOf(cmbProductionItem.getValue())));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void cmbFinishedItemOnAction(ActionEvent actionEvent) {

        try {
            lblBarcode.setText(finishedItemBO.getBarcode(String.valueOf(cmbFinishedItem.getValue())));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnSubmitOnAction(ActionEvent actionEvent) {

        FinishedStockDTO finishedStockDTO = new FinishedStockDTO(lblFinishedStockId.getText(), lblBarcode.getText(), Integer.valueOf(txtAmount.getText()), String.valueOf(cmbProductionStockId.getValue()), Integer.valueOf(txtAmount.getText()));


        try {

            DBConnection.getInstance().getConnection().setAutoCommit(false);

            boolean isUpdateProduction = productionBO.updateProductionTable(lblProductionId.getText(), Integer.valueOf(txtAmount.getText()));

            if(isUpdateProduction){

                boolean isUpdateProductionStock = productionStockBO.updateProductionStockTable(String.valueOf(cmbProductionStockId.getValue()), Integer.valueOf(txtAmount.getText()));

                if(isUpdateProductionStock){

                    boolean isUpdateFinishedItem = finishedItemBO.updateFinishedItemTable(lblBarcode.getText(), Integer.valueOf(txtAmount.getText()));

                    if(isUpdateFinishedItem){

                        boolean isUpdateFinishedStock = finishedStockBO.update(finishedStockDTO);

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
