package ParkingLot.src.models;

public class Gate extends BaseModel{
    private int gateNumber;
    private ParkingFloor floor;
    private GateType gateType;
    private Operator operator;
    private GateStatus gateStatus;

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }
    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }
    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }
    public void setOperator(Operator operator) {
        this.operator = operator;
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
