package lk.ijse.spicesystem.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.custom.SupplierBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.SupplierDAO;
import lk.ijse.spicesystem.model.Supplier;

import java.sql.SQLException;

public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return supplierDAO.nextId();
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return supplierDAO.getAllId();
    }

    @Override
    public boolean add(Supplier supplier) throws SQLException, ClassNotFoundException {
        return supplierDAO.add(supplier);
    }

    @Override
    public Supplier search(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.search(id);
    }

    @Override
    public boolean update(Supplier supplier) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(supplier);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(id);
    }
}
