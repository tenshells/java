package ParkingLotBeta.src.models;

public class Gate {
    private int id;
    private GateStatus gateStatus;
    private GateType gateType;
    private Operator operator;

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setOperator(Operator operator) {
        this.operator = operator;
    }
    public GateStatus getGateStatus() {
        return gateStatus;
    }
    public GateType getGateType() {
        return gateType;
    }
    public int getId() {
        return id;
    }
    public Operator getOperator() {
        return operator;
    }
}
