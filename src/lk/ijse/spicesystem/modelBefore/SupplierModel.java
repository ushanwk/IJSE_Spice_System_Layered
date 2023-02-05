package lk.ijse.spicesystem.modelBefore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.model.Supplier;
import lk.ijse.spicesystem.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierModel {

    public static String nextShopId() throws SQLException, ClassNotFoundException {

        String sql = "SELECT SupID FROM Supplier ORDER BY SupID DESC LIMIT 1";

        ResultSet result = CrudUtil.execute(sql);

        String latestId = null;

        if(result.next()){
            latestId = result.getString("SupID");
        }

        String[] SUs = latestId.split("SU");

        for (String a:SUs) {
            latestId = a;
        }

        int idNum = Integer.parseInt(latestId);

        latestId = "SU" + (idNum+1);

        return latestId;

    }

    public static boolean addSupplierDetail(Supplier supplier) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO Supplier VALUES (?, ?, ?, ?, ?)";

        return CrudUtil.execute(sql, supplier.getSupId(), supplier.getSupplierName(), supplier.getAddress(), supplier.getEmail(), supplier.getTelephone());

    }

    public static ObservableList getAllSupId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT SupID FROM Supplier";
        ResultSet result = CrudUtil.execute(sql);

        ObservableList<String> list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("SupID"));
        }

        return list;
    }

    public static Supplier searchSupplier(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM Supplier WHERE SupID = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if(result.next()){
            return new Supplier(
                    result.getString("SupID"),
                    result.getString("SupplierName"),
                    result.getString("Address"),
                    result.getString("Email"),
                    Integer.valueOf(result.getString("Telephone"))
            );

        }

        return null;
    }

    public static boolean updateSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE Supplier SET SupplierName = ?, Address = ?, Email = ?, Telephone = ? WHERE SupID = ?";

        return CrudUtil.execute(sql, supplier.getSupplierName(), supplier.getAddress(), supplier.getEmail(), supplier.getTelephone(), supplier.getSupId());

    }

    public static boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM Supplier WHERE SupID = ?";

        return CrudUtil.execute(sql, id);

    }


}
