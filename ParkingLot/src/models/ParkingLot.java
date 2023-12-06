package ParkingLot.src.models;

import java.util.List;

import ParkingLot.src.strategies.SlotAllotmentStrategy;
import ParkingLotBeta.src.strategy.FeeCalculationStrategy;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> floors;
    private List<Gate> entryGates;
    private List<Gate> exitGates;
    private ParkingLotStatus parkingLotStatus;
    private SlotAllotmentStrategy slotAllotmentStrategy;
    private FeeCalculationStrategy feeCalculationStrategy; 
    private List<Vehicle> allowedVehicles;

    public List<Vehicle> getAllowedVehicles() {
        return allowedVehicles;
    }
    public List<Gate> getEntryGates() {
        return entryGates;
    }
    public List<Gate> getExitGates() {
        return exitGates;
    }
    public FeeCalculationStrategy getFeeCalculationStrategy() {
        return feeCalculationStrategy;
    }
    public List<ParkingFloor> getFloors() {
        return floors;
    }
    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }
    public SlotAllotmentStrategy getSlotAllotmentStrategy() {
        return slotAllotmentStrategy;
    }
    

    public void setAllowedVehicles(List<Vehicle> allowedVehicles) {
        this.allowedVehicles = allowedVehicles;
    }
    public void setEntryGates(List<Gate> entryGates) {
        this.entryGates = entryGates;
    }
    public void setExitGates(List<Gate> exitGates) {
        this.exitGates = exitGates;
    }
    public void setFeeCalculationStrategy(FeeCalculationStrategy feeCalculationStrategy) {
        this.feeCalculationStrategy = feeCalculationStrategy;
    }
    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }
    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }
    public void setSlotAllotmentStrategy(SlotAllotmentStrategy slotAllotmentStrategy) {
        this.slotAllotmentStrategy = slotAllotmentStrategy;
    }
    
}
