package lk.ijse.spicesystem.dao;

import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface CrudDAO<T> extends SuperDAO{
    public String nextId() throws SQLException, ClassNotFoundException;
    public ObservableList getAllId() throws SQLException, ClassNotFoundException;
    public boolean add(T t) throws SQLException, ClassNotFoundException;
    public T search(String id) throws SQLException, ClassNotFoundException;
    public boolean update(T t) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
}
