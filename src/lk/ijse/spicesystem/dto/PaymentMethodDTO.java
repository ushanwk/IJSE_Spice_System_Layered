package lk.ijse.spicesystem.dto;

public class PaymentMethodDTO {
    private String paymentMethodId;
    private String paymentMethod;
    private double balance;

    public PaymentMethodDTO(String paymentMethodId, String paymentMethod, double balance) {
        this.paymentMethodId = paymentMethodId;
        this.paymentMethod = paymentMethod;
        this.balance = balance;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
