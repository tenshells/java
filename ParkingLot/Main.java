package ParkingLot;



import ParkingLot.src.controllers.TicketController;
import ParkingLot.src.dtos.IssueTicketRequestDTO;
import ParkingLot.src.dtos.IssueTicketResponseDTO;
import ParkingLot.src.dtos.ResponseStatus;
import ParkingLot.src.models.Gate;
import ParkingLot.src.models.GateStatus;
import ParkingLot.src.models.GateType;
import ParkingLot.src.models.Operator;
import ParkingLot.src.models.ParkingFloor;
import ParkingLot.src.models.ParkingFloorStatus;
import ParkingLot.src.models.ParkingLot;
import ParkingLot.src.models.ParkingSpot;
import ParkingLot.src.models.ParkingSpotStatus;
import ParkingLot.src.models.Vehicle;
import ParkingLot.src.models.VehicleType;
import ParkingLot.src.repositories.GateRepository;
import ParkingLot.src.strategies.SlotAllotment.SlotAllotmentStrategyName;
import p.p;

public class Main {
    public static void main(String[] args) {
        //make a trial 

        //make a trial lot, floor, spot
        ParkingLot pl = new ParkingLot();
        ParkingFloor pf1 = new ParkingFloor();
        ParkingFloor pf2 = new ParkingFloor();
        // ParkingFloor pf2 = new ParkingFloor();
        // ParkingFloor pf2 = new ParkingFloor();
        
        for(int i=0;i<40;i++){
            ParkingSpot ps = new ParkingSpot();
            ps.setSpotNumber(i);

            switch(i%2){
                case 0: ps.setParkingSpotStatus(ParkingSpotStatus.FREE); break;
                case 1: ps.setParkingSpotStatus(ParkingSpotStatus.USED); break;
            }

            switch(i%5){
                case 0: ps.setAllowedVehicleType(VehicleType.BIKE); break;
                case 1: ps.setAllowedVehicleType(VehicleType.BUS); break;
                case 2: ps.setAllowedVehicleType(VehicleType.TRUCK); break;
                case 3: ps.setAllowedVehicleType(VehicleType.CAR); break;
                case 4: ps.setAllowedVehicleType(VehicleType.CYCLE); break;
            }

            switch(i/10){
                case 0: ps.setFloor(pf1); pf1.addSpot(ps); break;
                case 1: ps.setFloor(pf2); pf2.addSpot(ps); break;
                case 2: ps.setFloor(pf2); pf2.addSpot(ps); break;
                case 3: ps.setFloor(pf2); pf2.addSpot(ps); break;
            }
        }

        pf1.setParkingFloorStatus(ParkingFloorStatus.OPEN);
        pf2.setParkingFloorStatus(ParkingFloorStatus.OPEN);

        pf1.setFloorNumber(1);
        pf2.setFloorNumber(2);

        pf1.setParkingLot(pl);
        pf2.setParkingLot(pl);

        pl.getFloors().add(pf1);
        pl.getFloors().add(pf2);
        pl.setSlotAllotmentStrategyName(SlotAllotmentStrategyName.NextFreeSlotAllotmentStrategy);

        //make a trial gate,operator
        Gate entryGate = new Gate(GateType.ENTRY);
        // Gate exitGate = new Gate(GateType.EXIT);

        entryGate.setFloor(pf2);
        entryGate.setGateStatus(GateStatus.OPEN);
        entryGate.setGateNumber(1);

        GateRepository gateRepo = new GateRepository();
        gateRepo.addGate(entryGate);

        Operator opp = new Operator();
        opp.setOperatorName("3$HA");
        opp.setEmpId(6119);
        
        entryGate.setOperator(opp);

        Vehicle v1 = new Vehicle();
        v1.setNameOfOwner("$OB!N");
        v1.setVehicleNumber(1300135);
        v1.setVehicleNumberPrefix("KL07");
        v1.setVehicleType(VehicleType.CAR);

        Vehicle v2 = new Vehicle();
        v2.setNameOfOwner("AALUTTAN");
        v2.setVehicleNumber(1234);
        v2.setVehicleNumberPrefix("KL45");
        v2.setVehicleType(VehicleType.CYCLE);

        Vehicle v3 = new Vehicle();
        v3.setNameOfOwner("Dany Chiramal");
        v3.setVehicleNumber(9999);
        v3.setVehicleNumberPrefix("KL45");
        v3.setVehicleType(VehicleType.CAR);

        Vehicle v4 = new Vehicle();
        v4.setNameOfOwner("unni");
        v4.setVehicleNumber(6969);
        v4.setVehicleNumberPrefix("KL66");
        v4.setVehicleType(VehicleType.BIKE);

        TicketController tc = new TicketController();

        issueTicketMain(tc,entryGate,opp,v1);
        issueTicketMain(tc,entryGate,opp,v2);
        issueTicketMain(tc,entryGate,opp,v3);
        issueTicketMain(tc,entryGate,opp,v4);
    }

    public static void issueTicketMain(TicketController tc, Gate entryGate, Operator opp, Vehicle v1){

        IssueTicketRequestDTO request = new IssueTicketRequestDTO();

        request.setEntryGate(entryGate);
        request.setOperator(opp);
        request.setVehicle(v1);

        IssueTicketResponseDTO response = tc.IssueTicket(request);

        int t_id = response.getTicket().getId();
        ParkingSpot ps = response.getTicket().getParkingSpot();

        if(response.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            p.printl("Successfully created Ticket#"+t_id+" for "+v1.getNameOfOwner()+"'s "+v1.getVehicleNumberPrefix()+v1.getVehicleType()+""+v1.getVehicleNumber()+" at "+ps.getId()+" in floor no. "+ps.getFloor().getFloorNumber());
        }
        else{
            p.printl("Could not get ticket for "+v1.getNameOfOwner()+"'s "+v1.getVehicleType());
        }
    }
}
