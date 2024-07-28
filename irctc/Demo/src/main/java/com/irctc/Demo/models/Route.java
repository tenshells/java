package com.irctc.Demo.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Route extends BaseModel{
    List<RouteStop> stops;
}
