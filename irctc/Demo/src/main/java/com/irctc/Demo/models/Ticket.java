package com.irctc.Demo.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Ticket extends BaseModel{
    Train train;
    Stop startStop;
    Stop endStop;
    List<RouteStop> stops;
    TicketStatus status;
}
