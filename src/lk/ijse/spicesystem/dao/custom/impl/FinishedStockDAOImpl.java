package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.custom.FinishedStockDAO;
import lk.ijse.spicesystem.to.FinishedStock;

import java.sql.SQLException;

public class FinishedStockDAOImpl implements FinishedStockDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(FinishedStock finishedStock) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public FinishedStock search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(FinishedStock finishedStock) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
