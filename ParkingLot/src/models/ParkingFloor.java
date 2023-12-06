package ParkingLot.src.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingFloor extends BaseModel{
    private List<ParkingSpot> spots;
    private ParkingLot parkingLot;
    private int floorNumber;
    private ParkingFloorStatus parkingFloorStatus;
    private static int parkingFloorCount;

    public ParkingFloor(){
        this.spots = new ArrayList<>();
        this.setId(++parkingFloorCount);
        this.setCreatedOn(LocalDateTime.now());
    }

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
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void addSpot(ParkingSpot s){
        this.spots.add(s);
        this.setUpdatedAt(LocalDateTime.now());
    }
}
