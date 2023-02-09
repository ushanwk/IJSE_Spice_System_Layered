package lk.ijse.spicesystem.bo.custom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.dto.FinishedStockDTO;
import lk.ijse.spicesystem.entity.FinishedStock;

import java.sql.SQLException;

public interface FinishedStockBO extends SuperBO {
    public String nextId() throws SQLException, ClassNotFoundException;

    public boolean update(FinishedStockDTO finishedStockDTO) throws SQLException, ClassNotFoundException;

    public ObservableList<String> getProductionItem() throws SQLException, ClassNotFoundException;

    public boolean updateProductionTable(String productionId, int amount) throws SQLException, ClassNotFoundException;

    public String getProductionId(String item) throws SQLException, ClassNotFoundException;

    public ObservableList getProductionStockId(String productionId) throws SQLException, ClassNotFoundException;

    public boolean updateProductionStockTable(String productionStockId, int amount) throws SQLException, ClassNotFoundException;

    public String getQtyOnHand(String finishedItem) throws SQLException, ClassNotFoundException;

    public ObservableList<String> getFinishedItem(String item) throws SQLException, ClassNotFoundException;

    public String getBarcode(String finishedItem) throws SQLException, ClassNotFoundException;

    public boolean updateFinishedItemTable(String barcodeNo, int amount) throws SQLException, ClassNotFoundException;

}
