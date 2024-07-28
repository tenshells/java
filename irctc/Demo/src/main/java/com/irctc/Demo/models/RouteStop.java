package com.irctc.Demo.models;

import java.sql.Time;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RouteStop extends BaseModel{
    Stop stop;
    Time exStopTime;
}
