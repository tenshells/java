package ParkingLot.src.models;

import java.time.LocalTime;

import ParkingLot.src.strategies.interfaces.FeeCalculationStrategy;

public class Bill extends BaseModel{
    private Ticket ticket;
    private LocalTime exitTime;
    private int amount;
    private Gate exitGate;
    private Operator billOperator;
    private FeeCalculationStrategy feeCalcStrat;
    private Payment payment;

    public int getAmount() {
        return amount;
    }
    public Operator getBillOperator() {
        return billOperator;
    }
    public Gate getExitGate() {
        return exitGate;
    }
    public LocalTime getExitTime() {
        return exitTime;
    }
    public FeeCalculationStrategy getFeeCalcStrat() {
        return feeCalcStrat;
    }
    public Payment getPayment() {
        return payment;
    }
    public Ticket getTicket() {
        return ticket;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setBillOperator(Operator billOperator) {
        this.billOperator = billOperator;
    }
    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }
    public void setExitTime(LocalTime exitTime) {
        this.exitTime = exitTime;
    }
    public void setFeeCalcStrat(FeeCalculationStrategy feeCalcStrat) {
        this.feeCalcStrat = feeCalcStrat;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
