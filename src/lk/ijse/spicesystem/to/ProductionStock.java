package lk.ijse.spicesystem.to;

public class ProductionStock {
    private String productionStockID;
    private int amount;
    private String batchID;
    private String productionID;

    public ProductionStock(String productionStockID, int amount, String batchID, String productionID) {
        this.productionStockID = productionStockID;
        this.amount = amount;
        this.batchID = batchID;
        this.productionID = productionID;
    }

    public String getProductionStockID() {
        return productionStockID;
    }

    public void setProductionStockID(String productionStockID) {
        this.productionStockID = productionStockID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getBatchID() {
        return batchID;
    }

    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    public String getProductionID() {
        return productionID;
    }

    public void setProductionID(String productionID) {
        this.productionID = productionID;
    }
}
