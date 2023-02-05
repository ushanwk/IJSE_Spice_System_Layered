package lk.ijse.spicesystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryRecomendationModel {

    public static ObservableList getEmployeeId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT EmpID FROM employee";

        ObservableList list = FXCollections.observableArrayList();

        ResultSet result = CrudUtil.execute(sql);

        while(result.next()){
            list.add(result.getString("EmpID"));
        }

        return list;
    }

    public static String getEmployeeName(String empId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT FirstName FROM employee WHERE EmpID = ?";

        String name = null;

        ResultSet result = CrudUtil.execute(sql, empId);

        if(result.next()){
            name = result.getString("FirstName");
        }

        return name;
    }

    public static double getEmployeeSalary(String empId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT SalaryPerDay FROM employee WHERE EmpID = ?";

        double salary = 0;

        ResultSet result = CrudUtil.execute(sql, empId);

        if(result.next()){
            salary = Double.valueOf(result.getString("SalaryPerDay"));
        }

        return salary;
    }

    public static ObservableList getPaymentMethods() throws SQLException, ClassNotFoundException {
        String sql = "SELECT PaymentMethod FROM paymentMethod";

        ResultSet result = CrudUtil.execute(sql);

        ObservableList list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("PaymentMethod"));
        }

        return list;
    }

    public static boolean updatePaymentMethod(String payment, double price) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE paymentMethod SET Balance = Balance - ? WHERE PaymentMethod = ?";

        return CrudUtil.execute(sql, price, payment);
    }

}
