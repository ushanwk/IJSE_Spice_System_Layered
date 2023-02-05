package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.custom.ShopDAO;
import lk.ijse.spicesystem.to.Shop;

import java.sql.SQLException;

public class ShopDAOImpl implements ShopDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Shop shop) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Shop search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Shop shop) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
