package lk.ijse.spicesystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.dto.SupplierDTO;
import lk.ijse.spicesystem.entity.Supplier;

import java.sql.SQLException;

public interface SupplierBO extends SuperBO {
    public String nextId() throws SQLException, ClassNotFoundException;
    public ObservableList<String> getAllId() throws SQLException, ClassNotFoundException;
    public boolean add(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException;
    public Supplier search(String id) throws SQLException, ClassNotFoundException;
    public boolean update(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public String nextShopId() throws SQLException, ClassNotFoundException;
}
