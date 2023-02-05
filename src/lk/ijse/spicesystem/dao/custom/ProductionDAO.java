package lk.ijse.spicesystem.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudDAO;
import lk.ijse.spicesystem.to.Production;

import java.sql.SQLException;

public interface ProductionDAO extends CrudDAO<Production> {
    public ObservableList getProductionItem() throws SQLException, ClassNotFoundException;
    public String getProductionId(String item) throws SQLException, ClassNotFoundException;
}
