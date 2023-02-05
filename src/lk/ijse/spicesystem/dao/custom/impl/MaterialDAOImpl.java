package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudUtil;
import lk.ijse.spicesystem.dao.custom.MaterialDAO;
import lk.ijse.spicesystem.to.Material;

import java.sql.SQLException;

public class MaterialDAOImpl implements MaterialDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Material material) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Material search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Material material) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean materialTable(int amount, String material) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE material SET AmountInStock = AmountInStock - ? WHERE Material = ?";

        return CrudUtil.execute(sql, amount, material);
    }
}
