package ParkingLot.src.models;

import java.time.LocalTime;

public class Payment extends BaseModel{
    private int referenceId;
    private PaymentMode paymentMode;
    private LocalTime time;
    private int amount;
    private PaymentStatus paymentStatus;

    public int getAmount() {
        return amount;
    }
    public PaymentMode getPaymentMode() {
        return paymentMode;
    }
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public int getReferenceId() {
        return referenceId;
    }
    public LocalTime getTime() {
        return time;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
}
