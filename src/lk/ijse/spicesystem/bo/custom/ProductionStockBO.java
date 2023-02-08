package lk.ijse.spicesystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.dto.ProductionStockDTO;
import lk.ijse.spicesystem.entity.ProductionStock;

import java.sql.SQLException;

public interface ProductionStockBO extends SuperBO {
    public String nextId() throws SQLException, ClassNotFoundException;
    public boolean add(ProductionStockDTO productionStockDTO) throws SQLException, ClassNotFoundException;
    public ObservableList getProductionStockId(String productionId) throws SQLException, ClassNotFoundException;
    public int getQtyOnHand(String productionStockId) throws SQLException, ClassNotFoundException;
    public boolean updateProductionStockTable(String productionStockId, int amount) throws SQLException, ClassNotFoundException;
}
