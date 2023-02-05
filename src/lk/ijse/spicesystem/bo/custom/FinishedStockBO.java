package lk.ijse.spicesystem.bo.custom;

import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.model.FinishedStock;

import java.sql.SQLException;

public interface FinishedStockBO extends SuperBO {
    public String nextId() throws SQLException, ClassNotFoundException;
    public boolean update(FinishedStock finishedStock) throws SQLException, ClassNotFoundException;
}
