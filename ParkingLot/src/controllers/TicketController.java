package ParkingLot.src.controllers;

import ParkingLot.src.dtos.IssueTicketRequestDTO;
import ParkingLot.src.dtos.IssueTicketResponseDTO;
import ParkingLot.src.dtos.ResponseStatus;
import ParkingLot.src.exceptions.GateNotFoundException;
import ParkingLot.src.exceptions.ParkingLotFullException;
import ParkingLot.src.models.Ticket;
import ParkingLot.src.services.TicketService;

public class TicketController {
    
    public IssueTicketResponseDTO IssueTicket(IssueTicketRequestDTO request){

        // a Vehicle enters a Gate with an Operator in it

        // need to issue a Ticket

        TicketService ticketService = new TicketService();
        IssueTicketResponseDTO response = new IssueTicketResponseDTO();

        try {
            Ticket tt = ticketService.issueTicket(request.getEntryGate(),request.getVehicle(),request.getOperator());
            response.setTicket(tt);
        } catch (GateNotFoundException e) {
            response.setResponseStatus(ResponseStatus.FAILED);
            response.setResponseMessage(e.getMessage());
            System.out.println("Gate not found..");
            return response;
        } catch (ParkingLotFullException e){
            response.setResponseMessage(e.getLocalizedMessage());
            response.setResponseStatus(ResponseStatus.FAILED);
            System.out.println("Parking Lot Full.. ");
            return response;
        } catch (Exception e){
            response.setResponseMessage(e.getMessage());
            response.setResponseStatus(ResponseStatus.FAILED);
            System.out.println("ticket Service not up! ");

            return response;
        }

        
        // Need to return IssueTicketResponse which will have a Ticket

        response.setResponseStatus(ResponseStatus.SUCCESS);
        
        return response;
    }
}
