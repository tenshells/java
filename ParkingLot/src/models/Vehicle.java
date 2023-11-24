package ParkingLot.src.models;

public class Vehicle {
    private int id;
    private int number;
    private VehicleType vehicleType;
    private String nameOfOwner;

    public int getId() {
        return id;
    }
    public String getNameOfOwner() {
        return nameOfOwner;
    }
    public int getNumber() {
        return number;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
