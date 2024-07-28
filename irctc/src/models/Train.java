package models;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Train extends BaseModel{
    String name;
    Stop startStop;
    Stop endStop;
    List<RouteStop> stops;
    Route route;

    Date startDate;
    Time startTime;

    Date endDate;
    Time endTime;

    TrainJourneyStatus trainJourneyStatus;
    TrainJourney journey;

    List<Compartment> compartements;

    public void setCompartements(List<Compartment> compartements) {
        this.compartements = compartements;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public void setEndStop(Stop endStop) {
        this.endStop = endStop;
    }
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
    public void setJourney(TrainJourney journey) {
        this.journey = journey;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRoute(Route r) {
        this.route = r;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public void setStartStop(Stop startStop) {
        this.startStop = startStop;
    }
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
    public void setStops(List<RouteStop> stops) {
        this.stops = stops;
    }
    public void setTrainJourneyStatus(TrainJourneyStatus trainJourneyStatus) {
        this.trainJourneyStatus = trainJourneyStatus;
    }

    public List<Compartment> getCompartements() {
        return compartements;
    }
    public Date getEndDate() {
        return endDate;
    }
    public Stop getEndStop() {
        return endStop;
    }
    public Time getEndTime() {
        return endTime;
    }
    public TrainJourney getJourney() {
        return journey;
    }
    public String getName() {
        return name;
    }
    public Route getRoute() {
        return route;
    }
    public Date getStartDate() {
        return startDate;
    }
    public Stop getStartStop() {
        return startStop;
    }
    public Time getStartTime() {
        return startTime;
    }
    public List<RouteStop> getStops() {
        return stops;
    }
    public TrainJourneyStatus getTrainJourneyStatus() {
        return trainJourneyStatus;
    }
}