package lk.ijse.spicesystem.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudDAO;
import lk.ijse.spicesystem.to.ProductionStock;

import java.sql.SQLException;

public interface ProductionStockDAO extends CrudDAO<ProductionStock> {
    public ObservableList getProductionStockId(String productionId) throws SQLException, ClassNotFoundException;
    public int getQtyOnHand(String productionStockId) throws SQLException, ClassNotFoundException;
}
