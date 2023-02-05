package lk.ijse.spicesystem.to;

public class Employee {
    private String EmpId;
    private String firstName;
    private String lastName;
    private String email;
    private double salaryPerDay;
    private String address;
    private String jobRole;

    public Employee(String empId, String firstName, String lastName, String email, double salaryPerDay, String address, String jobRole) {
        EmpId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salaryPerDay = salaryPerDay;
        this.address = address;
        this.jobRole = jobRole;
    }

    public String getEmpId() {
        return EmpId;
    }

    public void setEmpId(String empId) {
        EmpId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalaryPerDay() {
        return salaryPerDay;
    }

    public void setSalaryPerDay(double salaryPerDay) {
        this.salaryPerDay = salaryPerDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }
}
