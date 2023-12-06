package ParkingLot.src.models;

import java.time.LocalDateTime;

public class ParkingSpot extends BaseModel{
    private VehicleType allowedVehicleType;
    private ParkingFloor floor;
    private int spotNumber;
    private ParkingSpotStatus parkingSpotStatus;
    private static int parkingSpotCount=0;

    public ParkingSpot(){
        this.setId(++parkingSpotCount);
        this.setCreatedOn(LocalDateTime.now());
    }

    public VehicleType getAllowedVehicleType() {
        return allowedVehicleType;
    }
    public ParkingFloor getFloor() {
        return floor;
    }
    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }
    public int getSpotNumber() {
        return spotNumber;
    }
    
    public void setAllowedVehicleType(VehicleType allowedVehicleType) {
        this.allowedVehicleType = allowedVehicleType;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
        this.setUpdatedAt(LocalDateTime.now());
    }
    
}
