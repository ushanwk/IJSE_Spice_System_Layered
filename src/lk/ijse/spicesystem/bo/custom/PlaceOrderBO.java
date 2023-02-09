package lk.ijse.spicesystem.bo.custom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.dto.OrderDTO;
import lk.ijse.spicesystem.entity.Order;

import java.sql.SQLException;

public interface PlaceOrderBO extends SuperBO {
    public String nextId() throws SQLException, ClassNotFoundException;
    public boolean add(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
    public ObservableList<String> getFinishedItem(String item) throws SQLException, ClassNotFoundException;
    public String getQtyOnHand(String finishedItem) throws SQLException, ClassNotFoundException;
    public boolean updateFinishedItem(String item, int amount) throws SQLException, ClassNotFoundException;
    public boolean updateFinance(String payment, int Price) throws SQLException, ClassNotFoundException;
    public ObservableList<String> paymentmethod() throws SQLException, ClassNotFoundException;
    public boolean updatePaymentMethod(String payament, Double price) throws SQLException, ClassNotFoundException;
    public ObservableList<String> getAllId() throws SQLException, ClassNotFoundException;
    public String getShopName(String id) throws SQLException, ClassNotFoundException;
    public ObservableList<String> getProductionItem() throws SQLException, ClassNotFoundException;
}
