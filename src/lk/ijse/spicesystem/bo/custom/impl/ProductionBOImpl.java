package lk.ijse.spicesystem.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.custom.ProductionBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.ProductionDAO;

import java.sql.SQLException;

public class ProductionBOImpl implements ProductionBO {

    ProductionDAO productionDAO = (ProductionDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCTION);

    @Override
    public ObservableList getProductionItem() throws SQLException, ClassNotFoundException {
        return productionDAO.getProductionItem();
    }

    @Override
    public String getProductionId(String item) throws SQLException, ClassNotFoundException {
        return productionDAO.getProductionId(item);
    }

    @Override
    public boolean updateProductionTable(String productionId, int amount) throws SQLException, ClassNotFoundException {
        return productionDAO.updateProductionTable(productionId, amount);
    }

    @Override
    public ObservableList getProduction(String id) throws SQLException, ClassNotFoundException {
        return productionDAO.getProduction(id);
    }

    @Override
    public boolean productionTale(int amount, String productionItem) throws SQLException, ClassNotFoundException {
        return productionDAO.productionTale(amount, productionItem);
    }


}
