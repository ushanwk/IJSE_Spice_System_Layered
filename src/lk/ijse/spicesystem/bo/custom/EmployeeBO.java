package lk.ijse.spicesystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.SuperBO;
import lk.ijse.spicesystem.dto.EmployeeDTO;
import lk.ijse.spicesystem.entity.Employee;

import java.sql.SQLException;

public interface EmployeeBO extends SuperBO {
    public String nextEmployeeId() throws SQLException, ClassNotFoundException;
    public ObservableList<String> getAllId() throws SQLException, ClassNotFoundException;
    public boolean add(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
    public Employee search(String id) throws SQLException, ClassNotFoundException;
    public boolean update(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public String getEmployeeName(String empId) throws SQLException, ClassNotFoundException;
    public double getEmployeeSalary(String empId) throws SQLException, ClassNotFoundException;
}
