package lk.ijse.spicesystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.to.FinishedStock;
import lk.ijse.spicesystem.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FinishedStockModel {

    public static String nextFinishedStockId() throws SQLException, ClassNotFoundException {

        String sql = "SELECT FinishedStockID FROM finishedStock ORDER BY FinishedStockID DESC LIMIT 1";

        ResultSet result = CrudUtil.execute(sql);

        String latestId = null;

        if(result.next()){
            latestId = result.getString("FinishedStockID");
        }

        String[] SUs = latestId.split("FS");

        for (String a:SUs) {
            latestId = a;
        }

        int idNum = Integer.parseInt(latestId);

        latestId = "FS" + (idNum+1);

        return latestId;

    }


    public static ObservableList getProductionItem() throws SQLException, ClassNotFoundException {

        String sql = "SELECT ProductionItem FROM production";

        ResultSet result = CrudUtil.execute(sql);

        ObservableList list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("ProductionItem"));
        }

        return list;

    }

    public static String getProductionId(String item) throws SQLException, ClassNotFoundException {

        String sql = "SELECT ProductionID FROM production WHERE ProductionItem = ?";

        ResultSet result = CrudUtil.execute(sql, item);

        String id = null;

        if(result.next()){
            id = result.getString("ProductionID");
        }

        return id;
    }


    public static ObservableList getProductionStockId(String productionId) throws SQLException, ClassNotFoundException {

        String sql = "SELECT ProductionStockID FROM productionStock WHERE ProductionID = ?";

        ResultSet result = CrudUtil.execute(sql, productionId);

        ObservableList list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("ProductionStockID"));
        }

        return list;

    }


    public static int getQtyOnHand(String productionStockId) throws SQLException, ClassNotFoundException {

        String sql = "SELECT QtyOnHand FROM productionStock WHERE ProductionStockID = ?";

        ResultSet result = CrudUtil.execute(sql, productionStockId);

        if(result.next()){
            return (Integer.valueOf(result.getString("QtyOnHand")));
        }

        return 0;

    }


    public static ObservableList getFinishedItem(String item) throws SQLException, ClassNotFoundException {

        String sql = "SELECT FinishedItem FROM finisheditem WHERE Production = ?";

        ResultSet result = CrudUtil.execute(sql, item);

        ObservableList list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("FinishedItem"));
        }

        return list;

    }


    public static String getBarcode(String finishedItem) throws SQLException, ClassNotFoundException {

        String sql = "SELECT BarcodeNO FROM finisheditem WHERE FinishedItem = ?";

        ResultSet resultSet = CrudUtil.execute(sql, finishedItem);

        if(resultSet.next()){
            return resultSet.getString("BarcodeNO");
        }

        return null;
    }

    public static boolean updateProductionTable(String productionId, int amount) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE production SET AmountInStock = AmountInStock - ? WHERE ProductionID = ?";

        return CrudUtil.execute(sql, amount, productionId);

    }

    public static boolean updateProductionStockTable(String productionStockId, int amount) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE productionStock SET QtyOnHand = QtyOnHand - ? WHERE ProductionStockID = ?";

        return CrudUtil.execute(sql, amount, productionStockId);

    }

    public static boolean updateFinishedItemTable(String barcodeNo, int amount) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE finishedItem SET AmountInStock = AmountInStock + ? WHERE BarcodeNO = ?";

        return CrudUtil.execute(sql, amount, barcodeNo);

    }

    public static boolean updateFinishedStock(FinishedStock finishedStock) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO finishedStock VALUES (?, ?, ?, ?, ?)";

        return CrudUtil.execute(sql, finishedStock.getFinishedStockId(), finishedStock.getBarcodeNo(), finishedStock.getAmount(), finishedStock.getProductionStockId(), finishedStock.getQtyOnHand());

    }

}
