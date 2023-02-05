package lk.ijse.spicesystem.to;

import java.sql.Date;

public class RawStock {
    private String batchId;
    private String materialId;
    private int amount;
    private String SupplierId;

    private Date date;

    public RawStock(String batchId, String materialId, int amount, String supplierId, Date date) {
        this.batchId = batchId;
        this.materialId = materialId;
        this.amount = amount;
        SupplierId = supplierId;
        this.date = date;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String supplierId) {
        SupplierId = supplierId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
