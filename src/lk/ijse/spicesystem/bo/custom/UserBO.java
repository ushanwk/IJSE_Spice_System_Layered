package lk.ijse.spicesystem.bo.custom;

import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.model.User;

import java.sql.SQLException;

public interface UserBO extends SuperBO {
    public boolean add(User user) throws SQLException, ClassNotFoundException;
    public User search(String id) throws SQLException, ClassNotFoundException;
}
