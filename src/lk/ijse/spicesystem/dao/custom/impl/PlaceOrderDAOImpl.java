package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudUtil;
import lk.ijse.spicesystem.dao.custom.PlaceOrderDAO;
import lk.ijse.spicesystem.to.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT OrderID FROM oerder ORDER BY OrderID DESC LIMIT 1";

        ResultSet result = CrudUtil.execute(sql);

        String latestId = null;

        if(result.next()){
            latestId = result.getString("OrderID");
        }

        String[] SUs = latestId.split("ORD");

        for (String a:SUs) {
            latestId = a;
        }

        int idNum = Integer.parseInt(latestId);

        latestId = "ORD" + (idNum+1);

        return latestId;
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Order order) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Order search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Order order) throws SQLException, ClassNotFoundException {
        String  sql = "INSERT INTO oerder VALUES (?, ?, ?, ?, ?)";

        return CrudUtil.execute(sql, order.getOrderID(), order.getShopID(), order.getFinishedItem(), order.getAmount(), order.getPrice());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
