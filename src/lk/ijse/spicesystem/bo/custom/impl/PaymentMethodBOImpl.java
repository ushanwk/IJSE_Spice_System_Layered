package lk.ijse.spicesystem.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.custom.PaymentMethodBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.PaymentMethodDAO;

import java.sql.SQLException;

public class PaymentMethodBOImpl implements PaymentMethodBO {

    PaymentMethodDAO paymentMethodDAO = (PaymentMethodDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENTMETHOD);

    @Override
    public ObservableList paymentmethod() throws SQLException, ClassNotFoundException {
        return paymentMethodDAO.paymentmethod();
    }

    @Override
    public boolean updatePaymentMethod(String payament, Double price) throws SQLException, ClassNotFoundException {
        return paymentMethodDAO.updatePaymentMethod(payament, price);
    }

    @Override
    public String getPaymentId(String Paymnt) throws SQLException, ClassNotFoundException {
        return paymentMethodDAO.getPaymentId(Paymnt);
    }

    @Override
    public boolean updatePaymentMethodMinus(int cost, String paymentMethod) throws SQLException, ClassNotFoundException {
        return paymentMethodDAO.updatePaymentMethodMinus(cost, paymentMethod);
    }


}
