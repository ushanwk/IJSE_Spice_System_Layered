package lk.ijse.spicesystem.bo.custom.impl;

import lk.ijse.spicesystem.bo.custom.PlaceOrderBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.PlaceOrderDAO;
import lk.ijse.spicesystem.dto.OrderDTO;
import lk.ijse.spicesystem.entity.Order;

import java.sql.SQLException;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    PlaceOrderDAO placeOrderDAO = (PlaceOrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PLACEORDER);

    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return placeOrderDAO.nextId();
    }

    @Override
    public boolean add(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        Order order = new Order(orderDTO.getOrderID(), orderDTO.getShopID(), orderDTO.getFinishedItem(), orderDTO.getAmount(), orderDTO.getPrice());
        return placeOrderDAO.update(order);
    }
}
