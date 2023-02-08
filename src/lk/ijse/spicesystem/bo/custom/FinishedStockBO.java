package lk.ijse.spicesystem.bo.custom;

import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.dto.FinishedStockDTO;
import lk.ijse.spicesystem.entity.FinishedStock;

import java.sql.SQLException;

public interface FinishedStockBO extends SuperBO {
    public String nextId() throws SQLException, ClassNotFoundException;
    public boolean update(FinishedStockDTO finishedStockDTO) throws SQLException, ClassNotFoundException;
}
