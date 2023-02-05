package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.custom.ProductionStockDAO;
import lk.ijse.spicesystem.to.ProductionStock;

import java.sql.SQLException;

public class ProductionStockDAOImpl implements ProductionStockDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(ProductionStock productionStock) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ProductionStock search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(ProductionStock productionStock) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
