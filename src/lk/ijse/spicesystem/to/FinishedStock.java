package lk.ijse.spicesystem.to;

public class FinishedStock {
    private String finishedStockId;
    private String barcodeNo;
    private int amount;
    private String productionStockId;
    private int qtyOnHand;

    public FinishedStock(String finishedStockId, String barcodeNo, int amount, String productionStockId, int qtyOnHand) {
        this.finishedStockId = finishedStockId;
        this.barcodeNo = barcodeNo;
        this.amount = amount;
        this.productionStockId = productionStockId;
        this.qtyOnHand = qtyOnHand;
    }

    public String getFinishedStockId() {
        return finishedStockId;
    }

    public void setFinishedStockId(String finishedStockId) {
        this.finishedStockId = finishedStockId;
    }

    public String getBarcodeNo() {
        return barcodeNo;
    }

    public void setBarcodeNo(String barcodeNo) {
        this.barcodeNo = barcodeNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProductionStockId() {
        return productionStockId;
    }

    public void setProductionStockId(String productionStockId) {
        this.productionStockId = productionStockId;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }
}
