package ParkingLotBeta.src.models;

import java.sql.Time;

import ParkingLotBeta.src.strategy.FeeCalculationStrategy;

public class Invoice {
    private int id;
    private Token token;
    private Time exitTime;
    private int amount;
    private Gate exitGate;
    private Operator operator;
    private FeeCalculationStrategy feeCalculationStrategy; 
    private Payment payment;

    public int getAmount() {
        return amount;
    }
    public Gate getExitGate() {
        return exitGate;
    }
    public Time getExitTime() {
        return exitTime;
    }
    public FeeCalculationStrategy getFeeCalculationStrategy() {
        return feeCalculationStrategy;
    }
    public int getId() {
        return id;
    }
    public Operator getOperator() {
        return operator;
    }
    public Payment getPayment() {
        return payment;
    }
    public Token getToken() {
        return token;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }
    public void setExitTime(Time exitTime) {
        this.exitTime = exitTime;
    }
    public void setFeeCalculationStrategy(FeeCalculationStrategy feeCalculationStrategy) {
        this.feeCalculationStrategy = feeCalculationStrategy;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setOperator(Operator operator) {
        this.operator = operator;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    public void setToken(Token token) {
        this.token = token;
    }
}
