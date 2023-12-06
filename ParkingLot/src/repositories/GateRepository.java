package ParkingLot.src.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import ParkingLot.src.models.Gate;

public class GateRepository {
    static Map<Integer,Gate> gateDB = new HashMap<>();

    public void addGate(Gate g){
        gateDB.putIfAbsent(g.getId(), g);
    }

    public Optional<Gate> findGateByID(int gateID){

        if(!gateDB.containsKey(gateID))
            return Optional.empty();

        return Optional.of(gateDB.get(gateID));
    }
}
