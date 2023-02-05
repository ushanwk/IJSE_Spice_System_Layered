package lk.ijse.spicesystem.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.custom.ProductionStockBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.ProductionStockDAO;
import lk.ijse.spicesystem.model.ProductionStock;

import java.sql.SQLException;

public class ProductionStockBOImpl implements ProductionStockBO {

    ProductionStockDAO productionStockDAO = (ProductionStockDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCTIONSTOCK);

    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return productionStockDAO.nextId();
    }

    @Override
    public boolean add(ProductionStock productionStock) throws SQLException, ClassNotFoundException {
        return productionStockDAO.add(productionStock);
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
}
