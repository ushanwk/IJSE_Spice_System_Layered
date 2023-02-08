package lk.ijse.spicesystem.modelBefore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.entity.Order;
import lk.ijse.spicesystem.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceOrderModel {

    public static ObservableList getShopId() throws SQLException, ClassNotFoundException {

        String sql = "SELECT ShopID FROM shop";

        ResultSet result = CrudUtil.execute(sql);

        ObservableList list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("ShopID"));
        }

        return list;

    }

    public static String getShopName(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT ShopName FROM Shop WHERE ShopID = ?";

        ResultSet result = CrudUtil.execute(sql, id);

        if(result.next()){
            return result.getString("ShopName");
        }

        return null;

    }

    public static ObservableList getItem() throws SQLException, ClassNotFoundException {

        String sql = "SELECT ProductionItem FROM production";

        ResultSet result = CrudUtil.execute(sql);

        ObservableList list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("ProductionItem"));
        }

        return list;

    }

    public static ObservableList getFinishedItem(String productionItem) throws SQLException, ClassNotFoundException {

        String sql = "SELECT FinishedItem FROM finisheditem WHERE Production = ?";

        ResultSet result = CrudUtil.execute(sql, productionItem);

        ObservableList list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("FinishedItem"));
        }

        return list;

    }

    public static String getQtyOnHand(String finishedItem) throws SQLException, ClassNotFoundException {

        String sql = "SELECT AmountInStock FROM finisheditem WHERE FinishedItem = ?";

        ResultSet result = CrudUtil.execute(sql, finishedItem);

        if(result.next()){
            return result.getString("AmountInStock");
        }

        return null;
    }

    public static String nextOrderId() throws SQLException, ClassNotFoundException {

        String sql = "SELECT OrderID FROM oerder ORDER BY OrderID DESC LIMIT 1";

        ResultSet result = CrudUtil.execute(sql);

        String latestId = null;

        if(result.next()){
            latestId = result.getString("OrderID");
        }

        String[] SUs = latestId.split("ORD");

        for (String a:SUs) {
            latestId = a;
        }

        int idNum = Integer.parseInt(latestId);

        latestId = "ORD" + (idNum+1);

        return latestId;

    }

    public static ObservableList paymentmethod() throws SQLException, ClassNotFoundException {

        String sql = "SELECT PaymentMethod FROM paymentmethod";

        ObservableList list = FXCollections.observableArrayList();

        ResultSet result = CrudUtil.execute(sql);

        while(result.next()){
            list.add(result.getString("PaymentMethod"));
        }

        return list;

    }

    public static boolean updateFinishedItem(String item, int amount) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE finisheditem SET AmountInStock = AmountInStock - ? WHERE FinishedItem = ?";

        return CrudUtil.execute(sql, amount, item);

    }

    public static boolean updateOrder(Order order) throws SQLException, ClassNotFoundException {

        String  sql = "INSERT INTO oerder VALUES (?, ?, ?, ?, ?)";

        return CrudUtil.execute(sql, order.getOrderID(), order.getShopID(), order.getFinishedItem(), order.getAmount(), order.getPrice());

    }


    public static boolean updatePaymentMethod(String payament, Double price) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE paymentmethod SET Balance = Balance + ? WHERE PaymentMethod = ?";

        return CrudUtil.execute(sql, price, payament);

    }

    public static String getPaymentId(String Paymnt) throws SQLException, ClassNotFoundException {

        String sql = "SELECT PaymentMethodID FROM PaymentMethod WHERE PaymentMethod = ?";

        ResultSet result = CrudUtil.execute(sql, Paymnt);

        String id = null;

        if(result.next()){
            id = result.getString("PaymentMethodID");
        }

        return id;
    }

    public static boolean updateFinance(String payment, int Price) throws SQLException, ClassNotFoundException {

        String sql1 = "SELECT FinanceID FROM Finance ORDER BY FinanceID DESC LIMIT 1";

        ResultSet result = CrudUtil.execute(sql1);

        String latestId = null;

        if(result.next()){
            latestId = result.getString("FinanceID");
        }

        String[] SUs = latestId.split("FI");

        for (String a:SUs) {
            latestId = a;
        }

        int idNum = Integer.parseInt(latestId);

        latestId = "FI" + (idNum+1);


        String sql = "INSERT INTO finance VALUES (?, ?, ?)";

        return CrudUtil.execute(sql, latestId, 1, getPaymentId(payment));

    }



}
