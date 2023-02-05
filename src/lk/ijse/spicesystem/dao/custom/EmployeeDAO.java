package lk.ijse.spicesystem.dao.custom;

import lk.ijse.spicesystem.dao.CrudDAO;
import lk.ijse.spicesystem.to.Employee;

import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<Employee> {
    public String getEmployeeName(String empId) throws SQLException, ClassNotFoundException;
    public double getEmployeeSalary(String empId) throws SQLException, ClassNotFoundException;
}
