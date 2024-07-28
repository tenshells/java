package models;

import java.sql.Time;

public class BaseModel{
    int id;
    Time createdAt;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Time getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Time createdAt) {
        this.createdAt = createdAt;
    }
    
}