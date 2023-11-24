package ParkingLot.src.models;

import java.sql.Time;

public class Payment {
    private int id;
    private int referenceId;
    private PaymentMode paymentMode;
    private Time paymentTime;
    private int amount;
    private PaymentStatus paymentStatus;

    public int getAmount() {
        return amount;
    }
    public int getId() {
        return id;
    }
    public PaymentMode getPaymentMode() {
        return paymentMode;
    }
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public Time getPaymentTime() {
        return paymentTime;
    }
    public int getReferenceId() {
        return referenceId;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public void setPaymentTime(Time paymentTime) {
        this.paymentTime = paymentTime;
    }
    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }
}
