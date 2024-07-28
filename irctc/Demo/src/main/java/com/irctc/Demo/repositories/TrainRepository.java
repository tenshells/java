package com.irctc.Demo.repositories;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.irctc.Demo.models.RouteStop;
import com.irctc.Demo.models.Stop;
import com.irctc.Demo.models.Train;

public class TrainRepository {

    Map<Integer,Train> trainDB;
    static TrainRepository repo;

    TrainRepository(){
        this.trainDB = new HashMap<>();

        Train t = new Train();
        Stop s1 = new Stop();
        s1.setName("Thrissur");
        s1.setId(1);
        Stop s2 = new Stop();
        s2.setName("Cochin");
        s2.setId(2);

        RouteStop rs1 = new RouteStop();
        rs1.setStop(s1);

        RouteStop rs2 = new RouteStop();
        rs2.setStop(s2);

        List<RouteStop> lrs = new ArrayList<>();
        lrs.add(rs1);
        lrs.add(rs2);

        t.setStops(lrs);
        t.setStartStop(s1);
        t.setEndStop(s2);
        t.setStartDate(new Date(1000000));
        
        trainDB.put(1,t);
    }

    public static TrainRepository getInstance(){
        if(repo==null)
            repo = new TrainRepository();
        return repo;
    }


    public List<Train> getTrainsByStopsAndDate(Stop StartStop,Stop EndStop,Date date){

        Map<Integer,Train> trainDB = TrainRepository.getInstance().trainDB;

        List<Train> responseTrains = new ArrayList<>();
        for(Train t: trainDB.values()){
            boolean gotStartStop = false;
            for(RouteStop s: t.getStops()){
                if(s.getStop().getId()==StartStop.getId()){
                    gotStartStop = true;
                }
                if(s.getStop().getId()==EndStop.getId() && gotStartStop && t.getStartDate().equals(date)){
                    responseTrains.add(t);
                    break;
                }
            }
        }

        return responseTrains;
    }
}
