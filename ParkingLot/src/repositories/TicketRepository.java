package ParkingLot.src.repositories;

import java.util.HashMap;
import java.util.Map;

import ParkingLot.src.models.Ticket;

public class TicketRepository {
    static Map<Integer,Ticket> ticketRepo = new HashMap<>();
    
    public void addTicketToDB(Ticket t){
        ticketRepo.putIfAbsent(t.getId(), t);
    }
}
