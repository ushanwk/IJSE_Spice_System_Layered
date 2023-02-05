package lk.ijse.spicesystem.to;

public class Shop {
    private String shopId;
    private String shopName;
    private String address;
    private String email;
    private int shopTelephone;
    private String ownerName;
    private String ownerNic;
    private int ownerTelephone;

    public Shop(String shopId, String shopName, String address, String email, int shopTelephone, String ownerName, String ownerNic, int ownerTelephone) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.address = address;
        this.email = email;
        this.shopTelephone = shopTelephone;
        this.ownerName = ownerName;
        this.ownerNic = ownerNic;
        this.ownerTelephone = ownerTelephone;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getShopTelephone() {
        return shopTelephone;
    }

    public void setShopTelephone(int shopTelephone) {
        this.shopTelephone = shopTelephone;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerNic() {
        return ownerNic;
    }

    public void setOwnerNic(String ownerNic) {
        this.ownerNic = ownerNic;
    }

    public int getOwnerTelephone() {
        return ownerTelephone;
    }

    public void setOwnerTelephone(int ownerTelephone) {
        this.ownerTelephone = ownerTelephone;
    }
}
