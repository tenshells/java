package com.irctc.Demo.services;

import java.sql.Date;
import java.util.List;

import com.irctc.Demo.models.Stop;
import com.irctc.Demo.models.Train;
import com.irctc.Demo.repositories.TrainRepository;

public class SearchForTrainsService {

    TrainRepository trainDB;

    public List<Train> searchForTrains(Stop start, Stop end, Date date){
        trainDB = TrainRepository.getInstance();
        List<Train> trains = trainDB.getTrainsByStopsAndDate(start,end,date);

        return trains;
    }
}
