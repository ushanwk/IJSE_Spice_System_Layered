package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudUtil;
import lk.ijse.spicesystem.dao.custom.ProductionStockDAO;
import lk.ijse.spicesystem.to.ProductionStock;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductionStockDAOImpl implements ProductionStockDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(ProductionStock productionStock) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ProductionStock search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(ProductionStock productionStock) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ObservableList getProductionStockId(String productionId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT ProductionStockID FROM productionStock WHERE ProductionID = ?";

        ResultSet result = CrudUtil.execute(sql, productionId);

        ObservableList list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("ProductionStockID"));
        }

        return list;
    }

    @Override
    public int getQtyOnHand(String productionStockId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT QtyOnHand FROM productionStock WHERE ProductionStockID = ?";

        ResultSet result = CrudUtil.execute(sql, productionStockId);

        if(result.next()){
            return (Integer.valueOf(result.getString("QtyOnHand")));
        }

        return 0;
    }

    @Override
    public boolean updateProductionStockTable(String productionStockId, int amount) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE productionStock SET QtyOnHand = QtyOnHand - ? WHERE ProductionStockID = ?";

        return CrudUtil.execute(sql, amount, productionStockId);
    }
}
