package lk.ijse.spicesystem.to;

public class User {
    private String userName;
    private String fName;
    private String lName;
    private String email;
    private int telephone;
    private String address;
    private String jobRole;

    public User(String userName, String fName, String lName, String email, int telephone, String address, String jobRole) {
        this.userName = userName;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.jobRole = jobRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
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
