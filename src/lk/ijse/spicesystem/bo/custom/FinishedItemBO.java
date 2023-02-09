package lk.ijse.spicesystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.SuperBO;

import java.sql.SQLException;

public interface FinishedItemBO extends SuperBO {
    public ObservableList<String> getFinishedItem(String item) throws SQLException, ClassNotFoundException;
    public String getBarcode(String finishedItem) throws SQLException, ClassNotFoundException;
    public boolean updateFinishedItemTable(String barcodeNo, int amount) throws SQLException, ClassNotFoundException;
    public String getQtyOnHand(String finishedItem) throws SQLException, ClassNotFoundException;
    public boolean updateFinishedItem(String item, int amount) throws SQLException, ClassNotFoundException;
}
