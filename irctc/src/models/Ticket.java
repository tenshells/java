package models;

public class Ticket extends BaseModel{
    Train train;
    Stop startStop;
    Stop endStop;

    public Train getTrain() {
        return train;
    }
    public Stop getStartStop() {
        return startStop;
    }
    public Stop getEndStop() {
        return endStop;
    }
    public void setEndStop(Stop endStop) {
        this.endStop = endStop;
    }
    public void setStartStop(Stop startStop) {
        this.startStop = startStop;
    }
    public void setTrain(Train train) {
        this.train = train;
    }
}
