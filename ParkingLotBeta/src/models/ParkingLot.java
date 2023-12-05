package ParkingLotBeta.src.models;

import java.util.List;

import ParkingLotBeta.src.strategy.FeeCalculationStrategy;
import ParkingLotBeta.src.strategy.SlotAllotmentStrategy;

public class ParkingLot {
    private int id;
    private List<ParkingFloor> floors;
    private List<Gate> entryGates;
    private List<Gate> exitGates;
    private ParkingLotStatus parkingLotStatus;
    private SlotAllotmentStrategy slotAllotmentStrategy;
    private FeeCalculationStrategy feeCalculationStrategy;
    private List<VehicleType> allowedVehicleTypes;

    public List<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
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
    public int getId() {
        return id;
    }
    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }
    public SlotAllotmentStrategy getSlotAllotmentStrategy() {
        return slotAllotmentStrategy;
    }
    public void setAllowedVehicleTypes(List<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
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
    public void setId(int id) {
        this.id = id;
    }
    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }
    public void setSlotAllotmentStrategy(SlotAllotmentStrategy slotAllotmentStrategy) {
        this.slotAllotmentStrategy = slotAllotmentStrategy;
    }
}
