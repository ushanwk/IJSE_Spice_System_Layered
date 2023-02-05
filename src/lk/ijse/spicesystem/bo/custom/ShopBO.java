package lk.ijse.spicesystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.model.Shop;

import java.sql.SQLException;

public interface ShopBO extends SuperBO {
    public String nextId() throws SQLException, ClassNotFoundException;
    public ObservableList getAllId() throws SQLException, ClassNotFoundException;
    public boolean add(Shop shop) throws SQLException, ClassNotFoundException;
    public Shop search(String id) throws SQLException, ClassNotFoundException;
    public boolean update(Shop shop) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public ObservableList getShopId() throws SQLException, ClassNotFoundException;
    public String getShopName(String id) throws SQLException, ClassNotFoundException;
}
