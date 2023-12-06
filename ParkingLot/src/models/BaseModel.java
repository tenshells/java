package ParkingLot.src.models;

import java.time.LocalDateTime;

public class BaseModel {
    private int id;
    private LocalDateTime createdOn;
    private LocalDateTime updatedAt;

    BaseModel(){
        this.createdOn=LocalDateTime.now();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
