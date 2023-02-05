package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudUtil;
import lk.ijse.spicesystem.dao.custom.FinishedStockDAO;
import lk.ijse.spicesystem.to.FinishedStock;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FinishedStockDAOImpl implements FinishedStockDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
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

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(FinishedStock finishedStock) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public FinishedStock search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(FinishedStock finishedStock) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
