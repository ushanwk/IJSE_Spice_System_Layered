package lk.ijse.spicesystem.bo.custom;

import lk.ijse.spicesystem.bo.SuperBO;

import java.sql.SQLException;

public interface FinanceBO extends SuperBO {
    public boolean updateFinance(String payment, int Price) throws SQLException, ClassNotFoundException;
}
