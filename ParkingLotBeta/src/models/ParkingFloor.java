package ParkingLotBeta.src.models;

import java.util.List;

public class ParkingFloor {
    private List<ParkingSpot> spots;
    private FloorStatus floorStatus;
    private int floorNumber;
    private int id;

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    public void setFloorStatus(FloorStatus floorStatus) {
        this.floorStatus = floorStatus;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }
    public int getFloorNumber() {
        return floorNumber;
    }
    public FloorStatus getFloorStatus() {
        return floorStatus;
    }
    public int getId() {
        return id;
    }
    public List<ParkingSpot> getSpots() {
        return spots;
    }
}
