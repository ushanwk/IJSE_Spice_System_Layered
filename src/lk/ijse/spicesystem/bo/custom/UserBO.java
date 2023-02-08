package lk.ijse.spicesystem.bo.custom;

import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.dto.UserDTO;
import lk.ijse.spicesystem.entity.User;

import java.sql.SQLException;

public interface UserBO extends SuperBO {
    public boolean add(UserDTO userDTO) throws SQLException, ClassNotFoundException;
    public UserDTO search(String id) throws SQLException, ClassNotFoundException;
}
