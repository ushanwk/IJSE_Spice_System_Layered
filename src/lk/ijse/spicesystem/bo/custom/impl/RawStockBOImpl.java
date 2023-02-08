package lk.ijse.spicesystem.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.custom.RawStockBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.RawStockDAO;
import lk.ijse.spicesystem.dto.RawStockDTO;
import lk.ijse.spicesystem.entity.RawStock;

import java.sql.SQLException;

public class RawStockBOImpl implements RawStockBO {

    RawStockDAO rawStockDAO = (RawStockDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RAWSTOCK);

    @Override
    public boolean add(RawStockDTO rawStockDTO) throws SQLException, ClassNotFoundException {
        RawStock rawStock = new RawStock(rawStockDTO.getBatchId(), rawStockDTO.getMaterialId(), rawStockDTO.getAmount(), rawStockDTO.getSupplierId(), rawStockDTO.getDate());
        return rawStockDAO.add(rawStock);
    }

    @Override
    public ObservableList<String> getBatchID(String materialId) throws SQLException, ClassNotFoundException {
        return rawStockDAO.getBatchID(materialId);
    }

    @Override
    public int getQtyOnHandBatchId(String batchId) throws SQLException, ClassNotFoundException {
        return rawStockDAO.getQtyOnHandBatchId(batchId);
    }

    @Override
    public boolean RawStockTable(int amount, String batchId) throws SQLException, ClassNotFoundException {
        return rawStockDAO.RawStockTable(amount, batchId);
    }

    @Override
    public String nextBatchID(String id) throws SQLException, ClassNotFoundException {
        return rawStockDAO.nextBatchID(id);
    }

}
