package com.irctc.Demo.controller;

import java.util.List;

import com.irctc.Demo.dtos.BookTicketRequest;
import com.irctc.Demo.dtos.BookTicketResponse;
import com.irctc.Demo.models.Seat;
import com.irctc.Demo.models.Train;

public class TicketController {
    public BookTicketResponse bookTicket(BookTicketRequest request){

        BookTicketResponse response = new BookTicketResponse();
        
        try{
            Train train = request.getTrain();
            List<Seat> seats = request.getSeats();

            
        }
        catch(Exception e){
            
        }

        return response;
    }

    
}
