package lk.ijse.spicesystem.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.custom.MaterialBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.MaterialDAO;
import lk.ijse.spicesystem.dto.MaterialDTO;
import lk.ijse.spicesystem.entity.Material;

import java.sql.SQLException;

public class MaterialBOImpl implements MaterialBO {

    MaterialDAO materialDAO = (MaterialDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MATERIAL);

    @Override
    public boolean materialTable(int amount, String material) throws SQLException, ClassNotFoundException {
        return materialDAO.materialTable(amount, material);
    }

    @Override
    public ObservableList<String> getAllMaterials() throws SQLException, ClassNotFoundException {
        return materialDAO.getAllMaterials();
    }

    @Override
    public boolean updateMaterial(int amount, String id) throws SQLException, ClassNotFoundException {
        return materialDAO.updateMaterial(amount, id);
    }


}
