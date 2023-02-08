package lk.ijse.spicesystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.dto.ShopDTO;
import lk.ijse.spicesystem.entity.Shop;

import java.sql.SQLException;

public interface ShopBO extends SuperBO {
    public String nextId() throws SQLException, ClassNotFoundException;
    public ObservableList<String> getAllId() throws SQLException, ClassNotFoundException;
    public boolean add(ShopDTO shopDTO) throws SQLException, ClassNotFoundException;
    public ShopDTO search(String id) throws SQLException, ClassNotFoundException;
    public boolean update(ShopDTO shopDTO) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public ObservableList getShopId() throws SQLException, ClassNotFoundException;
    public String getShopName(String id) throws SQLException, ClassNotFoundException;
}
