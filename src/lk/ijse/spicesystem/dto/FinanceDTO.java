package lk.ijse.spicesystem.dto;

public class FinanceDTO {
    private String financeId;
    private boolean incomeOrCost;
    private String paymentMethodId;

    public FinanceDTO(String financeId, boolean incomeOrCost, String paymentMethodId) {
        this.financeId = financeId;
        this.incomeOrCost = incomeOrCost;
        this.paymentMethodId = paymentMethodId;
    }

    public String getFinanceId() {
        return financeId;
    }

    public void setFinanceId(String financeId) {
        this.financeId = financeId;
    }

    public boolean isIncomeOrCost() {
        return incomeOrCost;
    }

    public void setIncomeOrCost(boolean incomeOrCost) {
        this.incomeOrCost = incomeOrCost;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
}
