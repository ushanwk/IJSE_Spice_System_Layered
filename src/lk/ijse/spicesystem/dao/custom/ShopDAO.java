package lk.ijse.spicesystem.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudDAO;
import lk.ijse.spicesystem.to.Shop;

import java.sql.SQLException;

public interface ShopDAO extends CrudDAO<Shop> {
    public ObservableList getShopId() throws SQLException, ClassNotFoundException;
    public String getShopName(String id) throws SQLException, ClassNotFoundException;
}
