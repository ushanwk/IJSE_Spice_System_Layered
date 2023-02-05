package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudUtil;
import lk.ijse.spicesystem.dao.custom.RawStockDAO;
import lk.ijse.spicesystem.to.RawStock;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RawStockDAOImpl implements RawStockDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(RawStock rawStock) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public RawStock search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(RawStock rawStock) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ObservableList getBatchID(String materialId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT BatchID FROM RawStock WHERE MaterialID = ?";

        ResultSet result = CrudUtil.execute(sql, materialId);

        ObservableList<String> list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("BatchID"));
        }

        return list;
    }

    @Override
    public int getQtyOnHandBatchId(String batchId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT QtyOnHand FROM RawStock WHERE BatchID = ?";

        ResultSet result = CrudUtil.execute(sql, batchId);

        int qty = 0;

        if(result.next()){
            qty = result.getInt("QtyOnHand");
        }

        return qty;
    }

    @Override
    public boolean RawStockTable(int amount, String batchId) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE RawStock SET QtyOnHand = QtyOnHand - ? WHERE BatchID = ?";

        return CrudUtil.execute(sql, amount, batchId);
    }
}
