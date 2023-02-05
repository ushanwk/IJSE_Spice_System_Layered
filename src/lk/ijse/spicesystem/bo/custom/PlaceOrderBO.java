package lk.ijse.spicesystem.bo.custom;

import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.model.Order;

import java.sql.SQLException;

public interface PlaceOrderBO extends SuperBO {
    public String nextId() throws SQLException, ClassNotFoundException;
    public boolean add(Order order) throws SQLException, ClassNotFoundException;
}
