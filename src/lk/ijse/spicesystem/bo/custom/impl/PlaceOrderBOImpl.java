package lk.ijse.spicesystem.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.custom.PlaceOrderBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.*;
import lk.ijse.spicesystem.dto.OrderDTO;
import lk.ijse.spicesystem.entity.Order;

import java.sql.SQLException;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    PlaceOrderDAO placeOrderDAO = (PlaceOrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PLACEORDER);
    FinishedItemDAO finishedItemDAO = (FinishedItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.FINISHEDITEM);
    FinanceDAO financeDAO = (FinanceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.FINANCE);
    PaymentMethodDAO paymentMethodDAO = (PaymentMethodDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENTMETHOD);
    ShopDAO shopDAO = (ShopDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SHOP);
    ProductionDAO productionDAO = (ProductionDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCTION);

    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return placeOrderDAO.nextId();
    }

    @Override
    public boolean add(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        Order order = new Order(orderDTO.getOrderID(), orderDTO.getShopID(), orderDTO.getFinishedItem(), orderDTO.getAmount(), orderDTO.getPrice());
        return placeOrderDAO.update(order);
    }

    public ObservableList<String> getFinishedItem(String item) throws SQLException, ClassNotFoundException {
        ObservableList<String> finishedItems = finishedItemDAO.getFinishedItem(item);
        ObservableList<String> finishedItemDTOS = FXCollections.observableArrayList();

        for (String f : finishedItems) {
            finishedItemDTOS.add(f);
        }

        return finishedItemDTOS;
    }

    public String getQtyOnHand(String finishedItem) throws SQLException, ClassNotFoundException {
        return finishedItemDAO.getQtyOnHand(finishedItem);
    }

    public boolean updateFinishedItem(String item, int amount) throws SQLException, ClassNotFoundException {
        return finishedItemDAO.updateFinishedItem(item, amount);
    }

    public boolean updateFinance(String payment, int Price) throws SQLException, ClassNotFoundException {
        return financeDAO.updateFinance(payment, Price);
    }

    public ObservableList<String> paymentmethod() throws SQLException, ClassNotFoundException {
        return paymentMethodDAO.paymentmethod();
    }

    public boolean updatePaymentMethod(String payament, Double price) throws SQLException, ClassNotFoundException {
        return paymentMethodDAO.updatePaymentMethod(payament, price);
    }

    public ObservableList<String> getAllId() throws SQLException, ClassNotFoundException {
        return shopDAO.getAllId();
    }

    public String getShopName(String id) throws SQLException, ClassNotFoundException {
        return shopDAO.getShopName(id);
    }

    public ObservableList<String> getProductionItem() throws SQLException, ClassNotFoundException {
        return productionDAO.getProductionItem();
    }
}
