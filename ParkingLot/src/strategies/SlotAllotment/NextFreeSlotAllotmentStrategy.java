package ParkingLot.src.strategies.SlotAllotment;

import ParkingLot.src.models.ParkingFloor;
import ParkingLot.src.models.ParkingLot;
import ParkingLot.src.models.ParkingSpot;
import ParkingLot.src.models.ParkingSpotStatus;
import ParkingLot.src.models.Vehicle;
import ParkingLot.src.strategies.interfaces.SlotAllotmentStrategy;

public class NextFreeSlotAllotmentStrategy implements SlotAllotmentStrategy{

    @Override
    public ParkingSpot allotSlot(ParkingLot p, Vehicle v) {
        for(ParkingFloor f: p.getFloors()){
            for(ParkingSpot s: f.getSpots()){
                if(s.getAllowedVehicleType().equals(v.getVehicleType())){
                    if(s.getParkingSpotStatus().equals(ParkingSpotStatus.FREE)){
                        return s;
                    }
                }
            }
        }
        
        return null;
    }

}
