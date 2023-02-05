package lk.ijse.spicesystem.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.dao.CrudUtil;
import lk.ijse.spicesystem.dao.custom.EmployeeDAO;
import lk.ijse.spicesystem.to.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT EmpID FROM Employee ORDER BY EmpID DESC LIMIT 1";

        ResultSet result = CrudUtil.execute(sql);

        String latestId = null;

        if(result.next()){
            latestId = result.getString("EmpID");
        }

        String[] SUs = latestId.split("EMP");

        for (String a:SUs) {
            latestId = a;
        }

        int idNum = Integer.parseInt(latestId);

        latestId = "EMP" + (idNum+1);

        return latestId;
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT EmpID FROM Employee";
        ResultSet result = CrudUtil.execute(sql);

        ObservableList<String> list = FXCollections.observableArrayList();

        while(result.next()){
            list.add(result.getString("EmpID"));
        }

        return list;
    }

    @Override
    public boolean add(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Employee VALUES (?, ?, ?, ?, ?, ?, ?)";

        return CrudUtil.execute(sql, employee.getEmpId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getSalaryPerDay(),
                employee.getAddress(), employee.getJobRole());
    }

    @Override
    public Employee search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Employee WHERE EmpID = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if(result.next()){
            return new Employee(
                    result.getString("EmpID"),
                    result.getString("FirstName"),
                    result.getString("LastName"),
                    result.getString("Email"),
                    Double.valueOf(result.getString("SalaryPerDay")),
                    result.getString("Address"),
                    result.getString("JobRole")
            );

        }

        return null;
    }

    @Override
    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Employee SET FirstName = ?, LastName = ?, Email = ?, SalaryPerDay = ?, Address = ?, JobRole = ? WHERE EmpID = ?";

        return CrudUtil.execute(sql, employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getSalaryPerDay(), employee.getAddress(), employee.getJobRole(), employee.getEmpId());

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Employee WHERE EmpID = ?";

        return CrudUtil.execute(sql, id);
    }
}
