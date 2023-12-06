package ParkingLot.src.models;

public class Vehicle extends BaseModel{
    private VehicleType vehicleType;
    private int vehicleNumber;
    private String vehicleNumberPrefix;
    private String nameOfOwner;
    private static int totalNumberOfVehicles=0;

    public Vehicle(){
        this.setId(totalNumberOfVehicles);
        totalNumberOfVehicles++;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }
    public int getVehicleNumber() {
        return vehicleNumber;
    }
    public String getVehicleNumberPrefix() {
        return vehicleNumberPrefix;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }
    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public void setVehicleNumberPrefix(String vehicleNumberPrefix) {
        this.vehicleNumberPrefix = vehicleNumberPrefix;
    }

    
}
