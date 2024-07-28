package models;

import java.util.List;

public class Compartment extends BaseModel{
    Train train;
    List<Seat> seats;

    public List<Seat> getSeats() {
        return seats;
    }
    public Train getTrain() {
        return train;
    }
    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
    public void setTrain(Train train) {
        this.train = train;
    }
}
