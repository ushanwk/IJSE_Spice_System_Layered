package lk.ijse.spicesystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.dto.RawStockDTO;
import lk.ijse.spicesystem.entity.RawStock;
import lk.ijse.spicesystem.entity.Supplier;

import java.sql.SQLException;

public interface RawStockBO extends SuperBO {
    public boolean add(RawStockDTO rawStockDTO) throws SQLException, ClassNotFoundException;
    public ObservableList<String> getBatchID(String materialId) throws SQLException, ClassNotFoundException;
    public int getQtyOnHandBatchId(String batchId) throws SQLException, ClassNotFoundException;
    public boolean RawStockTable(int amount, String batchId) throws SQLException, ClassNotFoundException;
    public String nextBatchID(String id) throws SQLException, ClassNotFoundException;
    public ObservableList<String> getAllMaterials() throws SQLException, ClassNotFoundException;
    public boolean updateMaterial(int amount, String id) throws SQLException, ClassNotFoundException;
    public ObservableList<String> paymentmethod() throws SQLException, ClassNotFoundException;
    public boolean updatePaymentMethodMinus(int cost, String paymentMethod) throws SQLException, ClassNotFoundException;
    public String getPaymentId(String Paymnt) throws SQLException, ClassNotFoundException;
    public boolean updateFinance(String payment, int Price) throws SQLException, ClassNotFoundException;
    public ObservableList<String> getAllId() throws SQLException, ClassNotFoundException;
    public Supplier search(String id) throws SQLException, ClassNotFoundException;
}
