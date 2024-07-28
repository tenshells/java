package com.irctc.Demo.models;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TrainJourney extends BaseModel{
    Train train;
    RouteStop lastStop;
    RouteStop nextStop;
}
