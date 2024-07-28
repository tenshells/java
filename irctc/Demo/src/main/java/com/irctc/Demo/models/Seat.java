package com.irctc.Demo.models;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Seat extends BaseModel{
    SeatStatus status;
    Compartment compartment;
    Train train;
    Class seatClass;
}
