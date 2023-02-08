package lk.ijse.spicesystem.modelBefore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.entity.ProductionStock;
import lk.ijse.spicesystem.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductionStockModel {

    public static String nextProductionStockId() throws SQLException, ClassNotFoundException {

        String sql = "SELECT ProductionStockID FROM productionStock ORDER BY ProductionStockID DESC LIMIT 1";

        ResultSet result = CrudUtil.execute(sql);

        String latestId = null;

        if(result.next()){
            latestId = result.getString("ProductionStockID");
        }

        String[] SUs = latestId.split("PS");

        for (String a:SUs) {
            latestId = a;
        }

        int idNum = Integer.parseInt(latestId);

        latestId = "PS" + (idNum+1);

        return latestId;

    }

    public static ObservableList getBatchID(String materialId) throws SQLException, ClassNotFoundException {

        String sql = "SELECT BatchID FROM RawStock WHERE MaterialID = ?";

        ResultSet result = CrudUtil.execute(sql, materialId);

        ObservableList<String> list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("BatchID"));
        }

        return list;

    }

    public static int getQtyOnHandBatchId(String batchId) throws SQLException, ClassNotFoundException {

        String sql = "SELECT QtyOnHand FROM RawStock WHERE BatchID = ?";

        ResultSet result = CrudUtil.execute(sql, batchId);

        int qty = 0;

        if(result.next()){
            qty = result.getInt("QtyOnHand");
        }

        return qty;

    }

    public static ObservableList getProduction(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT ProductionItem From production WHERE MaterialID = ?";

        String mId = String.valueOf(id.charAt(0));

        ResultSet result = CrudUtil.execute(sql, mId);

        ObservableList<String> list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("ProductionItem"));
        }

        return list;

    }

    public static boolean productionStockTable(ProductionStock productionStock) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO ProductionStock VALUES (?, ?, ?, ?, ?)";

        return CrudUtil.execute(sql, productionStock.getProductionStockID(), productionStock.getAmount(), productionStock.getBatchID(), productionStock.getProductionID(), productionStock.getAmount());

    }

    public static boolean productionTale(int amount, String productionItem) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE production SET AmountInStock = AmountInStock + ? WHERE ProductionItem = ?";

        return CrudUtil.execute(sql, amount, productionItem);

    }

    public static boolean RawStockTable(int amount, String batchId) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE RawStock SET QtyOnHand = QtyOnHand - ? WHERE BatchID = ?";

        return CrudUtil.execute(sql, amount, batchId);

    }

    public static boolean materialTable(int amount, String material) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE material SET AmountInStock = AmountInStock - ? WHERE Material = ?";

        return CrudUtil.execute(sql, amount, material);

    }

}
