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
import lk.ijse.spicesystem.bo.BOFactory;
import lk.ijse.spicesystem.bo.custom.*;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dto.RawStockDTO;
import org.controlsfx.control.Notifications;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddRawStockFormController {
    public JFXComboBox cmbRawItem;
    public Label lblBatchId;
    public JFXComboBox cmbSupplierID;
    public Label lblSupplierName;
    public JFXTextField txtAmount;
    public Label lblDate;
    public JFXTextField txtCost;
    public JFXComboBox cmbPaymentMethod;


    RawStockBO rawStockBO = (RawStockBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RAWSTOCK);

    public void initialize(){
        lblDate.setText(getDate("yyyy-MM-dd"));

        try {
            cmbRawItem.setItems(rawStockBO.getAllMaterials());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void clear(){
        ObservableList list = FXCollections.observableArrayList();

        cmbPaymentMethod.setItems(list);
        cmbRawItem.setItems(list);
        cmbSupplierID.setItems(list);

        lblSupplierName.setText("");
        lblBatchId.setText("");

        txtAmount.clear();
        txtCost.clear();
    }

    public void cmbRawItemOnAction(ActionEvent actionEvent) {
        String id = String.valueOf(cmbRawItem.getValue());
        String firstLetter = String.valueOf(id.charAt(0));

        try {
            lblBatchId.setText(rawStockBO.nextBatchID(firstLetter));
            cmbSupplierID.setItems(rawStockBO.getAllId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void cmbSupplierIDOnAction(ActionEvent actionEvent) {
        String supId = String.valueOf(cmbSupplierID.getValue());
        try {
            lblSupplierName.setText(rawStockBO.search(supId).getSupplierName());
            cmbPaymentMethod.setItems(rawStockBO.paymentmethod());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void btnSubmitOnAction(ActionEvent actionEvent) {

        String materialId = String.valueOf(lblBatchId.getText().charAt(0));
        RawStockDTO rawStockDTO = new RawStockDTO(lblBatchId.getText(), materialId, Integer.valueOf(txtAmount.getText()), String.valueOf(cmbSupplierID.getValue()), Date.valueOf(lblDate.getText()));

        try {

            boolean isAdded = rawStockBO.add(rawStockDTO);
            boolean isUpdated = rawStockBO.updateMaterial(Integer.valueOf(txtAmount.getText()), materialId);
            boolean isUpdatedCost = rawStockBO.updatePaymentMethodMinus(Integer.valueOf(txtCost.getText()), String.valueOf(cmbPaymentMethod.getValue()));
            boolean isUpdateFinance = rawStockBO.updateFinance(rawStockBO.getPaymentId(String.valueOf(cmbPaymentMethod.getValue())), Integer.valueOf(txtCost.getText()));

            if(isAdded && isUpdated && isUpdatedCost && isUpdateFinance){

                Image image = new Image("/lk/ijse/spicesystem/asset/correct.png");
                Notifications notifications = Notifications.create();
                notifications.graphic(new ImageView(image));
                notifications.text("Added Suuccesful");
                notifications.title("Spice System");
                notifications.hideAfter(Duration.seconds(3));
                notifications.show();

                clear();

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnBackOnAction(ActionEvent actionEvent) {
    }

    public String getDate(String s){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(s);
        String date = LocalDateTime.now().format(formatter);
        return date;
    }

    public void cmbPaymentMethodOnAction(ActionEvent actionEvent) {
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

    public void txtCostOnKeyReleased(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(txtCost.getText());

        boolean isMatch = matcher.matches();

        if(!isMatch){
            txtCost.setFocusColor(javafx.scene.paint.Paint.valueOf("#F506FF"));
        }else{
            txtCost.setFocusColor(Paint.valueOf("#07d5e0"));
        }
    }
}
