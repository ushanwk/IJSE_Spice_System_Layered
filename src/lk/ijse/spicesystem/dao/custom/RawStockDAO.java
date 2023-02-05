package lk.ijse.spicesystem.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudDAO;
import lk.ijse.spicesystem.model.RawStock;

import java.sql.SQLException;

public interface RawStockDAO extends CrudDAO<RawStock> {
    public ObservableList getBatchID(String materialId) throws SQLException, ClassNotFoundException;
    public int getQtyOnHandBatchId(String batchId) throws SQLException, ClassNotFoundException;
    public boolean RawStockTable(int amount, String batchId) throws SQLException, ClassNotFoundException;
    public String nextBatchID(String id) throws SQLException, ClassNotFoundException;
}
