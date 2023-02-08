package lk.ijse.spicesystem.dto;

public class MaterialDTO {
    private String materialId;
    private String material;
    private int amountInStock;

    public MaterialDTO(String materialId, String material, int amountInStock) {
        this.materialId = materialId;
        this.material = material;
        this.amountInStock = amountInStock;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }
}
