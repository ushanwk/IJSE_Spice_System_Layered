package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudUtil;
import lk.ijse.spicesystem.dao.custom.PaymentMethodDAO;
import lk.ijse.spicesystem.entity.PaymentMethod;

import java.sql.ResultSet;
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

    @Override
    public ObservableList paymentmethod() throws SQLException, ClassNotFoundException {
        String sql = "SELECT PaymentMethod FROM paymentmethod";

        ObservableList list = FXCollections.observableArrayList();

        ResultSet result = CrudUtil.execute(sql);

        while(result.next()){
            list.add(result.getString("PaymentMethod"));
        }

        return list;
    }

    @Override
    public boolean updatePaymentMethod(String payament, Double price) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE paymentmethod SET Balance = Balance + ? WHERE PaymentMethod = ?";

        return CrudUtil.execute(sql, price, payament);
    }

    @Override
    public String getPaymentId(String Paymnt) throws SQLException, ClassNotFoundException {
        String sql = "SELECT PaymentMethodID FROM PaymentMethod WHERE PaymentMethod = ?";

        ResultSet result = CrudUtil.execute(sql, Paymnt);

        String id = null;

        if(result.next()){
            id = result.getString("PaymentMethodID");
        }

        return id;
    }

    @Override
    public boolean updatePaymentMethodMinus(int cost, String paymentMethod) throws SQLException, ClassNotFoundException {
        String sql= "UPDATE paymentMethod SET Balance = Balance - ? WHERE PaymentMethod = ?";

        return CrudUtil.execute(sql, cost, paymentMethod);
    }
}
