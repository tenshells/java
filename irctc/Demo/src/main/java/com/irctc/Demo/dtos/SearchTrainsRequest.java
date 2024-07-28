package com.irctc.Demo.dtos;

import java.sql.Date;

import com.irctc.Demo.models.Stop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchTrainsRequest {
    Stop startStop;
    Stop endStop;
    Date dateOfJourney;
}
