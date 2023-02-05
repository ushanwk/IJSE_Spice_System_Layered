package lk.ijse.spicesystem.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.custom.EmployeeBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.EmployeeDAO;
import lk.ijse.spicesystem.model.Employee;

import java.sql.SQLException;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);


    @Override
    public String nextEmployeeId() throws SQLException, ClassNotFoundException {
        return employeeDAO.nextId();
    }

    @Override
    public ObservableList getAllId() throws SQLException, ClassNotFoundException {
        return employeeDAO.getAllId();
    }

    @Override
    public boolean add(Employee employee) throws SQLException, ClassNotFoundException {
        return employeeDAO.add(employee);
    }

    @Override
    public Employee search(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.search(id);
    }

    @Override
    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(employee);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }

    @Override
    public String getEmployeeName(String empId) throws SQLException, ClassNotFoundException {
        return employeeDAO.getEmployeeName(empId);
    }

    @Override
    public double getEmployeeSalary(String empId) throws SQLException, ClassNotFoundException {
        return employeeDAO.getEmployeeSalary(empId);
    }


}
