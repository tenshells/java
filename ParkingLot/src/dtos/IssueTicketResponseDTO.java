package ParkingLot.src.dtos;

import ParkingLot.src.models.Ticket;

public class IssueTicketResponseDTO {
    private Ticket ticket;
    private ResponseStatus responseStatus;
    private String responseMessage;

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }
    public Ticket getTicket() {
        return ticket;
    }

}
