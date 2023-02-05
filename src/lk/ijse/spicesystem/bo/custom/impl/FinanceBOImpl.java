package lk.ijse.spicesystem.bo.custom.impl;

import lk.ijse.spicesystem.bo.custom.FinanceBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.FinanceDAO;

import java.sql.SQLException;

public class FinanceBOImpl implements FinanceBO {

    FinanceDAO financeDAO = (FinanceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.FINANCE);
    @Override
    public boolean updateFinance(String payment, int Price) throws SQLException, ClassNotFoundException {
        return financeDAO.updateFinance(payment, Price);
    }


}
