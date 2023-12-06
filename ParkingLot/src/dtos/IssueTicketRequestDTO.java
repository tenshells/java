package ParkingLot.src.dtos;

import ParkingLot.src.models.Gate;
import ParkingLot.src.models.Operator;
import ParkingLot.src.models.Vehicle;

public class IssueTicketRequestDTO{
    private Gate entryGate;
    private Operator operator;
    private Vehicle vehicle;

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }
    public void setOperator(Operator operator) {
        this.operator = operator;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Gate getEntryGate() {
        return entryGate;
    }
    public Operator getOperator() {
        return operator;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
}