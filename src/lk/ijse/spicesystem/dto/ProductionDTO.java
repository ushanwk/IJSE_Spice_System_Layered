package lk.ijse.spicesystem.dto;

public class ProductionDTO {
    private String productionId;
    private String productionItem;
    private int amountInStock;
    private String materialId;

    public ProductionDTO(String productionId, String productionItem, int amountInStock, String materialId) {
        this.productionId = productionId;
        this.productionItem = productionItem;
        this.amountInStock = amountInStock;
        this.materialId = materialId;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public String getProductionItem() {
        return productionItem;
    }

    public void setProductionItem(String productionItem) {
        this.productionItem = productionItem;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }
}
