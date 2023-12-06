package ParkingLot.src.models;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private List<ParkingSpot> spots;
    private ParkingLot parkingLot;
    private int floorNumber;
    private ParkingFloorStatus parkingFloorStatus;

    public int getFloorNumber() {
        return floorNumber;
    }
    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }
    public ParkingLot getParkingLot() {
        return parkingLot;
    }
    public List<ParkingSpot> getSpots() {
        return spots;
    }
    
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }
    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }
}
