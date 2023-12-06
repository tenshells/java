package ParkingLot.src.strategies.interfaces;

import ParkingLot.src.models.ParkingLot;
import ParkingLot.src.models.ParkingSpot;
import ParkingLot.src.models.Vehicle;

public interface SlotAllotmentStrategy {
    public ParkingSpot allotSlot(ParkingLot p, Vehicle v);
}
