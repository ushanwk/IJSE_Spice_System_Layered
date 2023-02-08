package lk.ijse.spicesystem.modelBefore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.entity.Shop;
import lk.ijse.spicesystem.dao.CrudUtil;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopModel {

    public static String nextShopId() throws SQLException, ClassNotFoundException {

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

    public static boolean addShopDetail(Shop shop) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO Shop VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        return CrudUtil.execute(sql, shop.getShopId(), shop.getShopName(), shop.getAddress(), shop.getEmail(), shop.getShopTelephone(), shop.getOwnerName(),
                shop.getOwnerNic(), shop.getOwnerTelephone());

    }

    public static ObservableList getAllShopId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT ShopID FROM shop";
        ResultSet result = CrudUtil.execute(sql);

        ObservableList<String> list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("ShopID"));
        }

        return list;
    }

    public static Shop searchShop(String id) throws SQLException, ClassNotFoundException {

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

    public static boolean updateShop(Shop shop) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE Shop SET ShopName = ?, Address = ?, Email = ?, ShopTelephone = ?, OwnerName = ?, OwnerNIC = ?, OwnerTelephone = ? WHERE ShopID = ?";

        return CrudUtil.execute(sql, shop.getShopName(), shop.getAddress(), shop.getEmail(), shop.getShopTelephone(), shop.getOwnerName(), shop.getOwnerNic(), shop.getOwnerTelephone(), shop.getShopId());

    }

    public static boolean deleteShop(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM Shop WHERE ShopID = ?";

        return CrudUtil.execute(sql, id);

    }

}
