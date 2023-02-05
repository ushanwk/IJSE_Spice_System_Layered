package lk.ijse.spicesystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.model.Supplier;

import java.sql.SQLException;

public interface SupplierBO extends SuperBO {
    public String nextId() throws SQLException, ClassNotFoundException;
    public ObservableList getAllId() throws SQLException, ClassNotFoundException;
    public boolean add(Supplier supplier) throws SQLException, ClassNotFoundException;
    public Supplier search(String id) throws SQLException, ClassNotFoundException;
    public boolean update(Supplier supplier) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
}
