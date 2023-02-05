package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudUtil;
import lk.ijse.spicesystem.dao.SuperDAO;
import lk.ijse.spicesystem.dao.custom.SupplierDAO;
import lk.ijse.spicesystem.to.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
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

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT SupID FROM Supplier";
        ResultSet result = CrudUtil.execute(sql);

        ObservableList<String> list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("SupID"));
        }

        return list;
    }

    @Override
    public boolean add(Supplier supplier) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Supplier VALUES (?, ?, ?, ?, ?)";

        return CrudUtil.execute(sql, supplier.getSupId(), supplier.getSupplierName(), supplier.getAddress(), supplier.getEmail(), supplier.getTelephone());

    }

    @Override
    public Supplier search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Supplier WHERE SupID = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if(result.next()) {
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

    @Override
    public boolean update(Supplier supplier) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Supplier SET SupplierName = ?, Address = ?, Email = ?, Telephone = ? WHERE SupID = ?";

        return CrudUtil.execute(sql, supplier.getSupplierName(), supplier.getAddress(), supplier.getEmail(), supplier.getTelephone(), supplier.getSupId());

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Supplier WHERE SupID = ?";

        return CrudUtil.execute(sql, id);
    }
}
