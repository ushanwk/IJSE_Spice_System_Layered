package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.custom.RawStockDAO;
import lk.ijse.spicesystem.to.RawStock;

import java.sql.SQLException;

public class RawStockDAOImpl implements RawStockDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(RawStock rawStock) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public RawStock search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(RawStock rawStock) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
