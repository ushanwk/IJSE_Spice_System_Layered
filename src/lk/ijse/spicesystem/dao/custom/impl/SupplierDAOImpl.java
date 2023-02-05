package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.SuperDAO;
import lk.ijse.spicesystem.dao.custom.SupplierDAO;
import lk.ijse.spicesystem.to.Supplier;

import java.sql.SQLException;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Supplier supplier) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Supplier search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Supplier supplier) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
