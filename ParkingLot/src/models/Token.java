package ParkingLot.src.models;

import java.sql.Time;

public class Token {
    private int id;
    private Time time;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Gate entryGate;
    private Operator operator;

    public Gate getEntryGate() {
        return entryGate;
    }
    public int getId() {
        return id;
    }
    public Operator getOperator() {
        return operator;
    }
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
    public Time getTime() {
        return time;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setOperator(Operator operator) {
        this.operator = operator;
    }
    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
    public void setTime(Time time) {
        this.time = time;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
