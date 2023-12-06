package ParkingLot.src.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ParkingLot.src.strategies.SlotAllotment.SlotAllotmentStrategyName;
import ParkingLot.src.strategies.interfaces.SlotAllotmentStrategy;
import ParkingLotBeta.src.strategy.FeeCalculationStrategy;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> floors;
    private List<Gate> entryGates;
    private List<Gate> exitGates;
    private ParkingLotStatus parkingLotStatus;
    private SlotAllotmentStrategyName slotAllotmentStrategyName;
    private SlotAllotmentStrategy slotAllotmentStrategy;
    private FeeCalculationStrategy feeCalculationStrategy; 
    private List<Vehicle> allowedVehicles;
    private static int parkingLotCount=0;

    public ParkingLot(){
        this.floors = new ArrayList<>();
        this.entryGates = new ArrayList<>();
        this.exitGates = new ArrayList<>();
        this.setId(++parkingLotCount);
        this.setCreatedOn(LocalDateTime.now());
    }

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
    public SlotAllotmentStrategyName getSlotAllotmentStrategyName() {
        return slotAllotmentStrategyName;
    }
    

    public void setAllowedVehicles(List<Vehicle> allowedVehicles) {
        this.allowedVehicles = allowedVehicles;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setEntryGates(List<Gate> entryGates) {
        this.entryGates = entryGates;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setExitGates(List<Gate> exitGates) {
        this.exitGates = exitGates;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setFeeCalculationStrategy(FeeCalculationStrategy feeCalculationStrategy) {
        this.feeCalculationStrategy = feeCalculationStrategy;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setSlotAllotmentStrategy(SlotAllotmentStrategy slotAllotmentStrategy) {
        this.slotAllotmentStrategy = slotAllotmentStrategy;
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void setSlotAllotmentStrategyName(SlotAllotmentStrategyName slotAllotmentStrategyName) {
        this.slotAllotmentStrategyName = slotAllotmentStrategyName;
        this.setUpdatedAt(LocalDateTime.now());
    }
    
}
