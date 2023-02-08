package lk.ijse.spicesystem.modelBefore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.entity.RawStock;
import lk.ijse.spicesystem.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RawStockModel {

    public static String nextBatchID(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT BatchID FROM RawStock WHERE MaterialID = ? ORDER BY BatchID DESC LIMIT 1;";

        ResultSet result = CrudUtil.execute(sql, id);

        String latestId = null;

        if(result.next()){
            latestId = result.getString("BatchID");
        }

        String[] Ids = latestId.split(id);

        for (String a:Ids) {
            latestId = a;
        }

        int idNum = Integer.parseInt(latestId);

        latestId = id + (idNum+1);

        return latestId;

    }

    public static ObservableList getAllMaterials() throws SQLException, ClassNotFoundException {
        String sql = "SELECT Material FROM Material";
        ResultSet result = CrudUtil.execute(sql);

        ObservableList<String> list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("Material"));
        }

        return list;
    }

    public static boolean updateRawStock(RawStock rawStock) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO RawStock VALUES (?, ?, ?, ?, ?, ?)";

        return CrudUtil.execute(sql, rawStock.getBatchId(), rawStock.getMaterialId(), rawStock.getAmount(), rawStock.getSupplierId(), rawStock.getDate(), rawStock.getAmount());

    }

    public static boolean updateMaterial(int amount, String id) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE Material SET AmountInStock = AmountInStock + ? WHERE MaterialID = ?";

        return CrudUtil.execute(sql, amount, id);

    }


    public static boolean updatePaymentMethod(int cost, String paymentMethod) throws SQLException, ClassNotFoundException {

        String sql= "UPDATE paymentMethod SET Balance = Balance - ? WHERE PaymentMethod = ?";

        return CrudUtil.execute(sql, cost, paymentMethod);

    }

    public static ObservableList getAllPaymentmethods() throws SQLException, ClassNotFoundException {

        String sql = "SELECT PaymentMethod FROM PaymentMethod";

        ResultSet result = CrudUtil.execute(sql);

        ObservableList list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("PaymentMethod"));
        }

        return list;

    }

    public static boolean updateFinance(String PaymentMethodID, int Price) throws SQLException, ClassNotFoundException {

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

        return CrudUtil.execute(sql, latestId, 0, PaymentMethodID);

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

}
