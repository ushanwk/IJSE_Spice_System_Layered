package lk.ijse.spicesystem.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudDAO;
import lk.ijse.spicesystem.entity.Material;

import java.sql.SQLException;

public interface MaterialDAO extends CrudDAO<Material> {
    public boolean materialTable(int amount, String material) throws SQLException, ClassNotFoundException;
    public ObservableList getAllMaterials() throws SQLException, ClassNotFoundException;

    public boolean updateMaterial(int amount, String id) throws SQLException, ClassNotFoundException;
}
