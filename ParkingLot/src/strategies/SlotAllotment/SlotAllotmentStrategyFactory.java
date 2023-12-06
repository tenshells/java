package ParkingLot.src.strategies.SlotAllotment;

import ParkingLot.src.strategies.interfaces.SlotAllotmentStrategy;

public class SlotAllotmentStrategyFactory {
    public static SlotAllotmentStrategy getSlotAllotmentStrategyForTypeOf(SlotAllotmentStrategyName sas){
        if(sas.equals(SlotAllotmentStrategyName.NextFreeSlotAllotmentStrategy)){
            return new NextFreeSlotAllotmentStrategy();
        }
        return null;
    }
}
