package com.irctc.Demo.models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Compartment extends BaseModel{
    Train train;
    List<Seat> seats;
}
