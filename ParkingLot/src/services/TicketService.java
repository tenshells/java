package ParkingLot.src.services;

import java.time.LocalTime;
import java.util.Optional;

import ParkingLot.src.exceptions.GateNotFoundException;
import ParkingLot.src.exceptions.ParkingLotFullException;
import ParkingLot.src.models.Gate;
import ParkingLot.src.models.Operator;
import ParkingLot.src.models.ParkingLot;
import ParkingLot.src.models.ParkingSpot;
import ParkingLot.src.models.ParkingSpotStatus;
import ParkingLot.src.models.Ticket;
import ParkingLot.src.models.Vehicle;
import ParkingLot.src.repositories.GateRepository;
import ParkingLot.src.repositories.TicketRepository;
import ParkingLot.src.repositories.VehicleRepository;
import ParkingLot.src.strategies.SlotAllotment.SlotAllotmentStrategyFactory;
import ParkingLot.src.strategies.interfaces.SlotAllotmentStrategy;

public class TicketService {

    private GateRepository gateRepo;
    private VehicleRepository vehicleRepo;
    private TicketRepository ticketRepo;

    public Ticket issueTicket(Gate g, Vehicle v, Operator o) throws GateNotFoundException, ParkingLotFullException{
    
        gateRepo = new GateRepository();
        vehicleRepo = new VehicleRepository();
        ticketRepo = new TicketRepository();

        // Ticket will need to be set an entry Time and assign a Parking Spot
        
        Optional<Gate> opGate = gateRepo.findGateByID(g.getId());
        
        if(opGate.isEmpty()){
            throw new GateNotFoundException();
        }

        Ticket t = new Ticket();

        t.setEntryGate(g);
        t.setTicketOperator(o);

        // if vehicle not in db, need to add it 
        vehicleRepo.getVehicle(v);
        t.setVehicle(vehicleRepo.getVehicle(v));

        // when issueing ticket, need to assign it a parking Spot using the "SlotAllotmentStrategy"
        ParkingLot p = g.getFloor().getParkingLot();
        SlotAllotmentStrategy strategy = SlotAllotmentStrategyFactory.getSlotAllotmentStrategyForTypeOf(p.getSlotAllotmentStrategyName());
        
        ParkingSpot s = strategy.allotSlot(p, v);
        if(s==null)
            throw new ParkingLotFullException();
        s.setParkingSpotStatus(ParkingSpotStatus.USED);

        t.setParkingSpot(s);
        t.setEntryTime(LocalTime.now());

        //need to add Ticket to db
        ticketRepo.addTicketToDB(t);

        return t;
    }
}
