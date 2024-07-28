package models;

import java.util.List;

public class Route extends BaseModel{
    List<Stop> stops;

    public List<Stop> getStops() {
        return stops;
    }
    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }
    
}
