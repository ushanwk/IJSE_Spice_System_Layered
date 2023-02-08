package lk.ijse.spicesystem.bo.custom;

import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.dto.OrderDTO;
import lk.ijse.spicesystem.entity.Order;

import java.sql.SQLException;

public interface PlaceOrderBO extends SuperBO {
    public String nextId() throws SQLException, ClassNotFoundException;
    public boolean add(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
}
