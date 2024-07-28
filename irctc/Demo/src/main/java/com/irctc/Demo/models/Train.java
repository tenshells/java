package com.irctc.Demo.models;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Train extends BaseModel{
    String name;
    Stop startStop;
    Stop endStop;
    List<RouteStop> stops;

    Date startDate;
    Time startTime;

    Date endDate;
    Time endTime;

    TrainJourneyStatus trainJourneyStatus;
    TrainJourney journey;

    List<Compartment> compartements;

}