package lk.ijse.spicesystem.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.custom.ShopBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.ShopDAO;
import lk.ijse.spicesystem.model.Shop;

import java.sql.SQLException;

public class ShopBOImpl implements ShopBO {

    ShopDAO shopDAO = (ShopDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SHOP);

    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return shopDAO.nextId();
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return shopDAO.getAllId();
    }

    @Override
    public boolean add(Shop shop) throws SQLException, ClassNotFoundException {
        return shopDAO.add(shop);
    }

    @Override
    public Shop search(String id) throws SQLException, ClassNotFoundException {
        return shopDAO.search(id);
    }

    @Override
    public boolean update(Shop shop) throws SQLException, ClassNotFoundException {
        return shopDAO.update(shop);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return shopDAO.delete(id);
    }

    @Override
    public ObservableList getShopId() throws SQLException, ClassNotFoundException {
        return shopDAO.getShopId();
    }

    @Override
    public String getShopName(String id) throws SQLException, ClassNotFoundException {
        return shopDAO.getShopName(id);
    }
}
