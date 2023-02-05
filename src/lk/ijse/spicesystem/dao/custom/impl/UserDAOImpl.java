package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudUtil;
import lk.ijse.spicesystem.dao.custom.UserDAO;
import lk.ijse.spicesystem.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(User user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO User VALUES (?, ?, ?, ?, ?, ?, ?)";

        return CrudUtil.execute(sql, user.getUserName(), user.getfName(), user.getlName(), user.getEmail(), user.getTelephone(), user.getAddress(), user.getJobRole());
    }

    @Override
    public User search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT Username, FirstName, LastName, Email, Telephone, Address, JobRole FROM User WHERE Username = ?";

        ResultSet result = CrudUtil.execute(sql, id);

        if(result.next()){
            return new User(
                    result.getString("Username"),
                    result.getString("FirstName"),
                    result.getString("LastName"),
                    result.getString("Email"),
                    result.getInt("Telephone"),
                    result.getString("Address"),
                    result.getString("JobRole")
            );
        }

        return null;
    }

    @Override
    public boolean update(User user) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
