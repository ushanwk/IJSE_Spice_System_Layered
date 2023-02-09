package lk.ijse.spicesystem.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.custom.ProductionStockBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.MaterialDAO;
import lk.ijse.spicesystem.dao.custom.ProductionDAO;
import lk.ijse.spicesystem.dao.custom.ProductionStockDAO;
import lk.ijse.spicesystem.dao.custom.RawStockDAO;
import lk.ijse.spicesystem.dto.ProductionStockDTO;
import lk.ijse.spicesystem.entity.ProductionStock;

import java.sql.SQLException;

public class ProductionStockBOImpl implements ProductionStockBO {

    ProductionStockDAO productionStockDAO = (ProductionStockDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCTIONSTOCK);
    RawStockDAO rawStockDAO = (RawStockDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RAWSTOCK);
    ProductionDAO productionDAO = (ProductionDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCTION);
    MaterialDAO materialDAO = (MaterialDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MATERIAL);

    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return productionStockDAO.nextId();
    }

    @Override
    public boolean add(ProductionStockDTO productionStockDTO) throws SQLException, ClassNotFoundException {
        return productionStockDAO.add(new ProductionStock(productionStockDTO.getProductionStockID(), productionStockDTO.getAmount(), productionStockDTO.getBatchID(), productionStockDTO.getProductionID()));
    }

    @Override
    public ObservableList getProductionStockId(String productionId) throws SQLException, ClassNotFoundException {
        return productionStockDAO.getProductionStockId(productionId);
    }

    @Override
    public int getQtyOnHand(String productionStockId) throws SQLException, ClassNotFoundException {
        return productionStockDAO.getQtyOnHand(productionStockId);
    }

    @Override
    public boolean updateProductionStockTable(String productionStockId, int amount) throws SQLException, ClassNotFoundException {
        return productionStockDAO.updateProductionStockTable(productionStockId, amount);
    }

    public ObservableList<String> getBatchID(String materialId) throws SQLException, ClassNotFoundException {
        return rawStockDAO.getBatchID(materialId);
    }

    public boolean RawStockTable(int amount, String batchId) throws SQLException, ClassNotFoundException {
        return rawStockDAO.RawStockTable(amount, batchId);
    }

    public ObservableList getProduction(String id) throws SQLException, ClassNotFoundException {
        return productionDAO.getProduction(id);
    }

    public boolean productionTale(int amount, String productionItem) throws SQLException, ClassNotFoundException {
        return productionDAO.productionTale(amount, productionItem);
    }

    public boolean materialTable(int amount, String material) throws SQLException, ClassNotFoundException {
        return materialDAO.materialTable(amount, material);
    }
}
