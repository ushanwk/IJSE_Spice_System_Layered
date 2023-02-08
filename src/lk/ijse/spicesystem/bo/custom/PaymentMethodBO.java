package lk.ijse.spicesystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.dto.PaymentMethodDTO;

import java.sql.SQLException;

public interface PaymentMethodBO extends SuperBO {
    public ObservableList<String> paymentmethod() throws SQLException, ClassNotFoundException;
    public boolean updatePaymentMethod(String payament, Double price) throws SQLException, ClassNotFoundException;
    public String getPaymentId(String Paymnt) throws SQLException, ClassNotFoundException;
    public boolean updatePaymentMethodMinus(int cost, String paymentMethod) throws SQLException, ClassNotFoundException;
}
