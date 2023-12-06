package ParkingLot.src.repositories;

import java.util.HashMap;
import java.util.Map;

import ParkingLot.src.models.Vehicle;

public class VehicleRepository {
    static Map<Integer,Vehicle> vehicleRepo = new HashMap<>();

    public Vehicle getVehicle(Vehicle v){
        if(vehicleRepo.containsKey(v.getId())){
            return vehicleRepo.get(v.getId());
        }
        else{
            vehicleRepo.put(v.getId(),v);
            return vehicleRepo.get(v.getId());
        }
    }
}
