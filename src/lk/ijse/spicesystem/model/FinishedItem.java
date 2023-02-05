package lk.ijse.spicesystem.model;

public class FinishedItem {
    private String barcodeNo;
    private String finishedItem;
    private int amountInStock;
    private int weightByPacket;
    private String production;

    public FinishedItem(String barcodeNo, String finishedItem, int amountInStock, int weightByPacket, String production) {
        this.barcodeNo = barcodeNo;
        this.finishedItem = finishedItem;
        this.amountInStock = amountInStock;
        this.weightByPacket = weightByPacket;
        this.production = production;
    }

    public String getBarcodeNo() {
        return barcodeNo;
    }

    public void setBarcodeNo(String barcodeNo) {
        this.barcodeNo = barcodeNo;
    }

    public String getFinishedItem() {
        return finishedItem;
    }

    public void setFinishedItem(String finishedItem) {
        this.finishedItem = finishedItem;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    public int getWeightByPacket() {
        return weightByPacket;
    }

    public void setWeightByPacket(int weightByPacket) {
        this.weightByPacket = weightByPacket;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }
}
