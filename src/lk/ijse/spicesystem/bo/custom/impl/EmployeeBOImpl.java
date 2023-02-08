package lk.ijse.spicesystem.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.custom.EmployeeBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.EmployeeDAO;
import lk.ijse.spicesystem.dto.EmployeeDTO;
import lk.ijse.spicesystem.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);


    @Override
    public String nextEmployeeId() throws SQLException, ClassNotFoundException {
        return employeeDAO.nextId();
    }

    @Override
    public ObservableList<String> getAllId() throws SQLException, ClassNotFoundException {
        return employeeDAO.getAllId();
    }

    @Override
    public boolean add(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        Employee employee = new Employee(employeeDTO.getEmpId(), employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getEmail(), employeeDTO.getSalaryPerDay(), employeeDTO.getAddress(), employeeDTO.getJobRole());
        return employeeDAO.add(employee);
    }

    @Override
    public Employee search(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.search(id);
    }

    @Override
    public boolean update(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        Employee employee = new Employee(employeeDTO.getEmpId(), employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getEmail(), employeeDTO.getSalaryPerDay(), employeeDTO.getAddress(), employeeDTO.getJobRole());
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
