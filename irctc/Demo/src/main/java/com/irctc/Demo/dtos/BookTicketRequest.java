package com.irctc.Demo.dtos;

import java.util.List;

import com.irctc.Demo.models.Seat;
import com.irctc.Demo.models.Train;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketRequest {
    Train train;
    List<Seat> seats;
}
