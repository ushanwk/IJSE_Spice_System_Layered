package lk.ijse.spicesystem.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.BOFactory;
import lk.ijse.spicesystem.bo.custom.FinishedItemBO;
import lk.ijse.spicesystem.bo.custom.FinishedStockBO;
import lk.ijse.spicesystem.bo.custom.ProductionBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.FinishedItemDAO;
import lk.ijse.spicesystem.dao.custom.FinishedStockDAO;
import lk.ijse.spicesystem.dao.custom.ProductionDAO;
import lk.ijse.spicesystem.dao.custom.ProductionStockDAO;
import lk.ijse.spicesystem.dto.FinishedStockDTO;
import lk.ijse.spicesystem.entity.FinishedStock;

import java.sql.SQLException;

public class FinishedStockBOImpl implements FinishedStockBO {

    FinishedStockDAO finishedStockDAO = (FinishedStockDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.FINISHEDSTOCK);
    ProductionDAO productionDAO = (ProductionDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCTION);
    ProductionStockDAO productionStockDAO = (ProductionStockDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCTIONSTOCK);
    FinishedItemDAO finishedItemDAO = (FinishedItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.FINISHEDITEM);

    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return finishedStockDAO.nextId();
    }

    @Override
    public boolean update(FinishedStockDTO finishedStockDTO) throws SQLException, ClassNotFoundException {
        FinishedStock finishedStock = new FinishedStock(finishedStockDTO.getFinishedStockId(), finishedStockDTO.getBarcodeNo(), finishedStockDTO.getAmount(), finishedStockDTO.getProductionStockId(), finishedStockDTO.getQtyOnHand());
        return finishedStockDAO.update(finishedStock);
    }

    public ObservableList<String> getProductionItem() throws SQLException, ClassNotFoundException {
        return productionDAO.getProductionItem();
    }

    public boolean updateProductionTable(String productionId, int amount) throws SQLException, ClassNotFoundException {
        return productionDAO.updateProductionTable(productionId, amount);
    }

    public String getProductionId(String item) throws SQLException, ClassNotFoundException {
        return productionDAO.getProductionId(item);
    }

    public ObservableList getProductionStockId(String productionId) throws SQLException, ClassNotFoundException {
        return productionStockDAO.getProductionStockId(productionId);
    }

    public boolean updateProductionStockTable(String productionStockId, int amount) throws SQLException, ClassNotFoundException {
        return productionStockDAO.updateProductionStockTable(productionStockId, amount);
    }

    public String getQtyOnHand(String finishedItem) throws SQLException, ClassNotFoundException {
        return finishedItemDAO.getQtyOnHand(finishedItem);
    }

    public ObservableList<String> getFinishedItem(String item) throws SQLException, ClassNotFoundException {
        ObservableList<String> finishedItems = finishedItemDAO.getFinishedItem(item);
        ObservableList<String> finishedItemDTOS = FXCollections.observableArrayList();

        for (String f : finishedItems) {
            finishedItemDTOS.add(f);
        }

        return finishedItemDTOS;
    }

    public String getBarcode(String finishedItem) throws SQLException, ClassNotFoundException {
        return finishedItemDAO.getBarcode(finishedItem);
    }

    public boolean updateFinishedItemTable(String barcodeNo, int amount) throws SQLException, ClassNotFoundException {
        return finishedItemDAO.updateFinishedItemTable(barcodeNo, amount);
    }


}
