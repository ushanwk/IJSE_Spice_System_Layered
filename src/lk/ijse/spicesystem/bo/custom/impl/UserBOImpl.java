package lk.ijse.spicesystem.bo.custom.impl;

import lk.ijse.spicesystem.bo.custom.UserBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.UserDAO;
import lk.ijse.spicesystem.dto.UserDTO;
import lk.ijse.spicesystem.entity.User;

import java.sql.SQLException;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);


    @Override
    public boolean add(UserDTO userDTO) throws SQLException, ClassNotFoundException {
        User user = new User(userDTO.getUserName(), userDTO.getfName(), userDTO.getlName(), userDTO.getEmail(), userDTO.getTelephone(), userDTO.getAddress(), userDTO.getJobRole());
        return userDAO.add(user);
    }

    @Override
    public UserDTO search(String id) throws SQLException, ClassNotFoundException {
        User user = userDAO.search(id);
        return new UserDTO(user.getUserName(), user.getfName(), user.getlName(), user.getEmail(), user.getTelephone(), user.getAddress(), user.getJobRole());
    }
}
