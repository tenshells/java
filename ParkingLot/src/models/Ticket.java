package ParkingLot.src.models;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ticket extends BaseModel{
    private LocalTime entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Gate entryGate;
    private Operator ticketOperator;
    private static int totaltickets = 0;

    public Ticket(){
        this.setId(++totaltickets);
        this.setCreatedOn(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());    
    }

    public Gate getEntryGate() {
        return entryGate;
    }
    public LocalTime getEntryTime() {
        return entryTime;
    }
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
    public Operator getTicketOperator() {
        return ticketOperator;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }
    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
   }
   public void setParkingSpot(ParkingSpot parkingSpot) {
       this.parkingSpot = parkingSpot;
   }
   public void setTicketOperator(Operator ticketOperator) {
       this.ticketOperator = ticketOperator;
   }
   public void setVehicle(Vehicle vehicle) {
       this.vehicle = vehicle;
   }
}
