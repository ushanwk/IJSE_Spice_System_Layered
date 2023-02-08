package lk.ijse.spicesystem.dao.custom;

import lk.ijse.spicesystem.dao.CrudDAO;
import lk.ijse.spicesystem.entity.Finance;

import java.sql.SQLException;

public interface FinanceDAO extends CrudDAO<Finance> {
    public boolean updateFinance(String payment, int Price) throws SQLException, ClassNotFoundException;
}
