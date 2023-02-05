package lk.ijse.spicesystem.bo.custom.impl;

import lk.ijse.spicesystem.bo.custom.FinishedStockBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.FinishedStockDAO;
import lk.ijse.spicesystem.model.FinishedStock;

import java.sql.SQLException;

public class FinishedStockBOImpl implements FinishedStockBO {

    FinishedStockDAO finishedStockDAO = (FinishedStockDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.FINISHEDSTOCK);

    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return finishedStockDAO.nextId();
    }

    @Override
    public boolean update(FinishedStock finishedStock) throws SQLException, ClassNotFoundException {
        return finishedStockDAO.update(finishedStock);
    }


}
