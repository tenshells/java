package ParkingLot.src.models;

public class ParkingSpot extends BaseModel{
    private VehicleType allowedVehicleType;
    private ParkingFloor floor;
    private int spotNumber;
    private ParkingSpotStatus parkingSpotStatus;

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
    }
    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }
    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }
    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }
    
}
