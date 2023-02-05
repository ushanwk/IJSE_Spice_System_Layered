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
        String sql = "SELECT ShopID FROM shop ORDER BY ShopID DESC LIMIT 1";

        ResultSet result = CrudUtil.execute(sql);

        String latestId = null;

        if(result.next()){
            latestId = result.getString("ShopID");
        }

        String[] S0s = latestId.split("S0");

        for (String a:S0s) {
            latestId = a;
        }

        int idNum = Integer.parseInt(latestId);

        latestId = "S0" + (idNum+1);

        return latestId;
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT ShopID FROM shop";
        ResultSet result = CrudUtil.execute(sql);

        ObservableList<String> list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("ShopID"));
        }

        return list;
    }

    @Override
    public boolean add(Shop shop) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Shop VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        return CrudUtil.execute(sql, shop.getShopId(), shop.getShopName(), shop.getAddress(), shop.getEmail(), shop.getShopTelephone(), shop.getOwnerName(),
                shop.getOwnerNic(), shop.getOwnerTelephone());
    }

    @Override
    public Shop search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM shop WHERE ShopID = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if(result.next()){
            return new Shop(
                    result.getString("ShopID"),
                    result.getString("ShopName"),
                    result.getString("Address"),
                    result.getString("Email"),
                    Integer.valueOf(result.getString("ShopTelephone")),
                    result.getString("OwnerName"),
                    result.getString("OwnerNIC"),
                    Integer.valueOf(result.getString("OwnerTelephone"))
            );
        }

        return null;
    }

    @Override
    public boolean update(Shop shop) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Shop SET ShopName = ?, Address = ?, Email = ?, ShopTelephone = ?, OwnerName = ?, OwnerNIC = ?, OwnerTelephone = ? WHERE ShopID = ?";

        return CrudUtil.execute(sql, shop.getShopName(), shop.getAddress(), shop.getEmail(), shop.getShopTelephone(), shop.getOwnerName(), shop.getOwnerNic(), shop.getOwnerTelephone(), shop.getShopId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Shop WHERE ShopID = ?";

        return CrudUtil.execute(sql, id);
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
