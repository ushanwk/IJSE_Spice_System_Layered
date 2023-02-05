package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import lk.ijse.spicesystem.db.DBConnection;
import lk.ijse.spicesystem.model.ProductionStockModel;
import lk.ijse.spicesystem.to.ProductionStock;
import org.controlsfx.control.Notifications;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddProductionStockFormController {
    public JFXComboBox cmbMaterial;
    public JFXComboBox cmbBatchId;
    public Label lblQtyOnHand;
    public JFXComboBox cmbProduction;
    public Label lblProductionStockId;
    public JFXTextField txtAmount;
    ObservableList<String> material = FXCollections.observableArrayList();

    public void initialize(){

        ObservableList list = FXCollections.observableArrayList();

        txtAmount.clear();
        lblProductionStockId.setText("");
        lblQtyOnHand.setText("");
        cmbProduction.setItems(list);
        cmbMaterial.setItems(list);
        cmbBatchId.setItems(list);

        material.add("Chillie");
        material.add("Goraka");
        material.add("Termeric");

        cmbMaterial.setItems(material);

        try {
            lblProductionStockId.setText(ProductionStockModel.nextProductionStockId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void cmbMaterialOnAction(ActionEvent actionEvent) {

        String materialId = String.valueOf((String.valueOf(cmbMaterial.getValue()).charAt(0)));

        try {
            cmbBatchId.setItems(ProductionStockModel.getBatchID(materialId));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void cmbBatchIdOnAction(ActionEvent actionEvent) {

        String batchId = String.valueOf(cmbBatchId.getValue());

        try {
            lblQtyOnHand.setText(String.valueOf(ProductionStockModel.getQtyOnHandBatchId(batchId)));
            cmbProduction.setItems(ProductionStockModel.getProduction(batchId));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void btnSubmitOnAction(ActionEvent actionEvent) {

        String productionId = null;

        if(String.valueOf(cmbProduction.getValue()) .equals("Ch Powder")){
            productionId = "P1";
        }else if(String.valueOf(cmbProduction.getValue()) .equals("Ch Pieces")){
            productionId = "P2";
        }else if(String.valueOf(cmbProduction.getValue()) .equals("Go Pieces")){
            productionId = "P3";
        }else if(String.valueOf(cmbProduction.getValue()) .equals("Pe Powder")){
            productionId = "P4";
        }else if(String.valueOf(cmbProduction.getValue()) .equals("Pe Pieces")){
            productionId = "P5";
        }else if(String.valueOf(cmbProduction.getValue()) .equals("Te Pieces")){
            productionId = "P6";
        }

        ProductionStock productionStock = new ProductionStock(lblProductionStockId.getText(), Integer.valueOf(txtAmount.getText()), String.valueOf(cmbBatchId.getValue()), productionId);

        try {
            boolean isAddedProductionStock = ProductionStockModel.productionStockTable(productionStock);

            DBConnection.getInstance().getConnection().setAutoCommit(false);

            if(isAddedProductionStock){

                boolean isAddedProduction = ProductionStockModel.productionTale(Integer.valueOf(txtAmount.getText()), String.valueOf(cmbProduction.getValue()));

                if(isAddedProduction){

                    boolean isAddedRawStock = ProductionStockModel.RawStockTable(Integer.valueOf(txtAmount.getText()), String.valueOf(cmbBatchId.getValue()));

                    if(isAddedProduction){

                        boolean isAddedMaterial = ProductionStockModel.materialTable(Integer.valueOf(txtAmount.getText()), String.valueOf(cmbMaterial.getValue()));

                        if(isAddedMaterial){

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

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                DBConnection.getInstance().getConnection().setAutoCommit(true);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void txtAmountOnKeyReleased(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(txtAmount.getText());

        boolean isMatch = matcher.matches();

        if(!isMatch){
            txtAmount.setFocusColor(javafx.scene.paint.Paint.valueOf("#F506FF"));
        }else{
            txtAmount.setFocusColor(Paint.valueOf("#07d5e0"));
        }
    }
}
