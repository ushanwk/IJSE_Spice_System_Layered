package lk.ijse.spicesystem.bo.custom.impl;

import lk.ijse.spicesystem.bo.custom.UserBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.UserDAO;
import lk.ijse.spicesystem.model.User;

import java.sql.SQLException;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);


    @Override
    public boolean add(User user) throws SQLException, ClassNotFoundException {
        return userDAO.add(user);
    }

    @Override
    public User search(String id) throws SQLException, ClassNotFoundException {
        return userDAO.search(id);
    }
}
