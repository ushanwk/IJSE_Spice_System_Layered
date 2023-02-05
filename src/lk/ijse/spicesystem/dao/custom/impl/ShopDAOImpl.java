package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudUtil;
import lk.ijse.spicesystem.dao.custom.ShopDAO;
import lk.ijse.spicesystem.to.Shop;

import java.sql.ResultSet;
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

    @Override
    public ObservableList getShopId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT ShopID FROM shop";

        ResultSet result = CrudUtil.execute(sql);

        ObservableList list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("ShopID"));
        }

        return list;
    }

    @Override
    public String getShopName(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT ShopName FROM Shop WHERE ShopID = ?";

        ResultSet result = CrudUtil.execute(sql, id);

        if(result.next()){
            return result.getString("ShopName");
        }

        return null;
    }
}
