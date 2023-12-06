package ParkingLot.src.models;

import java.time.LocalDateTime;

public class Gate extends BaseModel{
    private int gateNumber;
    private ParkingFloor floor;
    private GateType gateType;
    private Operator operator;
    private GateStatus gateStatus;
    private static int gateCount;

    public Gate(GateType gt){
        this.gateType=gt;
        this.setId(++gateCount);
        this.setCreatedOn(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setGateType(GateType gateType) {
        this.gateType = gateType;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setOperator(Operator operator) {
        this.operator = operator;
        this.setUpdatedAt(LocalDateTime.now());
    }
    
    public ParkingFloor getFloor() {
        return floor;
    }
    public int getGateNumber() {
        return gateNumber;
    }
    public GateStatus getGateStatus() {
        return gateStatus;
    }
    public GateType getGateType() {
        return gateType;
    }
    public Operator getOperator() {
        return operator;
    }
}
