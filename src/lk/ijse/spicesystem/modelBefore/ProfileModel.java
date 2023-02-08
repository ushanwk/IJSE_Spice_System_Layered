package lk.ijse.spicesystem.modelBefore;

import lk.ijse.spicesystem.entity.User;
import lk.ijse.spicesystem.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileModel {

    public static User getUserInfo(String id) throws SQLException, ClassNotFoundException {

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

    public static boolean updateUserTable(User user) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO User VALUES (?, ?, ?, ?, ?, ?, ?)";

        return CrudUtil.execute(sql, user.getUserName(), user.getfName(), user.getlName(), user.getEmail(), user.getTelephone(), user.getAddress(), user.getJobRole());

    }

}
