package lk.ijse.spicesystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.SuperBO;

import java.sql.SQLException;

public interface MaterialBO extends SuperBO {
    public boolean materialTable(int amount, String material) throws SQLException, ClassNotFoundException;
    public ObservableList getAllMaterials() throws SQLException, ClassNotFoundException;
    public boolean updateMaterial(int amount, String id) throws SQLException, ClassNotFoundException;
}
