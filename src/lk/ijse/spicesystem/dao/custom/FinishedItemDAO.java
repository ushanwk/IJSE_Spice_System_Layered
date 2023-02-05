package lk.ijse.spicesystem.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudDAO;
import lk.ijse.spicesystem.to.FinishedItem;

import java.sql.SQLException;

public interface FinishedItemDAO extends CrudDAO<FinishedItem> {
    public ObservableList getFinishedItem(String item) throws SQLException, ClassNotFoundException;
    public String getBarcode(String finishedItem) throws SQLException, ClassNotFoundException;
    public boolean updateFinishedItemTable(String barcodeNo, int amount) throws SQLException, ClassNotFoundException;
    public String getQtyOnHand(String finishedItem) throws SQLException, ClassNotFoundException;
    public boolean updateFinishedItem(String item, int amount) throws SQLException, ClassNotFoundException;
}
