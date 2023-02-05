package lk.ijse.spicesystem.bo.custom.impl;

import lk.ijse.spicesystem.bo.custom.PlaceOrderBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.PlaceOrderDAO;
import lk.ijse.spicesystem.model.Order;

import java.sql.SQLException;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    PlaceOrderDAO placeOrderDAO = (PlaceOrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PLACEORDER);

    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return placeOrderDAO.nextId();
    }

    @Override
    public boolean add(Order order) throws SQLException, ClassNotFoundException {
        return placeOrderDAO.update(order);
    }
}
