package lk.ijse.spicesystem.bo.custom.impl;

import lk.ijse.spicesystem.bo.custom.FinishedStockBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.FinishedStockDAO;
import lk.ijse.spicesystem.dto.FinishedStockDTO;
import lk.ijse.spicesystem.entity.FinishedStock;

import java.sql.SQLException;

public class FinishedStockBOImpl implements FinishedStockBO {

    FinishedStockDAO finishedStockDAO = (FinishedStockDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.FINISHEDSTOCK);

    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return finishedStockDAO.nextId();
    }

    @Override
    public boolean update(FinishedStockDTO finishedStockDTO) throws SQLException, ClassNotFoundException {
        FinishedStock finishedStock = new FinishedStock(finishedStockDTO.getFinishedStockId(), finishedStockDTO.getBarcodeNo(), finishedStockDTO.getAmount(), finishedStockDTO.getProductionStockId(), finishedStockDTO.getQtyOnHand());
        return finishedStockDAO.update(finishedStock);
    }


}
