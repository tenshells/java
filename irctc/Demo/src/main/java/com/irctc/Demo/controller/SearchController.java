package com.irctc.Demo.controller;


import java.sql.Date;
import java.util.List;

import com.irctc.Demo.dtos.SearchTrainsRequest;
import com.irctc.Demo.dtos.SearchTrainsResponse;
import com.irctc.Demo.models.ResponseStatus;
import com.irctc.Demo.models.Stop;
import com.irctc.Demo.models.Train;
import com.irctc.Demo.services.SearchForTrainsService;

public class SearchController {
    public SearchTrainsResponse searchTrains(SearchTrainsRequest request){
        
        SearchTrainsResponse response = new SearchTrainsResponse();
        
        try{
            Stop start = request.getStartStop();
            Stop endStop = request.getEndStop();
            Date date = request.getDateOfJourney();

            SearchForTrainsService service = new SearchForTrainsService();
            List<Train> trains = service.searchForTrains(start, endStop, date);

            response.setTrains(trains);
        }
        catch(Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage(e.getMessage());
            return response;
        }

        response.setStatus(ResponseStatus.SUCCES);
        return response;

    }

}
