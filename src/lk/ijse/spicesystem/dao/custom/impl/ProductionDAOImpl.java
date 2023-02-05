package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudUtil;
import lk.ijse.spicesystem.dao.custom.ProductionDAO;
import lk.ijse.spicesystem.model.Production;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductionDAOImpl implements ProductionDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Production production) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Production search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Production production) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ObservableList getProductionItem() throws SQLException, ClassNotFoundException {
        String sql = "SELECT ProductionItem FROM production";

        ResultSet result = CrudUtil.execute(sql);

        ObservableList list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("ProductionItem"));
        }

        return list;
    }

    @Override
    public String getProductionId(String item) throws SQLException, ClassNotFoundException {
        String sql = "SELECT ProductionID FROM production WHERE ProductionItem = ?";

        ResultSet result = CrudUtil.execute(sql, item);

        String id = null;

        if(result.next()){
            id = result.getString("ProductionID");
        }

        return id;
    }

    @Override
    public boolean updateProductionTable(String productionId, int amount) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE production SET AmountInStock = AmountInStock - ? WHERE ProductionID = ?";

        return CrudUtil.execute(sql, amount, productionId);
    }

    @Override
    public ObservableList getProduction(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT ProductionItem From production WHERE MaterialID = ?";

        String mId = String.valueOf(id.charAt(0));

        ResultSet result = CrudUtil.execute(sql, mId);

        ObservableList<String> list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("ProductionItem"));
        }

        return list;
    }

    @Override
    public boolean productionTale(int amount, String productionItem) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE production SET AmountInStock = AmountInStock + ? WHERE ProductionItem = ?";

        return CrudUtil.execute(sql, amount, productionItem);
    }
}
