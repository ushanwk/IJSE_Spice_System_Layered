package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudUtil;
import lk.ijse.spicesystem.dao.custom.FinanceDAO;
import lk.ijse.spicesystem.entity.Finance;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FinanceDAOImpl implements FinanceDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Finance finance) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Finance search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Finance finance) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateFinance(String payment, int Price) throws SQLException, ClassNotFoundException {

        String sql2 = "SELECT PaymentMethodID FROM PaymentMethod WHERE PaymentMethod = ?";

        ResultSet result = CrudUtil.execute(sql2, payment);

        String id = null;

        if(result.next()){
            id = result.getString("PaymentMethodID");
        }



        String sql1 = "SELECT FinanceID FROM Finance ORDER BY FinanceID DESC LIMIT 1";

        ResultSet result1 = CrudUtil.execute(sql1);

        String latestId = null;

        if(result1.next()){
            latestId = result.getString("FinanceID");
        }

        String[] SUs = latestId.split("FI");

        for (String a:SUs) {
            latestId = a;
        }

        int idNum = Integer.parseInt(latestId);

        latestId = "FI" + (idNum+1);


        String sql = "INSERT INTO finance VALUES (?, ?, ?)";

        return CrudUtil.execute(sql, latestId, 1, id);
    }
}
