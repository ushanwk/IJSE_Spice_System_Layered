package lk.ijse.spicesystem.to;

public class Supplier {
    private String supId;
    private String supplierName;
    private String Address;
    private String Email;
    private int telephone;

    public Supplier(String supId, String supplierName, String address, String email, int telephone) {
        this.supId = supId;
        this.supplierName = supplierName;
        Address = address;
        Email = email;
        this.telephone = telephone;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}
