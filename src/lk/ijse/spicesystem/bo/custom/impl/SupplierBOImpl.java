package lk.ijse.spicesystem.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.custom.SupplierBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.ShopDAO;
import lk.ijse.spicesystem.dao.custom.SupplierDAO;
import lk.ijse.spicesystem.dto.SupplierDTO;
import lk.ijse.spicesystem.entity.Supplier;

import java.sql.SQLException;

public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    ShopDAO shopDAO = (ShopDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SHOP);

    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return supplierDAO.nextId();
    }

    @Override
    public ObservableList<String> getAllId() throws SQLException, ClassNotFoundException {
        return supplierDAO.getAllId();
    }

    @Override
    public boolean add(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        Supplier supplier = new Supplier(supplierDTO.getSupId(), supplierDTO.getSupplierName(), supplierDTO.getAddress(), supplierDTO.getEmail(), supplierDTO.getTelephone());
        return supplierDAO.add(supplier);
    }

    @Override
    public Supplier search(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.search(id);
    }

    @Override
    public boolean update(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        Supplier supplier = new Supplier(supplierDTO.getSupId(), supplierDTO.getSupplierName(), supplierDTO.getAddress(), supplierDTO.getEmail(), supplierDTO.getTelephone());
        return supplierDAO.update(supplier);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(id);
    }

    public String nextShopId() throws SQLException, ClassNotFoundException {
        return shopDAO.nextId();
    }
}
