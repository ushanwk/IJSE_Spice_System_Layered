package lk.ijse.spicesystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.model.RawStock;

import java.sql.SQLException;

public interface RawStockBO extends SuperBO {
    public boolean add(RawStock rawStock) throws SQLException, ClassNotFoundException;
    public ObservableList getBatchID(String materialId) throws SQLException, ClassNotFoundException;
    public int getQtyOnHandBatchId(String batchId) throws SQLException, ClassNotFoundException;
    public boolean RawStockTable(int amount, String batchId) throws SQLException, ClassNotFoundException;
    public String nextBatchID(String id) throws SQLException, ClassNotFoundException;
}
