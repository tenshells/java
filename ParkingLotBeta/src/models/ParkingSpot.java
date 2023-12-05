package ParkingLotBeta.src.models;

public class ParkingSpot {
    private int id;
    private VehicleType vehicleType;
    private int number;
    private ParkingSpotStatus parkingSpotStatus;
    private int floor;

    public int getFloor() {
        return floor;
    }
    public int getId() {
        return id;
    }
    public int getNumber() {
        return number;
    }
    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public void setFloor(int floor) {
        this.floor = floor;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

}
