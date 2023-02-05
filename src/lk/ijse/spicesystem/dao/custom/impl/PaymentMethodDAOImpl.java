package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.custom.PaymentMethodDAO;
import lk.ijse.spicesystem.to.PaymentMethod;

import java.sql.SQLException;

public class PaymentMethodDAOImpl implements PaymentMethodDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(PaymentMethod paymentMethod) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public PaymentMethod search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(PaymentMethod paymentMethod) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
