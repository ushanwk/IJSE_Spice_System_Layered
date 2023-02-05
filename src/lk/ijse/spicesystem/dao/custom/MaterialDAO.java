package lk.ijse.spicesystem.dao.custom;

import lk.ijse.spicesystem.dao.CrudDAO;
import lk.ijse.spicesystem.to.Material;

import java.sql.SQLException;

public interface MaterialDAO extends CrudDAO<Material> {
    public boolean materialTable(int amount, String material) throws SQLException, ClassNotFoundException;
}
